package com.plealog.jgaf.genericapp.api.test;

import com.plealog.jgaf.genericapp.api.EZEnvironment;
import com.plealog.jgaf.genericapp.api.EZGenericApplication;
import com.plealog.jgaf.genericapp.api.EZSplashScreen;
import com.plealog.jgaf.genericapp.api.EZSplashScreenFactory;
import com.plealog.jgaf.genericapp.api.EZUIStarterListener;
import com.plealog.jgaf.genericapp.api.file.EZFileUtils;
import java.awt.BorderLayout;
import java.awt.Component;
import java.io.File;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EZUIStarterTest {

  public static void main(String[] args) {
    // this has to be done at the very beginning otherwise, it does not work at
    // all !!!
    EZGenericApplication.initialize("EZUIStarterTest");

    // to add an app starter listener, call EZUIStarter.setUIStarterListener();
    EZEnvironment.setUIStarterListener(new MyStarterListener());

    // to enable the Preferences Dialogue Box
    String confPath = EZFileUtils.terminatePath(System.getProperty("user.dir"));
    confPath += "conf";
    confPath += File.separator;
    confPath += "editor.desc";
    EZEnvironment.setPreferencesConfigurationFile(confPath);

    // to setup a specific user defined messages bundle, call
    // EZEnvironment.setUserDefinedMessagesResourceBundle(rb);
    // then use EZEnvironment.getString()

    // to setup a specific User Defined Actions Manager:
    // (see
    // https://github.com/pgdurand/jGAF-Tutorial/tree/master/src/com/plealog/gaf4j/tutorial/part3)
    // simply call EZEnvironment.setUserDefinedActionsResourceBundle(rb);
    // the resource bundle has to target a valid ActionsManager resource bundle
    // see also EZDEfaultActionHandler to manage About, Preferences and Exit
    // standard actions

    // to setup application branding, use class EZApplicationBranding before
    // calling startApplication()

    // to access Actions, use EZEnvironment.getActionsManager();
    // to work with generic actions, see example below

    // this is how to start application
    EZGenericApplication.startApplication(args);
  }

  private static class MyStarterListener implements EZUIStarterListener {
    private EZSplashScreen splash;

    private MyStarterListener() {}

    @Override
    public void preStart() {
      splash =
          EZSplashScreenFactory.startSplashSreen(EZEnvironment.getImageIcon("banner.png"), true);
      for (int i = 20; i <= 100; i += 20) {
        splash.setProgressPercent(i);
        splash.setMessage("Step " + ((i / 20)));
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
        }
      }
    }

    @Override
    public void postStart() {
      splash.finish();
    }

    @Override
    public Component getApplicationComponent() {
      JPanel mainPanel;
      JTabbedPane tabPanel;

      mainPanel = new JPanel(new BorderLayout());
      tabPanel = new JTabbedPane();

      tabPanel.add("Tab 1", new JPanel());

      mainPanel.add(tabPanel, BorderLayout.CENTER);
      return mainPanel;
    }

    @Override
    public boolean isAboutToQuit() {
      return true;
    }

    @Override
    public void frameDisplayed() {}
  }
}
