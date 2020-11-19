package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

// Simplified sublist implementation tailored for managing RowItem lists in
// SubGrid/GridRow.
// This implementation is definitly not complete for external use but perfectly
// fulfills its goals in the required context.
final class SubList extends AbstractList<RowItem> implements RandomAccess {
  SubList(List<RowItem> source) {
    _source = source;
    _from = source.size();
  }

  @Override
  public void add(int index, RowItem element) {
    _source.add(_from + index, element);
    _size++;
  }

  @Override
  public RowItem get(int index) {
    return _source.get(_from + index);
  }

  @Override
  public int size() {
    return _size;
  }

  private final List<RowItem> _source;
  private final int _from;
  private int _size = 0;
}
