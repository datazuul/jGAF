package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.awt.Component;

final class UnitHeightGrowPolicy implements HeightGrowPolicy {
  public UnitHeightGrowPolicy(HeightGrowPolicy delegate) {
    _delegate = delegate;
  }

  @Override
  public boolean canGrowHeight(Component component) {
    return _delegate.canGrowHeight(component);
  }

  @Override
  public int computeExtraHeight(Component component, int extraHeight) {
    return extraHeight;
  }

  private final HeightGrowPolicy _delegate;
}
