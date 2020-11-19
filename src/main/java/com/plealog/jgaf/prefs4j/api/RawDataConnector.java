package com.plealog.jgaf.prefs4j.api;

import java.io.IOException;

/** Defines a data connector capable of serializing standard Java String objects. */
public interface RawDataConnector extends DataConnector {

  /**
   * Saves a String. Please note that this String may be huge in size. It's up to the implementation
   * to handle it.
   *
   * @param locator the place where to save the String.
   * @param data the data to save
   * @throws IOException when serialization fails.
   */
  public void save(String locator, String data) throws IOException;

  /**
   * Loads a String. Please note that this String may be huge in size. It's up to the implementation
   * to handle it.
   *
   * @param locator the place where to load the String.
   * @return the String read from locator
   * @throws IOException when serialization fails.
   */
  public String load(String locator) throws IOException;
}
