package com.plealog.jgaf.prefs4j.implem.ui.components;

import com.plealog.jgaf.genericapp.api.EZEnvironment;
import com.plealog.jgaf.prefs4j.api.DataConnector;
import com.plealog.jgaf.prefs4j.api.PreferenceException;
import com.plealog.jgaf.prefs4j.api.PreferenceSection;
import com.plealog.jgaf.prefs4j.api.PropertiesDataConnector;
import com.plealog.jgaf.prefs4j.implem.ui.model.PropertiesModel;
import com.plealog.jgaf.prefs4j.ui.PreferenceEditor;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import javax.swing.JComponent;

/**
 * This class implements a Configuration Editor that is designed to edit key value pairs.
 *
 * @author Patrick G. Durand
 */
public class PropertiesEditor implements PreferenceEditor {
  PropertiesPanel _editor;
  PreferenceSection _conf;

  public PropertiesEditor() {}

  public PropertiesEditor(PreferenceSection co) {
    this(co, new HashSet<PreferenceEditor.PROPERTY>());
  }

  public PropertiesEditor(PreferenceSection co, HashSet<PreferenceEditor.PROPERTY> props) {
    if (co == null || !co.getConfType().equalsIgnoreCase(PreferenceEditor.TYPE.kvp.toString()))
      throw new PreferenceException("PropertiesEditor: argument is null or invalid");
    _conf = co;
    init(co, props);
  }

  private void init(PreferenceSection co, HashSet<PreferenceEditor.PROPERTY> props) {
    PropertiesModel model;
    Properties data, defaultProps;

    model = getModel(co);
    if (model == null) return;
    _editor = new PropertiesPanel(model, co, props);
    data = getData(co, model);
    if (props != null) {
      _editor.setValues(data);
    }
    defaultProps = getDefaultData(co, model);
    if (props != null) {
      _editor.setDefaultValues(defaultProps);
    }
  }

  private PropertiesModel getModel(PreferenceSection co) {
    PropertiesModel pModel = null;
    InputStream is1 = null, is2 = null;

    try {
      if (co.getResourceLocator() != null) {
        is1 = new FileInputStream(co.getResourceLocator());
      }
      is2 = new FileInputStream(co.getDescriptorLocator());
      pModel =
          new PropertiesModel(
              is1 != null ? new PropertyResourceBundle(is1) : null,
              new PropertyResourceBundle(is2));

      is2.close();
    } catch (Exception e) {
      throw new PreferenceException(
          EZEnvironment.getMessage("__EZConfDlf.err.getDescriptorModel")
              + ": "
              + co.getName()
              + ": "
              + e);
    } finally {
      try {
        if (is1 != null) {
          is1.close();
        }
      } catch (Exception ex) {
      }
      try {
        if (is2 != null) {
          is2.close();
        }
      } catch (Exception ex) {
      }
    }

    return pModel;
  }

  private Properties getData(PreferenceSection co, PropertiesModel model) {
    Properties props = null;
    DataConnector conn;

    try {
      conn = _conf.getDataConnector();
      if (conn instanceof PropertiesDataConnector == false) {
        throw new Exception("invalid DataConnector: expected a PropertiesDataConnector");
      }
      props = ((PropertiesDataConnector) conn).load(co.getConfigurationLocator());
    } catch (Exception e) {
      throw new PreferenceException(
          EZEnvironment.getMessage("__EZConfDlf.err.getData")
              + ": "
              + model.getName()
              + ": "
              + co.getConfigurationLocator()
              + ": "
              + e);
    }

    return props;
  }

  private Properties getDefaultData(PreferenceSection co, PropertiesModel model) {
    Properties props = null;
    DataConnector conn;

    if (co.getDefaultConfigurationLocator() == null) return null;
    try {
      conn = _conf.getDataConnector();
      if (conn instanceof PropertiesDataConnector == false) {
        throw new Exception("invalid DataConnector: expected a PropertiesDataConnector");
      }
      props = ((PropertiesDataConnector) conn).load(co.getDefaultConfigurationLocator());
    } catch (Exception e) {
      throw new PreferenceException(
          EZEnvironment.getMessage("__EZConfDlf.err.getData")
              + ": "
              + model.getName()
              + ": "
              + co.getDefaultConfigurationLocator()
              + ": "
              + e);
    }

    return props;
  }

  public PreferenceEditor newInstance(
      PreferenceSection co, HashSet<PreferenceEditor.PROPERTY> props) {
    return new PropertiesEditor(co, props);
  }

  public String getName() {
    return (_editor == null ? "?" : _editor.getName());
  }

  public JComponent getEditor() {
    return _editor;
  }

  public boolean isEdited() {
    return (_editor == null ? false : _editor.isEdited());
  }

  public void editorShowed() {
    _editor.setHelpAreaText(EZEnvironment.getMessage("__EZPropertiesEditor.msg1"));
  }

  public PreferenceSection getPreferenceSection() {
    return _conf;
  }

  public void saveData() throws PreferenceException {
    _editor.saveData(_conf.getConfigurationLocator());
  }
}
