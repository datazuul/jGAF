package com.plealog.jgaf.prefs4j.implem.ui.tools;

import javax.swing.JSlider;

class JSliderHeightGrowPolicy extends AbstractClassBasedHeightGrowPolicy<JSlider> {
  public JSliderHeightGrowPolicy() {
    super(JSlider.class);
  }

  @Override
  protected boolean componentCanGrowHeight(JSlider component) {
    return component.getOrientation() == JSlider.VERTICAL;
  }
}
