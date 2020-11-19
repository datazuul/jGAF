package com.plealog.jgaf.prefs4j.implem.ui.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class defines the basic element contained in a Choice.
 *
 * @author Patrick G. Durand
 */
public class ChoiceEntry extends AbstractEntry {
  private ArrayList<FormAction> _actions = new ArrayList<FormAction>();

  /** Adds an action associated to this ChoiceEntry. */
  public void addAction(FormAction action) {
    _actions.add(action);
  }
  /** Returns an iterator over the actions that are assiociated to this ChoiceEntry. */
  public Iterator<FormAction> getActions() {
    return _actions.iterator();
  }
  /** Returns true is this ChoiceEntry has actions associated to it. */
  public boolean hasActions() {
    return (!_actions.isEmpty());
  }
  /** Returns a string representation of this entry. */
  public String getStringRepr() {
    StringBuffer szBuf = new StringBuffer();
    szBuf.append(super.getStringRepr());
    if (hasActions()) {
      szBuf.append("\nActions:\n");
      Iterator<FormAction> iter = getActions();
      while (iter.hasNext()) {
        szBuf.append("  " + (iter.next()).getStringRepr());
        if (iter.hasNext()) szBuf.append("\n");
      }
    }
    return szBuf.toString();
  }
}
