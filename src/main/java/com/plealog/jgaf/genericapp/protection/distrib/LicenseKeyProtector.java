package com.plealog.jgaf.genericapp.protection.distrib;

import com.plealog.jgaf.genericapp.api.protection.Protector;

/** Concrete implementation of a Protector relying on a user-name and license key pair of values. */
public final class LicenseKeyProtector implements Protector {
  private String _licenseKey;
  private String _userName;

  private LicenseKeyProtector() {
    super();
  }

  public LicenseKeyProtector(String licenseKey, String userName) {
    this();
    this._licenseKey = licenseKey;
    this._userName = userName;
  }

  private final boolean hasKeys() {
    return (_licenseKey != null && _userName != null);
  }

  private final boolean isLibraryOk() {
    return _licenseKey.equals(LicenseKeyController.generate(_userName));
  }

  @Override
  public final boolean isLibraryInvalid() {
    if (hasKeys()) {
      return !isLibraryOk();
    } else {
      return false;
    }
  }

  @Override
  public boolean isLibraryExpired() {
    return LibraryDateProtectorController.libExpired();
  }
}
