package com.plealog.jgaf.prefs4j.implem.core.event;

import java.util.EventListener;

public interface PreferenceModelListener extends EventListener {
  /** Notifies a selection change. */
  public void modelChanged(ConfigurationFeatureEvent event);
}
