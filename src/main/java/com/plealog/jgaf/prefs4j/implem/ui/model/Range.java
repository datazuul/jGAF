package com.plealog.jgaf.prefs4j.implem.ui.model;

/**
 * Defines a Range to be used in a Form.
 *
 * @author Patrick G. Durand
 */
public interface Range {
  public boolean isInRange(Number n);

  public Number getMin();

  public Number getMax();
}
