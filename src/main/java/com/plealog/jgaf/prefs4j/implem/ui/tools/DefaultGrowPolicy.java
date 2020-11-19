package com.plealog.jgaf.prefs4j.implem.ui.tools;

class DefaultGrowPolicy extends HeightGrowPolicyMapper {
  public DefaultGrowPolicy() {
    addPolicy(new JScrollPaneHeightGrowPolicy());
    addPolicy(new JSliderHeightGrowPolicy());
    addPolicy(new ContainerHeightGrowPolicy(this));
  }
}
