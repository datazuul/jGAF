package com.plealog.jgaf.prefs4j.implem.ui.tools;

import javax.swing.JComponent;

interface IItem {
  public JComponent component();

  public int preferredHeight();

  public int minimumWidth();

  public int preferredWidth();

  public int baseline();
}
