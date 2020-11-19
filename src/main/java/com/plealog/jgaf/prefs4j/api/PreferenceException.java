package com.plealog.jgaf.prefs4j.api;

/** This is the main type of exception thrown by the Preference framework. */
public class PreferenceException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public PreferenceException(String msg) {
    super(msg);
  }
}
