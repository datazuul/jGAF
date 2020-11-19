package com.plealog.jgaf.prefs4j.implem.ui.tools;

final class RightRow extends AbstractNonGridRow {
  @Override
  protected int xOffset(int rowWidth, int usedWidth) {
    return rowWidth - usedWidth;
  }

  @Override
  protected int leftFiller(int count, int width, int availableWidth) {
    return (availableWidth - (count - 1) * width);
  }

  @Override
  protected int rightFiller(int count, int width, int availableWidth) {
    return width;
  }
}
