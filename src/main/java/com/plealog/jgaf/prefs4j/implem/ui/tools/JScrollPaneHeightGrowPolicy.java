package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.awt.Component;
import javax.swing.JList;
import javax.swing.JScrollPane;

class JScrollPaneHeightGrowPolicy extends AbstractClassBasedHeightGrowPolicy<JScrollPane> {
  public JScrollPaneHeightGrowPolicy() {
    super(JScrollPane.class);
  }

  @SuppressWarnings("rawtypes")
  @Override
  protected int componentComputeExtraHeight(JScrollPane component, int extraHeight) {
    int unit = component.getVerticalScrollBar().getUnitIncrement(+1);
    // Fix for issue #28
    // TODO prepare a more extensible fix that can deal with any specific
    // component (only if needed: wait until other components require a fix)
    Component view = component.getViewport().getView();
    if (unit == 0 && view instanceof JList) {
      JList list = (JList) view;
      int visibleRows = list.getVisibleRowCount();
      if (visibleRows > 0) {
        unit = list.getPreferredScrollableViewportSize().height / visibleRows;
      }
    }
    // Make sure unit cannot be <= 0
    unit = Math.max(1, unit);
    // Return an integral number of units pixels
    return (extraHeight / unit) * unit;
  }
}
