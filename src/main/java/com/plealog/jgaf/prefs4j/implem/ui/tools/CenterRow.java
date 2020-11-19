package com.plealog.jgaf.prefs4j.implem.ui.tools;

final class CenterRow extends AbstractNonGridRow {
  @Override
  protected int xOffset(int rowWidth, int usedWidth) {
    return (rowWidth - usedWidth) / 2;
  }

  @Override
  protected int leftFiller(int count, int width, int availableWidth) {
    int fillers = (count > 1 ? 2 : 1);
    return (availableWidth - (count - fillers) * width) / fillers;
  }

  @Override
  protected int rightFiller(int count, int width, int availableWidth) {
    int fillers = (count > 1 ? 2 : 1);
    int rightFiller = (availableWidth - (count - fillers) * width) / fillers;
    if (((availableWidth - (count - fillers) * width) % fillers) > 0) {
      rightFiller++;
    }
    return rightFiller;
  }
}
