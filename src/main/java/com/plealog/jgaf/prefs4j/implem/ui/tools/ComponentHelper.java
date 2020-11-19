package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.awt.Container;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.LayoutStyle.ComponentPlacement;

final class ComponentHelper {
  private ComponentHelper() {}

  static int maxValues(Iterable<? extends IItem> items, IExtractor extractor) {
    int max = 0;
    for (IItem item : items) {
      max = Math.max(max, extractor.value(item));
    }
    return max;
  }

  static int sumValues(Iterable<? extends IItem> items, IExtractor extractor) {
    int sum = 0;
    for (IItem item : items) {
      sum += extractor.value(item);
    }
    return sum;
  }

  static int unrelhgap(List<? extends IItem> items, Container parent) {
    return hgap(ComponentGapsHelper.instance(), items, parent, ComponentPlacement.UNRELATED);
  }

  static int hgap(List<? extends IItem> items, Container parent) {
    return hgap(ComponentGapsHelper.instance(), items, parent, ComponentPlacement.RELATED);
  }

  static int hgap(JComponent first, List<? extends IItem> items, Container parent) {
    ComponentGapsHelper helper = ComponentGapsHelper.instance();
    int hgap = 0;
    if (first != null && !items.isEmpty()) {
      hgap = hgap(helper, first, items.get(0).component(), parent, ComponentPlacement.RELATED);
    }
    return Math.max(hgap, hgap(helper, items, parent, ComponentPlacement.RELATED));
  }

  static boolean isFixedHeight(HeightGrowPolicy policy, Iterable<? extends IRowItem> items) {
    for (IRowItem item : items) {
      if (policy.canGrowHeight(item.component()) && item.isLastSpanRow()) {
        return false;
      }
    }
    return true;
  }

  private static int hgap(
      ComponentGapsHelper helper,
      List<? extends IItem> items,
      Container parent,
      ComponentPlacement placement) {
    int hgap = 0;
    int size = items.size() - 1;
    for (int nth = 0; nth < size; nth++) {
      JComponent left = items.get(nth).component();
      JComponent right = items.get(nth + 1).component();
      int gap = hgap(helper, left, right, parent, placement);
      hgap = Math.max(hgap, gap);
    }
    return hgap;
  }

  private static int hgap(
      ComponentGapsHelper helper,
      JComponent left,
      JComponent right,
      Container parent,
      ComponentPlacement placement) {
    return helper.getHorizontalGap(left, right, placement, parent);
  }
}
