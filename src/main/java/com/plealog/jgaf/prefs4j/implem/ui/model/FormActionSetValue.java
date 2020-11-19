package com.plealog.jgaf.prefs4j.implem.ui.model;

import java.util.Iterator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JComponent;

/**
 * This class defines an action setting a value to the GUI component of an Item.
 *
 * @author Patrick G. Durand
 */
public class FormActionSetValue extends AbstractFormAction {
  private List<String> _value;

  public FormActionSetValue() {}

  public FormActionSetValue(String name, String targetItemName, List<String> value) {
    setName(name);
    setTargetItemName(targetItemName);
    setValue(value);
  }

  public Object getValue() {
    return _value;
  }

  public void setValue(List<String> value) {
    _value = value;
  }

  private void setTxtFieldValue(ItemGUIContainer target) {
    target.getTxtField().setText(_value.get(0).toString());
  }

  private void setComboValue(ItemGUIContainer target) {
    Item item;
    String key;
    Iterator<String> iter;
    JComboBox<ChoiceEntry> combo;

    item = target.getItem();
    combo = target.getCombo();
    combo.removeAllItems();
    iter = _value.iterator();
    while (iter.hasNext()) {
      key = iter.next().toString();
      combo.addItem(item.getChoice().getEntry(key));
    }
  }

  private void setSpinnerValue(ItemGUIContainer target) {}

  /** Implementation of FormAction interface. */
  public void executeAction(ItemGUIContainer target) {
    JComponent compo;

    if (_value == null) return;
    if (target == null) return;
    compo = target.getComponent();
    if (compo == null) return;

    switch (target.getType()) {
      case ItemGUIContainer.TXT_FIELD_TYPE:
        setTxtFieldValue(target);
        break;
      case ItemGUIContainer.COMBO_TYPE:
        setComboValue(target);
        break;
      case ItemGUIContainer.SPINNER_TYPE:
        setSpinnerValue(target);
        break;
    }
  }
  /** Implementation of FormAction interface. */
  public String getStringRepr() {
    StringBuffer szBuf = new StringBuffer();
    szBuf.append(getName());
    szBuf.append("=");
    szBuf.append(getTargetItemName());
    szBuf.append(":value:");
    Iterator<String> iter = _value.iterator();
    while (iter.hasNext()) {
      szBuf.append(iter.next());
      if (iter.hasNext()) szBuf.append(",");
    }
    return szBuf.toString();
  }
}
