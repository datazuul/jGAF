package com.plealog.jgaf.genericapp.api;

import com.plealog.jgaf.genericapp.ui.starter.EZSplashScreenImplem;
import javax.swing.ImageIcon;

/** Factory of splash screen. */
public class EZSplashScreenFactory {

  private EZSplashScreenFactory() {}

  /**
   * Creates a concrete splash screen using the provide image.
   *
   * @param image the image to display within the splash screen.
   */
  public static EZSplashScreen startSplashSreen(ImageIcon image) {
    return new EZSplashScreenImplem(image);
  }
  /**
   * Creates a concrete splash screen using the provide image and activate a progress bar.
   *
   * @param image the image to display within the splash screen.
   * @param showProgressBar set whether or not a progress bar has to be displayed.
   */
  public static EZSplashScreen startSplashSreen(ImageIcon image, boolean showProgressBar) {
    return new EZSplashScreenImplem(image, showProgressBar);
  }
}
