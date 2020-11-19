package com.plealog.jgaf.genericapp.api.protection;

import com.plealog.jgaf.genericapp.protection.distrib.LicenseKeyProtector;

/** The control model which enables to setup user name and associated license key. */
public final class ControllerModel {
  private static LicenseKeyProtector _LicenseKeyProtector;

  /**
   * Use this method to setup the controller model.
   *
   * @param licenseKey the license key
   * @param userName the user name
   */
  public static final void setLicenseKeyProtectorModel(String licenseKey, String userName) {
    _LicenseKeyProtector = new LicenseKeyProtector(licenseKey, userName);
  }

  /**
   * Returns the Protector of the library.
   *
   * @return current protector class.
   */
  protected static final Protector getLicenseKeyProtector() {
    return _LicenseKeyProtector;
  }
}
