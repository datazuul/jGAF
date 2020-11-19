package com.plealog.jgaf.prefs4j.implem.ui.tools;

import javax.swing.JLabel;

/**
 * Defines how components located in a sub-grid label column can be aligned inside this column.
 *
 * @see DesignGridLayout#labelAlignment(LabelAlignment)
 * @author Jean-Francois Poilpret
 */
public enum LabelAlignment {
  /**
   * Components in label column should be left-aligned; note that "left" means left only in
   * left-to-right Locale orientation, otherwise it means right.
   */
  LEFT(JLabel.LEADING),

  /**
   * Components in label column should be right-aligned; note that "right" means right only in
   * left-to-right Locale orientation, otherwise it means left.
   */
  RIGHT(JLabel.TRAILING),

  /**
   * Components in label column should be aligned according to guidelines for the current platform;
   * eg on MacOS, platform alignment is right, whereas on Windows, it is left.
   */
  PLATFORM(PlatformHelper.getDefaultAlignment());

  private LabelAlignment(int align) {
    _align = align;
  }

  int alignment() {
    return _align;
  }

  private final int _align;
}
