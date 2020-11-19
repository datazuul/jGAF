package com.plealog.jgaf.prefs4j.implem.ui.model;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

/**
 * This class defines a choice that can be used in a form. A choice is a collection of ChoiceEntry
 * objects.
 *
 * @author Patrick G. Durand
 */
public class Choice {
  private String _default;
  private Hashtable<String, ChoiceEntry> _entries;

  public Choice() {
    _entries = new Hashtable<String, ChoiceEntry>();
  }

  /** Adds a new ChoiceEntry in this Choice. */
  public void addEntry(String key, ChoiceEntry entry) {
    _entries.put(key, entry);
  }
  /**
   * Returns the set of keys that can be used to access the various ChoiceEntry objects contained in
   * this Choice.
   */
  public Set<String> getEntriesName() {
    return _entries.keySet();
  }
  /**
   * Returns a ChoiceEntry given its key. This method returns null if the key does not refer to any
   * valid ChoiceEntry.
   */
  public ChoiceEntry getEntry(String key) {
    if (key == null) return null;
    return ((ChoiceEntry) _entries.get(key));
  }
  /** Sets the key refering to the default ChoiceEntry of this Choice. */
  public void setDefault(String key) {
    _default = key;
  }
  /** Returns the key refering to the default ChoiceEntry of this Choice. */
  public String getDefault() {
    return _default;
  }
  /** Returns a string representation of this entry. */
  public String toString() {
    StringBuffer szBuf = new StringBuffer();
    Iterator<String> iter;
    String key;
    ChoiceEntry entry;

    iter = getEntriesName().iterator();
    while (iter.hasNext()) {
      key = iter.next().toString();
      entry = getEntry(key);
      szBuf.append(entry.getStringRepr());
      if (entry.getKey().equals(_default)) {
        szBuf.append(" (Default)");
      }
      if (iter.hasNext()) szBuf.append("\n");
    }
    return szBuf.toString();
  }
}
