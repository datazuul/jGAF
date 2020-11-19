package com.plealog.jgaf.prefs4j.implem.ui.tools;

import javax.swing.JComponent;

abstract class AbstractRowItem extends BasicItem implements IRowItem {
  protected AbstractRowItem(JComponent component) {
    super(component);
  }

  @Override
  public void hide() {
    if (isFirstSpanRow()) {
      _isVisible = component().isVisible();
      component().setVisible(false);
    }
  }

  @Override
  public void show() {
    if (isFirstSpanRow()) {
      component().setVisible(_isVisible);
    }
  }

  private boolean _isVisible = true;
}
