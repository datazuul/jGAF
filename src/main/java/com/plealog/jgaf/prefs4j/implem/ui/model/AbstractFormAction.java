package com.plealog.jgaf.prefs4j.implem.ui.model;

/**
 * This class defines the basics of an action that can happen in a form.
 *
 * @author Patrick G. Durand
 */
public abstract class AbstractFormAction implements FormAction {
  private String _name;
  private String _targetItemName;

  /** Implementation of FormAction interface. */
  public String getName() {
    return _name;
  }
  /** Sets the name of this action. */
  public void setName(String name) {
    _name = name;
  }
  /** Implementation of FormAction interface. */
  public String getTargetItemName() {
    return _targetItemName;
  }
  /** Sets the name of the Item that emits this action. */
  public void setTargetItemName(String name) {
    _targetItemName = name;
  }
}
