package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class RowIterator implements Iterator<AbstractRow> {
  public static Iterable<AbstractRow> each(final List<AbstractRow> rows) {
    return new Iterable<AbstractRow>() {
      @Override
      public Iterator<AbstractRow> iterator() {
        return new RowIterator(rows);
      }
    };
  }

  private RowIterator(List<AbstractRow> rows) {
    _rows = rows;
  }

  @Override
  public AbstractRow next() {
    int index = findNext();
    if (index != -1) {
      _index = index + 1;
      return _rows.get(index);
    } else {
      throw new NoSuchElementException();
    }
  }

  @Override
  public boolean hasNext() {
    return findNext() != -1;
  }

  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }

  private int findNext() {
    for (int i = _index; i < _rows.size(); i++) {
      AbstractRow row = _rows.get(i);
      if (!row.isEmpty()) {
        return i;
      }
    }
    return -1;
  }

  private final List<AbstractRow> _rows;
  private int _index = 0;
}
