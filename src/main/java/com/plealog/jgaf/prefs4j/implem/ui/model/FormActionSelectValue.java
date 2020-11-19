package com.plealog.jgaf.prefs4j.implem.ui.model;

import javax.swing.JComboBox;
import javax.swing.JComponent;

/**
 * This class defines an action selecting an entry within a Choice.
 *
 * @author Patrick G. Durand
 */
public class FormActionSelectValue extends AbstractFormAction {
  private String _key;

  public FormActionSelectValue() {}

  public FormActionSelectValue(String name, String targetItemName, String key) {
    setName(name);
    setTargetItemName(targetItemName);
    setKey(key);
  }

  public String getKey() {
    return _key;
  }

  public void setKey(String key) {
    _key = key;
  }

  private void selectComboValue(ItemGUIContainer target) {
    Item item;
    JComboBox<ChoiceEntry> combo;
    Choice choice;
    ChoiceEntry ce;

    item = target.getItem();
    combo = target.getCombo();
    choice = item.getChoice();
    ce = choice.getEntry(_key);
    if (ce != null) {
      combo.setSelectedItem(ce);
    }
  }
  /** Implementation of FormAction interface. */
  public void executeAction(ItemGUIContainer target) {
    JComponent compo;

    if (_key == null) return;
    if (target == null) return;
    compo = target.getComponent();
    if (compo == null) return;

    switch (target.getType()) {
      case ItemGUIContainer.COMBO_TYPE:
        selectComboValue(target);
        break;
    }
  }
  /** Implementation of FormAction interface. */
  public String getStringRepr() {
    StringBuffer szBuf = new StringBuffer();
    szBuf.append(getName());
    szBuf.append("=");
    szBuf.append(getTargetItemName());
    szBuf.append(":select:");
    szBuf.append(getKey());
    return szBuf.toString();
  }
}
