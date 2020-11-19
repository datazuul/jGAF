package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.util.Collections;
import java.util.List;
import javax.swing.JComponent;

// Used for all components added to a SubGrid, real or spanned
// Instances are mutable but only under some conditions
class RowItem extends AbstractRowItem {
  // Used to create an item holding a real component (that may span several
  // rows below or not)
  public RowItem(int span, JComponent component) {
    super(component);
    _span = span;
  }

  // Used to create a placeholder for a component spanning a row
  public RowItem(RowItem original) {
    super(null);
    _spanPrevious = original;
    original._spanNext = this;
  }

  @Override
  public JComponent component() {
    return (_spanPrevious != null ? _spanPrevious.component() : super.component());
  }

  // NB: Don't try to optimize this method by caching the calculated preferred
  // height because it may change across calls, hence it would become wrong!
  @Override
  public int preferredHeight() {
    if (_spanPrevious == null && _spanNext == null) {
      // Component spanning no rows at all
      return super.preferredHeight();
    } else if (_spanNext == null) {
      // Multi row-span component on the last spanned row
      // Calculate the preferred height less the height of all previous rows
      int height = 0;
      for (int i = 0; i < _rows.size() - 1; i++) {
        AbstractRow row = _rows.get(i);
        height += row.height() + row.vgap();
      }
      return Math.max(0, super.preferredHeight() - height);
    } else {
      // Multi row-span component on any row but the last spanned row
      return 0;
    }
  }

  @Override
  public void setSpannedRows(List<AbstractRow> rows) {
    _rows = rows;
    if (_spanNext != null) {
      _spanNext.setSpannedRows(_rows);
    }
  }

  @Override
  public boolean isFirstSpanRow() {
    return _spanPrevious == null;
  }

  @Override
  public boolean isLastSpanRow() {
    return _spanNext == null;
  }

  @Override
  public int rowSpan() {
    int rows = 1;
    RowItem next = _spanNext;
    while (next != null) {
      rows++;
      next = next._spanNext;
    }
    return rows;
  }

  // Used to replace a rowspan placeholder with a real component (error marker)
  public void replace(JComponent component) {
    setComponent(component);
    _span = _spanPrevious.span();
    _spanPrevious._spanNext = null;
    _spanPrevious = null;
  }

  public int span() {
    return (_spanPrevious != null ? _spanPrevious.span() : _span);
  }

  private int _span = 1;
  private RowItem _spanPrevious = null;
  private RowItem _spanNext = null;
  private List<AbstractRow> _rows = Collections.emptyList();
}
