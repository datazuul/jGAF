package com.plealog.jgaf.genericapp.api.protection;

/** Protector of the library. */
public interface Protector {
  /**
   * Figures out whether or not the library is valid for use.
   *
   * @return false if invalid, true otherwise.
   */
  public boolean isLibraryInvalid();
  /**
   * Figures out whether or not the library has expired.
   *
   * @return true if expired, false otherwise.
   */
  public boolean isLibraryExpired();
}
