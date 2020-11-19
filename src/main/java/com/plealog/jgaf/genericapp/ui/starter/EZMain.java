package com.plealog.jgaf.genericapp.ui.starter;

import com.plealog.jgaf.genericapp.api.EZApplicationBranding;
import com.plealog.jgaf.genericapp.api.EZGenericApplication;

public class EZMain {
  // use for jar packaging, as the main class
  public static void main(String[] args) {
    EZGenericApplication.initialize("jGAF");
    EZApplicationBranding.setAppName("jGAF");
    EZApplicationBranding.setAppVersion("2.0");
    EZApplicationBranding.setCopyRight("Created by Plealog");
    EZApplicationBranding.setProviderName("Plealog Software");
    EZGenericApplication.startApplication(args);
  }
}
