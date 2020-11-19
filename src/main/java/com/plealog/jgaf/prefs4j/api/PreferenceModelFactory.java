package com.plealog.jgaf.prefs4j.api;

import com.plealog.jgaf.prefs4j.implem.core.PreferenceModelImplem;

/** This class can be used to create concrete PreferenceModel instances. */
public class PreferenceModelFactory {
  private PreferenceModelFactory() {}
  /**
   * Creates a new PreferenceModel instance.
   *
   * @param masterPrefLocator the location to the master preference descriptor file. Use absolute
   *     file path.
   */
  public static PreferenceModel getModel(String masterPrefLocator) {
    return new PreferenceModelImplem(masterPrefLocator);
  }
  /**
   * Creates a new PreferenceModel instance capable of handling a separation location to handle
   * user-defined specific preferences.
   *
   * @param masterPrefLocator the location to the master preference descriptor file. Use absolute
   *     file path.
   * @param userPrefLocator the location handling user-specific configuration files.
   */
  public static PreferenceModel getModel(String masterPrefLocator, String userPrefLocator) {
    return new PreferenceModelImplem(masterPrefLocator, userPrefLocator);
  }
}
