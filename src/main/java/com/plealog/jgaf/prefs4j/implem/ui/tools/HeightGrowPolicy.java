package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.awt.Component;

interface HeightGrowPolicy {
  /**
   * Checks if a {@link Component} can grow in height.
   *
   * @param component the component to test
   * @return {@code true} if {@code component} has a variable height; {@code false} if {@code
   *     component} has a fixed height.
   */
  public boolean canGrowHeight(Component component);

  /**
   * Computes the maximum amount of extra height that a {@link Component} can use.
   *
   * @param component the component to test
   * @param extraHeight the amount of available extra height
   * @return the maximum amount of extra height that {@code component} can use without exceeding
   *     {@code extraHeight}
   */
  public int computeExtraHeight(Component component, int extraHeight);
}
