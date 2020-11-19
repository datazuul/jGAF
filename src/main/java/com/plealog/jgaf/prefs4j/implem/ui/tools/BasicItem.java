package com.plealog.jgaf.prefs4j.implem.ui.tools;

import javax.swing.JComponent;

class BasicItem implements IItem {
  public BasicItem(JComponent component) {
    _component = component;
  }

  protected void setComponent(JComponent component) {
    _component = component;
  }

  @Override
  public JComponent component() {
    return _component;
  }

  @Override
  public int preferredHeight() {
    return component().getPreferredSize().height;
  }

  @Override
  public int minimumWidth() {
    return component().getMinimumSize().width;
  }

  @Override
  public int preferredWidth() {
    return component().getPreferredSize().width;
  }

  @Override
  public int baseline() {
    return BaselineHelper.getBaseline(component());
  }

  private JComponent _component;
}
