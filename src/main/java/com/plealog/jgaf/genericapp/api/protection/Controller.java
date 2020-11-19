package com.plealog.jgaf.genericapp.api.protection;

/**
 * Use this class to control application protection. It relies on a protection model. First, setup a
 * protection model using ControllerModel, then in the rest of the application, retrieve the
 * Protector from this class and check its validity.
 */
public final class Controller {
  /**
   * Returns the Protector of the library.
   *
   * @return the Protector of the library.
   */
  public static final Protector getProtector() {
    return ControllerModel.getLicenseKeyProtector();
  }
}
