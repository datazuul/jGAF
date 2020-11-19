package com.plealog.jgaf.prefs4j.api;

import java.io.IOException;
import java.util.Properties;

/** Defines a data connector capable of serializing standard Java Properties objects. */
public interface PropertiesDataConnector extends DataConnector {

  /**
   * Saves a Properties.
   *
   * @param locator the place where to save the Properties.
   * @param props the properties to save
   * @throws IOException when serialization fails.
   */
  public void save(String locator, Properties props) throws IOException;

  /**
   * Loads a Properties.
   *
   * @param locator the place where to read the Properties. It's up to the implementation to figure
   *     out how to interpret the content of the locator String.
   * @return the properties read from locator
   * @throws IOException when serialization fails.
   */
  public Properties load(String locator) throws IOException;
}
