package com.plealog.jgaf.prefs4j.implem.ui.tools;

// Fake subgrid that is used whenever a real SubGrid spans several grids
final class EmptySubGrid implements ISubGrid {
  @Override
  public int gridColumns() {
    return 0;
  }

  @Override
  public int labelWidth() {
    return 0;
  }

  @Override
  public int maxColumnWidth(int maxColumns, IExtractor extractor) {
    return 0;
  }

  @Override
  public int gridspan() {
    return 1;
  }
}
