package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.awt.Component;
import java.awt.Container;

class ContainerHeightGrowPolicy extends AbstractClassBasedHeightGrowPolicy<Container> {
  public ContainerHeightGrowPolicy(HeightGrowPolicy defaultPolicy) {
    super(Container.class);
    _defaultPolicy = defaultPolicy;
  }

  @Override
  protected boolean componentCanGrowHeight(Container panel) {
    for (Component child : panel.getComponents()) {
      if (_defaultPolicy.canGrowHeight(child)) {
        return true;
      }
    }
    return false;
  }

  @Override
  protected int componentComputeExtraHeight(Container panel, int extraHeight) {
    int actualHeight = 0;
    for (Component child : panel.getComponents()) {
      if (_defaultPolicy.canGrowHeight(child)) {
        actualHeight =
            Math.max(actualHeight, _defaultPolicy.computeExtraHeight(child, extraHeight));
      }
    }
    return actualHeight;
  }

  private final HeightGrowPolicy _defaultPolicy;
}
