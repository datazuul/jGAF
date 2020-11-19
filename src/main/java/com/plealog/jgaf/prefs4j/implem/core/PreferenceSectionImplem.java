package com.plealog.jgaf.prefs4j.implem.core;

import com.plealog.jgaf.prefs4j.api.DataConnector;
import com.plealog.jgaf.prefs4j.api.PreferenceException;
import com.plealog.jgaf.prefs4j.api.PreferenceSection;
import com.plealog.jgaf.prefs4j.ui.PreferenceEditor;
import javax.swing.ImageIcon;

/** This class defines a configuration feature implementation. */
public class PreferenceSectionImplem implements PreferenceSection {
  private String _id;
  private ImageIcon _icon;
  private String _resourceLocator;
  private String _descriptorLocator;
  private String _configLocator;
  private String _defaultConfigLocator;
  private String _name;
  private String _confType = PreferenceEditor.TYPE.kvp.toString();
  private String _parent;
  private DataConnector _dataConnector;

  public static final String ROOT_NODE = "root";

  @SuppressWarnings("unused")
  private PreferenceSectionImplem() {}

  public PreferenceSectionImplem(String id) {
    _id = id;
  }

  public void check() throws PreferenceException {
    if (_name == null) throw new PreferenceException("section " + _id + ": name is missing");
    if (_dataConnector == null)
      throw new PreferenceException("section " + _id + ": type is missing");
    if (_dataConnector.getType().equals(DataConnector.TYPE.none) == false && _configLocator == null)
      throw new PreferenceException("section " + _id + ": configuration file is missing");
    if ((_dataConnector.getType().equals(DataConnector.TYPE.props) && _descriptorLocator == null))
      throw new PreferenceException("section " + _id + ": descriptor file is missing");
    if (_configLocator != null && _configLocator.equals(_defaultConfigLocator)) {
      throw new PreferenceException(
          "section " + _id + ": config and default config cannot refer to same locator");
    }
  }
  /** Returns the icon of this configuration object. */
  public ImageIcon getIcon() {
    return _icon;
  }

  /** Sets the icon of this configuration object. */
  public void setIcon(ImageIcon icon) {
    this._icon = icon;
  }

  /** Gets the absolute path pointing to the resource containing localized messages. */
  public String getResourceLocator() {
    return _resourceLocator;
  }
  /** Sets the absolute path pointing to the resource containing localized messages. */
  public void setResourceLocator(String pathToResources) {
    this._resourceLocator = pathToResources;
  }
  /** Gets the absolute path pointing to the resource containing a set of properties. */
  public String getConfigurationLocator() {
    return _configLocator;
  }
  /** Sets the absolute path pointing to the resource containing a set of properties. */
  public void setConfigurationLocator(String pathToConfig) {
    this._configLocator = pathToConfig;
  }
  /** Gets the URL pointing to the resource describing a set of properties. */
  public String getDescriptorLocator() {
    return _descriptorLocator;
  }
  /** Sets the URL pointing to the resource describing a set of properties. */
  public void setDescriptorLocator(String pathToDescriptor) {
    this._descriptorLocator = pathToDescriptor;
  }

  /** Gets the absolute path pointing to the resource containing a set of default properties. */
  public String getDefaultConfigurationLocator() {
    return _defaultConfigLocator;
  }

  /** Returns the absolute path pointing to the resource containing a set of default properties. */
  public void setDefaultConfigurationLocator(String pathToDefaultConfig) {
    this._defaultConfigLocator = pathToDefaultConfig;
  }

  /** Returns the configuration type. Returns one of the XXX_CONFIG values. */
  public String getConfType() {
    return _confType;
  }

  /** Sets the configuration type. Use one of the XXX_CONFIG values. */
  public void setConfType(String confType) {
    _confType = confType;
  }

  /** Returns the name of this Configuration object. */
  public String getName() {
    return _name;
  }

  /** Sets the name to this Configuration object. */
  public void setName(String name) {
    _name = name;
  }

  public DataConnector getDataConnector() {
    return _dataConnector;
  }

  public void setDataConnector(DataConnector dataConnector) {
    this._dataConnector = dataConnector;
  }

  public String getParentId() {
    return _parent;
  }

  public void setParent(String parent) {
    if (parent != null && parent.length() > 0) _parent = parent;
    else _parent = ROOT_NODE;
  }

  public String getId() {
    return _id;
  }

  public String toString() {
    return getName();
  }
}
