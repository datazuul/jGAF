package com.plealog.jgaf.prefs4j.api;

import javax.swing.ImageIcon;

/**
 * This interface defines a preference section. When considering the Preference Dialogue Box, such a
 * section consists in a configuration page associated to a Preference Section Node. Each Preference
 * Section is associated to a Framework Descriptor File.
 */
public interface PreferenceSection {
  /** Returns the name of this section. */
  public String getName();
  /** Returns the unique ID of this section. */
  public String getId();
  /** Returns the parent ID of this section. */
  public String getParentId();
  /** Returns the icon of this section. May be null. */
  public ImageIcon getIcon();
  /** Returns the absolute path to a resource file. May be null. */
  public String getResourceLocator();
  /**
   * Returns the absolute path to the configuration file that contains Section's configuration
   * values. Cannot be null.
   */
  public String getConfigurationLocator();
  /**
   * Returns the absolute path to the Descriptor file that defines the data model of this section.
   * Cannot be null.
   */
  public String getDescriptorLocator();
  /**
   * Returns the absolute path to the configuration file that contains Section's configuration
   * default values. May be null.
   */
  public String getDefaultConfigurationLocator();
  /**
   * Returns the type of this section.
   *
   * @return one of DataConnector.TYPE values, or any additional user-defined values registered
   *     through DataConnectorFactory.registerDataConnector(String, dataConnector).
   */
  public String getConfType();
  /** Returns the DataConnector instance object associated to this section. */
  public DataConnector getDataConnector();
}
