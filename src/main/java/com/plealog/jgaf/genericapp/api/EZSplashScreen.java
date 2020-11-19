package com.plealog.jgaf.genericapp.api;

import java.awt.Dimension;

/** A splash screen. To create a concrete instance, use {@link EZSplashScreenFactory} class. */
public interface EZSplashScreen {
  /** Sets the location of the splash screen. Default is the center of the desktop. */
  public void setLocation(int x, int y);
  /** Returns the current size of the splash screen. */
  public Dimension getSize();

  /**
   * Sets the progression of the splash. When progress bar is activated, use this method to
   * increment the progress bar. Value is in the range 0 to 100 percent.
   *
   * @param i pregression value
   */
  public void setProgressPercent(int i);

  /** Sets a progression message. */
  public void setMessage(String s);

  /** Call this method to close the splash screen. */
  public void finish();
}
