package com.plealog.jgaf.prefs4j.implem.ui.tools;

final class LeftRow extends AbstractNonGridRow {
  @Override
  protected int xOffset(int rowWidth, int usedWidth) {
    return 0;
  }

  @Override
  protected int leftFiller(int count, int width, int availableWidth) {
    return (count > 1 ? width : rightFiller(count, width, availableWidth));
  }

  @Override
  protected int rightFiller(int count, int width, int availableWidth) {
    return (availableWidth - (count - 1) * width);
  }
}
