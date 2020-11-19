package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.awt.ComponentOrientation;
import java.awt.Container;

class OrientationPolicy {
  public OrientationPolicy(Container parent) {
    _parent = parent;
  }

  public boolean isRightToLeft() {
    // Check layout orientation
    ComponentOrientation orientation = _parent.getComponentOrientation();
    return orientation.isHorizontal() && !orientation.isLeftToRight();
  }

  private final Container _parent;
}
