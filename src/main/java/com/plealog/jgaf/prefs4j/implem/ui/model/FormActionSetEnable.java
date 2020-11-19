package com.plealog.jgaf.prefs4j.implem.ui.model;

import javax.swing.JComponent;

/**
 * This class defines an action enabling or disabling the GUI component of an Item.
 *
 * @author Patrick G. Durand
 */
public class FormActionSetEnable extends AbstractFormAction {
  private boolean _value;

  public FormActionSetEnable() {}

  public FormActionSetEnable(String name, String targetItemName, boolean value) {
    setName(name);
    setTargetItemName(targetItemName);
    setValue(value);
  }

  public boolean getValue() {
    return _value;
  }

  public void setValue(boolean value) {
    _value = value;
  }
  /** Implementation of FormAction interface. */
  public void executeAction(ItemGUIContainer target) {
    JComponent compo;
    if (target == null) return;

    compo = target.getComponent();
    if (compo == null) return;
    compo.setEnabled(_value);
  }
  /** Implementation of FormAction interface. */
  public String getStringRepr() {
    StringBuffer szBuf = new StringBuffer();
    szBuf.append(getName());
    szBuf.append(":enable:");
    szBuf.append(getValue());
    return szBuf.toString();
  }
}
