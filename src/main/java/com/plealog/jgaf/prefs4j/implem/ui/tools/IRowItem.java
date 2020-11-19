package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.util.List;

interface IRowItem extends IItem {
  public void hide();

  public void show();

  public void setSpannedRows(List<AbstractRow> rows);

  public int rowSpan();

  public boolean isFirstSpanRow();

  public boolean isLastSpanRow();
}
