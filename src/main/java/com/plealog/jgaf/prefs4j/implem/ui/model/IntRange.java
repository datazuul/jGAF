package com.plealog.jgaf.prefs4j.implem.ui.model;

/**
 * This class defines a Range made of integers.
 *
 * @author Patrick G. Durand
 */
public class IntRange implements Range {
  private int _rangeFrom;
  private int _rangeTo;
  private int _rangeDef;

  /** Returns the default value of this range. */
  public int getRangeDef() {
    return _rangeDef;
  }
  /** Sets the default value of this range. */
  public void setRangeDef(int def) {
    _rangeDef = def;
  }
  /** Returns the lower limit value of this range. */
  public int getRangeFrom() {
    return _rangeFrom;
  }
  /** Sets the lower limit value of this range. */
  public void setRangeFrom(int from) {
    _rangeFrom = from;
  }
  /** Returns the upper limit value of this range. */
  public int getRangeTo() {
    return _rangeTo;
  }
  /** Sets the upper limit value of this range. */
  public void setRangeTo(int to) {
    _rangeTo = to;
  }
  /** Returns a string representation of this entry. */
  public String toString() {
    return (_rangeFrom + " - " + _rangeTo + " (" + _rangeDef + ")");
  }

  public boolean isInRange(Number n) {
    int i = n.intValue();
    return (i >= _rangeFrom && i <= _rangeTo);
  }

  public Number getMin() {
    return new Integer(_rangeFrom);
  }

  public Number getMax() {
    return new Integer(_rangeTo);
  }
}
