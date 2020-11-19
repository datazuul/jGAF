package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.util.List;
import javax.swing.JComponent;

// Used for all components added to a non-grid row
class NonGridRowItem extends AbstractRowItem {
  // Used to create an item holding a real component (that may span several
  // rows below or not)
  public NonGridRowItem(JComponent component) {
    super(component);
  }

  @Override
  public void setSpannedRows(List<AbstractRow> rows) {}

  @Override
  public boolean isFirstSpanRow() {
    return true;
  }

  @Override
  public boolean isLastSpanRow() {
    return true;
  }

  @Override
  public int rowSpan() {
    return 1;
  }
}
