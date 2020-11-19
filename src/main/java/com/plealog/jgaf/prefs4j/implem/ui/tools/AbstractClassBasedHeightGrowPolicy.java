package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.awt.Component;

abstract class AbstractClassBasedHeightGrowPolicy<T extends Component>
    implements ClassBasedHeightGrowPolicy {
  protected AbstractClassBasedHeightGrowPolicy(Class<T> componentClass) {
    _componentClass = componentClass;
  }

  @Override
  public final Class<? extends Component> getComponentClass() {
    return _componentClass;
  }

  @Override
  public final boolean canGrowHeight(Component component) {
    return componentCanGrowHeight(_componentClass.cast(component));
  }

  @Override
  public final int computeExtraHeight(Component component, int extraHeight) {
    return componentComputeExtraHeight(_componentClass.cast(component), extraHeight);
  }

  // Should be overridden if T components might not always be growable in height
  protected boolean componentCanGrowHeight(T component) {
    return true;
  }

  // Should be overridden if T components have special requirements in height
  protected int componentComputeExtraHeight(T component, int extraHeight) {
    return extraHeight;
  }

  private final Class<T> _componentClass;
}
