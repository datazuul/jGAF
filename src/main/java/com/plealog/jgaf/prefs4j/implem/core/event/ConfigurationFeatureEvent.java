package com.plealog.jgaf.prefs4j.implem.core.event;

import com.plealog.jgaf.prefs4j.api.PreferenceSection;
import java.util.EventObject;

public class ConfigurationFeatureEvent extends EventObject {
  private static final long serialVersionUID = -6090678263826488520L;
  private PreferenceSection _conf;

  public ConfigurationFeatureEvent(Object src) {
    super(src);
  }

  public ConfigurationFeatureEvent(Object src, PreferenceSection co) {
    super(src);
    setConfigurationFeature(co);
  }

  public void setConfigurationFeature(PreferenceSection co) {
    _conf = co;
  }

  public PreferenceSection getConfigurationFeature() {
    return _conf;
  }
}
