package com.plealog.jgaf.prefs4j.ui;

import com.plealog.jgaf.prefs4j.api.PreferenceException;
import java.util.Enumeration;
import javax.swing.JComponent;

/** Defines a UIComponent for PreferenceModel data model. */
public interface PreferenceComponent {
  /**
   * Returns the UI component containing all editors of the PreferenceSection contained in a
   * PreferenceModel.
   */
  public JComponent getComponent();
  /**
   * Utility method that can be used to programmatically do a general save of all edited
   * ConfigurationFeatures.
   *
   * @throws PreferenceException is save operation failed on a editor.
   */
  public void saveData() throws PreferenceException;
  /** Selects a particular editor by name. */
  public void selectEditor(String editorName);
  /** Returns an enumeration over all ConfigurationEditor contained in this component. */
  public Enumeration<PreferenceEditor> enumerator();
}
