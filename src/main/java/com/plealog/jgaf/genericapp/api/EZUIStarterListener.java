package com.plealog.jgaf.genericapp.api;

import java.awt.Component;

/** Interface enabling to listen to application startup procedure. */
public interface EZUIStarterListener {

  /** This method is called at the very beginning of application startup procedure. */
  public void preStart();

  /** This method is called when the application frame is about to be displayed. */
  public void postStart();

  /** This method is called when the application frame has been displayed. */
  public void frameDisplayed();

  /**
   * This method is called when application is going to install the user-defined component within
   * the main frame.
   */
  public Component getApplicationComponent();

  /**
   * This method is called whenthe application is about to quit.
   *
   * @return false to prevent application from terminating. Return true is application can exit.
   */
  public boolean isAboutToQuit();
}
