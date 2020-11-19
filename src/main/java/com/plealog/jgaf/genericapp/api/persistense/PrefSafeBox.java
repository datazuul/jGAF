package com.plealog.jgaf.genericapp.api.persistense;

import com.plealog.jgaf.genericapp.api.EZApplicationBranding;
import com.plealog.jgaf.genericapp.api.log.EZLogger;
import com.plealog.jgaf.genericapp.protection.distrib.HStringUtils;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PrefSafeBox {
  private Preferences _prefs;
  private Properties _props;
  private String _node;
  private boolean _useEncyption = false;

  public PrefSafeBox() {
    _node = EZApplicationBranding.getAppName();
    _props = new Properties();
    load();
  }

  public String getProperty(String key) {
    String value;
    if (key != null) {
      value = _props.getProperty(key, null);
    } else {
      value = null;
    }
    return value;
  }

  public List<String> getPropertyKeys() {
    ArrayList<String> props = new ArrayList<>();
    for (Object key : _props.keySet()) {
      props.add(key.toString());
    }
    return props;
  }

  public void setProperty(String key, String value) {
    if (key != null && value != null) {
      _props.setProperty(key, value);
    }
  }

  public void removeProperty(String key) {
    if (key != null) _props.remove(key);
  }

  public void load() {
    String[] keys;
    String key, val;
    int i;

    if (!exists()) return;
    try {
      if (_prefs == null) {
        _prefs = Preferences.userRoot().node(_node);
      }
      keys = _prefs.keys();
      for (i = 0; i < keys.length; i++) {
        key = keys[i];
        val = (String) _prefs.get(key, null);
        _props.setProperty(
            _useEncyption ? HStringUtils.decryptHexString(key) : key,
            _useEncyption ? HStringUtils.decryptHexString(val) : val);
      }
    } catch (Exception ex) {
      EZLogger.warn("unable to relaod Persistense Data: " + ex);
    }
  }

  public void save() {
    Enumeration<Object> e;
    String key, val;

    try {
      if (_prefs == null) {
        _prefs = Preferences.userRoot().node(_node);
      }
      _prefs.clear(); // this is to take into account removeproperty()
      // this exception has been hidden: flush() works on windows and linux
      // but not very well on Mac (depending on JRE flush() may work or not !!!)
      try {
        _prefs.flush();
      } catch (Exception ex) {
      }
      for (e = _props.keys(); e.hasMoreElements(); ) {
        key = (String) e.nextElement();
        val = (String) _props.get(key);
        _prefs.put(
            _useEncyption ? HStringUtils.encryptHexString(key) : key,
            _useEncyption ? HStringUtils.encryptHexString(val) : val);
      }
      // this exception has been hidden: flush() works on windows and linux
      // but not very well on Mac (depending on JRE flush() may work or not !!!)
      try {
        _prefs.flush();
      } catch (Exception ex) {
      }
    } catch (Exception ex) {
      EZLogger.warn("unable to save Persistense Data: " + ex);
    }
  }

  public boolean exists() {
    boolean bRet = false;
    Preferences prefs;

    try {
      prefs = Preferences.userRoot();
      bRet = prefs.nodeExists(_node);
    } catch (Exception ex) {
      EZLogger.warn("unable to check Persistense Data");
    }

    return bRet;
  }

  public void uninstall() {
    _props.clear();
    try {
      _prefs.removeNode();
    } catch (BackingStoreException e) {
    }
    _prefs = null;
  }
}
