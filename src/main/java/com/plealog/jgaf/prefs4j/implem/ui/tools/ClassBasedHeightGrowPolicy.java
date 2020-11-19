package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.awt.Component;

interface ClassBasedHeightGrowPolicy extends HeightGrowPolicy {
  /**
   * Returns the class of the {@link Component} supported by this policy.
   *
   * @return the class of Component that this policy supports
   */
  public Class<? extends Component> getComponentClass();
}
