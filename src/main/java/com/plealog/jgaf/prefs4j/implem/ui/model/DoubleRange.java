package com.plealog.jgaf.prefs4j.implem.ui.model;

/**
 * This class defines a Range made of doubles.
 *
 * @author Patrick G. Durand
 */
public class DoubleRange implements Range {
  private double _rangeFrom;
  private double _rangeTo;
  private double _rangeDef;

  /** Returns the default value of this range. */
  public double getRangeDef() {
    return _rangeDef;
  }
  /** Sets the default value of this range. */
  public void setRangeDef(double def) {
    _rangeDef = def;
  }
  /** Returns the lower limit value of this range. */
  public double getRangeFrom() {
    return _rangeFrom;
  }
  /** Sets the lower limit value of this range. */
  public void setRangeFrom(double from) {
    _rangeFrom = from;
  }
  /** Returns the upper limit value of this range. */
  public double getRangeTo() {
    return _rangeTo;
  }
  /** Sets the upper limit value of this range. */
  public void setRangeTo(double to) {
    _rangeTo = to;
  }
  /** Returns a string representation of this entry. */
  public String toString() {
    return (_rangeFrom + " - " + _rangeTo + " (" + _rangeDef + ")");
  }

  public boolean isInRange(Number n) {
    double d = n.doubleValue();
    return (d >= _rangeFrom && d <= _rangeTo);
  }

  public Number getMin() {
    return new Double(_rangeFrom);
  }

  public Number getMax() {
    return new Double(_rangeTo);
  }
}
