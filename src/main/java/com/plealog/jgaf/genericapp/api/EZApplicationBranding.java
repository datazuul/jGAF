package com.plealog.jgaf.genericapp.api;

import com.plealog.jgaf.genericapp.ui.apple.EZAppleConfigurator;
import javax.swing.ImageIcon;

/**
 * Contains the branding of the application. This class is used as a singleton, so use static setter
 * methods. If not used, this class automatically defines application name and version using library
 * branding.
 */
public class EZApplicationBranding {

  private static String _appName = EZEnvironment.getMessage("__EZ.appname");
  private static String _appVersion = EZEnvironment.getMessage("__EZ.appversion");
  private static String _providerName = EZEnvironment.getMessage("__EZ.provider");
  private static String _copyright =
      EZEnvironment.getMessage("__EZ.copyright") + " - " + _providerName;
  private static ImageIcon _appIcon =
      EZEnvironment.getImageIcon(EZEnvironment.getMessage("__EZ.appicon"));

  private EZApplicationBranding() {}

  /** Sets the application name. */
  public static void setAppName(String name) {
    if (name != null && name.length() > 0) {
      _appName = name;
    }
  }

  /** Gets the application name. */
  public static String getAppName() {
    return _appName;
  }

  /** Sets the application version. */
  public static void setAppVersion(String ver) {
    if (ver != null && ver.length() > 0) {
      _appVersion = ver;
    }
  }

  /** Gets the application version. */
  public static String getAppVersion() {
    return _appVersion;
  }

  /** Sets the application icon. */
  public static void setAppIcon(ImageIcon icon) {
    if (icon != null) {
      _appIcon = icon;
      if (EZEnvironment.getOSType() == EZEnvironment.MAC_OS) {
        EZAppleConfigurator.setDockIcon(_appIcon.getImage());
      }
    }
  }

  /** Gets the application icon. */
  public static ImageIcon getAppIcon() {
    return _appIcon;
  }

  /** Sets the application provider. */
  public static void setProviderName(String provider) {
    _providerName = provider;
  }

  /** Gets the application provider. */
  public static String getProviderName() {
    return _providerName;
  }

  /** Sets the application provider. */
  public static void setCopyRight(String copy) {
    _copyright = copy;
  }

  /** Gets the application provider. */
  public static String getCopyRight() {
    return _copyright;
  }
}
