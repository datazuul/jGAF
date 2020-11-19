package com.plealog.jgaf.prefs4j.implem.ui.tools;

import javax.swing.JComponent;

class BarRowItem extends NonGridRowItem {
  BarRowItem(JComponent component, Tag tag) {
    super(component);
    _tag = tag;
  }

  Tag tag() {
    return _tag;
  }

  private final Tag _tag;
}
