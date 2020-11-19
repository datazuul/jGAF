package com.plealog.jgaf.prefs4j.implem.ui.model;

/**
 * This class defines the basics of a form entry.
 *
 * @author Patrick G. Durand
 */
public abstract class AbstractEntry {
  private String _name;
  private String _description;
  private String _key;

  /** Returns the description of this entry. */
  public String getDescription() {
    return _description;
  }
  /** Sets the description of this entry. */
  public void setDescription(String description) {
    this._description = description;
  }
  /** Returns the key of this entry. */
  public String getKey() {
    return _key;
  }
  /**
   * Sets the key of this entry. This key is used as this entry&apos;id. When using multiple entries
   * is a same form, be sure to use unique key for the various entries.
   */
  public void setKey(String key) {
    this._key = key;
  }
  /** Returns the key of this entry. This name is used for display purpose in the GUI. */
  public String getName() {
    return _name;
  }
  /** Sets the key of this entry. */
  public void setName(String name) {
    this._name = name;
  }

  /** Returns a string representation of this entry. */
  public String toString() {
    return _name;
  }
  /** Returns a string representation of this entry. */
  public String getStringRepr() {
    StringBuffer szBuf = new StringBuffer();
    szBuf.append("Name: " + _name + ", ");
    szBuf.append("Key: " + _key + ", ");
    szBuf.append("Description: " + _description);
    return szBuf.toString();
  }
}
