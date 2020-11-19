package com.plealog.jgaf.prefs4j.implem.ui.tools;

// Utility to factor out similar code dealing with common JComponent properties
interface IExtractor {
  int value(IItem item);
}

abstract class AbstractExtractor implements IExtractor {
  protected AbstractExtractor() {}
}

final class MinWidthExtractor extends AbstractExtractor {
  static final IExtractor INSTANCE = new MinWidthExtractor();

  @Override
  public int value(IItem item) {
    return item.minimumWidth();
  }
}

final class PrefWidthExtractor implements IExtractor {
  static final IExtractor INSTANCE = new PrefWidthExtractor();

  @Override
  public int value(IItem item) {
    return item.preferredWidth();
  }
}

final class PrefHeightExtractor implements IExtractor {
  static final IExtractor INSTANCE = new PrefHeightExtractor();

  @Override
  public int value(IItem item) {
    return item.preferredHeight();
  }
}

final class BaselineExtractor implements IExtractor {
  static final IExtractor INSTANCE = new BaselineExtractor();

  @Override
  public int value(IItem item) {
    return item.baseline();
  }
}
