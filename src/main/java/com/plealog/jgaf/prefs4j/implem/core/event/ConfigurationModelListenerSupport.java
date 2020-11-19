package com.plealog.jgaf.prefs4j.implem.core.event;

import com.plealog.jgaf.prefs4j.api.PreferenceModel;
import javax.swing.event.EventListenerList;

public abstract class ConfigurationModelListenerSupport implements PreferenceModel {
  private EventListenerList _listenerList;

  /** Default constructor. */
  public ConfigurationModelListenerSupport() {
    _listenerList = new EventListenerList();
  }
  /** Adds a ConfigurationModelListener on this viewer. */
  public void addPreferenceModelListener(PreferenceModelListener l) {
    _listenerList.add(PreferenceModelListener.class, l);
  }

  /** Removes a ConfigurationModelListener from this viewer. */
  public void removePreferenceModelListener(PreferenceModelListener l) {
    _listenerList.remove(PreferenceModelListener.class, l);
  }
  /** Fire a selection event. */
  public void fireConfigurationModelEvent(ConfigurationFeatureEvent event) {
    Object[] listeners = _listenerList.getListenerList();
    for (int i = listeners.length - 2; i >= 0; i -= 2) {
      if (listeners[i] == PreferenceModelListener.class) {
        ((PreferenceModelListener) listeners[i + 1]).modelChanged(event);
      }
    }
  }
}
