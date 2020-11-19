package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.awt.Component;
import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;

// This helper solves an issue with baselines in Windows XP LAF on Java 5
final class BaselineHelper {
  private BaselineHelper() {}

  public static int getBaseline(Component comp) {
    Dimension size = comp.getPreferredSize();
    int baseline = getBaseline(comp, size.width, size.height);
    if (baseline < 0) {
      boolean isCenter = false;
      // Special fix for some components with -1 baselines
      for (Class<? extends JComponent> clazz : _centerAlignedComponents) {
        if (clazz.isInstance(comp)) {
          isCenter = true;
          break;
        }
      }
      if (!isCenter) {
        baseline = 0;
      }
    }
    return baseline;
  }

  private static int getBaseline(Component comp, int width, int height) {
    return comp.getBaseline(width, height);
  }

  private static final Set<Class<? extends JComponent>> _centerAlignedComponents =
      new HashSet<Class<? extends JComponent>>();

  static {
    _centerAlignedComponents.add(JSeparator.class);
    _centerAlignedComponents.add(JProgressBar.class);
  }
}
