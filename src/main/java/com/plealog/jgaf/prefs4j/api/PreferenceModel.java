package com.plealog.jgaf.prefs4j.api;

import com.plealog.jgaf.prefs4j.implem.core.event.PreferenceModelListener;
import java.util.Enumeration;
import javax.swing.tree.MutableTreeNode;

/** This interface defines the Preference data model. */
public interface PreferenceModel {
  /**
   * Returns the location of the resource file. By now, the Framework only handles File locations,
   * i.e. absolute paths.
   */
  public String getResourceLocator();
  /**
   * Returns the location of the configuration model file. By now, the Framework only handles File
   * locations, i.e. absolute paths.
   */
  public String getPreferenceModelLocator();
  /**
   * Returns the location of the user configuration. By now, the Framework only handles File
   * locations, i.e. absolute paths.
   */
  public String getUserPreferenceLocator();
  /** Returns a enumeration over the ConfurationFeatures defined in this model. */
  public Enumeration<PreferenceSection> enumerator();
  /** Returns the Tree representation of the PreferenceSection hierarchy. */
  public MutableTreeNode getPreferenceSectionsHierarchy();
  /** Adds a listener to this model. */
  public void addPreferenceModelListener(PreferenceModelListener l);
  /** Remove a listener from this model. */
  public void removePreferenceModelListener(PreferenceModelListener l);
}
