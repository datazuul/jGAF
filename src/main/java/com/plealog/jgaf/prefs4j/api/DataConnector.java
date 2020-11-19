package com.plealog.jgaf.prefs4j.api;

/**
 * Defines the way an editor can access data in read/write mode. <br>
 * <br>
 * The framework defines three standard data connectors defined by the TYPE enum. props connector
 * type can handle configuration data contained in a standard Java Properties object; see
 * PropertiesDataConnector. raw connector type can handle configuration data contained in a standard
 * String object; see RawDataConnector. none can be used as a null data connector, i.e. when there
 * is no need to read/write configuration data. Such data connector is used by the TYPE.none
 * Configuration editor.
 */
public interface DataConnector {
  /**
   * Default types of Data Connector available in the Framework. User-defined data connectors may be
   * added using DataConnectorFactory.registerDataConnector().
   */
  public static enum TYPE {
    /** A data connector aims at handling Java Properties. */
    props,
    /** A data connector aims at handling Java Strings. */
    raw,
    /**
     * No data connector. Can be used when a PreferenceSection is empty, i.e. is not associated to
     * any data.
     */
    none
  }

  /** Returns the type of this data connector. */
  public TYPE getType();

  /** Creates a new instance from this editor. */
  public DataConnector newInstance();

  /** Checks whether or not caller is authorized to use locator to write configuraton. */
  public boolean canWrite(String locator);

  /** Checks whether or not caller is authorized to use locator to read configuraton. */
  public boolean canRead(String locator);
}
