package com.plealog.jgaf.prefs4j.implem.ui.tools;

interface ISubGrid {
  int labelWidth();

  int gridColumns();

  int gridspan();

  int maxColumnWidth(int maxColumns, IExtractor extractor);
}
