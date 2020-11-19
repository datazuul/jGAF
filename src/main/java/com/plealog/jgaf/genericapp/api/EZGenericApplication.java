package com.plealog.jgaf.genericapp.api;

import com.plealog.jgaf.genericapp.ui.apple.EZAppleConfigurator;
import com.plealog.jgaf.genericapp.ui.starter.EZUIStarterImplem;
import com.plealog.jgaf.resources.Accessor;

/**
 * This class is the entry point of Generic Application. Basically, it aims at starting the
 * application.
 */
public class EZGenericApplication {
  private static boolean isMacOSX() {
    return System.getProperty("os.name").indexOf("Mac OS X") >= 0;
  }

  private EZGenericApplication() {}

  /** Initializes application. To be called at the very beginning of the main() method. */
  public static void initialize(String appName) {
    if (isMacOSX()) {
      EZAppleConfigurator.initialize(appName);
    }
    EZEnvironment.addResourceLocator(Accessor.class);
    if (isMacOSX()) {
      EZAppleConfigurator.setDockIcon(EZApplicationBranding.getAppIcon().getImage());
    }
  }
  /**
   * Starts UI. Since this method starts a Swing-based application, it never returns until the
   * application end.
   *
   * @param args command-line arguments.
   */
  public static void startApplication(String[] args) {
    EZUIStarterImplem starter = new EZUIStarterImplem();
    starter.startApplication(args);
  }
}
