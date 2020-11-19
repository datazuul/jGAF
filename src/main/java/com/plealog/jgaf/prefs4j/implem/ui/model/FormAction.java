package com.plealog.jgaf.prefs4j.implem.ui.model;

/**
 * This interface defines the basics to create an action to be used in association with
 * form&apos;items.
 *
 * @author Patrick G. Durand
 */
public interface FormAction {
  /**
   * Execute an action.
   *
   * @param target the GUI container performing the action.
   */
  public void executeAction(ItemGUIContainer target);
  /** Returns a string representation of this FormAction. */
  public String getStringRepr();
  /** Gets the name of this action. */
  public String getName();
  /** Returns the name of the Item that emits this action. */
  public String getTargetItemName();
}
