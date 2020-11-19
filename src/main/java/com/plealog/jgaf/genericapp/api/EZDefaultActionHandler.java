package com.plealog.jgaf.genericapp.api;

/**
 * This interface defines the way to handle default application actions About, Exit and Preferences.
 */
public interface EZDefaultActionHandler {

  /** Handles the About application action. */
  public void handleAbout();

  /**
   * Handles the Exit application action. When creating a implementation of this method, please do
   * not forget to conform to {@link EZEnvironment#confirmBeforeExit()} method.
   *
   * @return to handle MacOS X integration, implementation should return true if application can
   *     exit. Use false otherwise. For all other operating systems, this method can use
   *     System.exit() method to finish application.
   */
  public boolean handleExit();

  /** Handles the Preferences application action. */
  public void handlePreferences();
}
