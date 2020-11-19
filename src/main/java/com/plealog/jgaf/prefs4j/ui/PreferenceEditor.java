package com.plealog.jgaf.prefs4j.ui;

import com.plealog.jgaf.prefs4j.api.PreferenceException;
import com.plealog.jgaf.prefs4j.api.PreferenceSection;
import java.util.HashSet;
import javax.swing.JComponent;

/** This interfaces defines a Preference Editor. */
public interface PreferenceEditor {
  /** UI properties associated to a Preference Section. */
  public static enum PROPERTY {
    /** Show the Restore Default button. */
    RESTORE_DEF_BTN,
    /** Show the Save Default button. */
    SAVE_AS_DEF_BTN,
    /** Show the Header title of a Preference Section. */
    HEADER,
    /** Show the Help area of a Preference Section. */
    HELP
  };
  /**
   * Default Editor types available in the Framework. User-defined data editors may be added using
   * PreferenceEditorFactory.registerEditor().
   */
  public static enum TYPE {
    /** Key-Value Pair editor. This is the classic editor used with Properties Data Connector. */
    kvp,
    /** Text editor. This is the classic editor used with Raw Data Connector. */
    txt,
    /** No editor. */
    none
  };

  /**
   * Creates a new instance of an editor.
   *
   * @param cf the PreferenceSection for which the editor has to be created
   * @param props the set of properties to apply to the editor
   * @return a new instance of an editor
   */
  public PreferenceEditor newInstance(
      PreferenceSection cf, HashSet<PreferenceEditor.PROPERTY> props);
  /** Returns the name of the editor. */
  public String getName();
  /** Figures out whether something has been edited. */
  public boolean isEdited();
  /**
   * Saves data.
   *
   * @throws PreferenceException implementation should throw a PreferenceException if any kind of
   *     errors occurs while saving data.
   */
  public void saveData() throws PreferenceException;
  /** Returns the GUI component of the editor. */
  public JComponent getEditor();
  /** Method invoked by the framework when the editor is showed. */
  public void editorShowed();
  /** Returns the ConfigurationFeature associated to the editor. */
  public PreferenceSection getPreferenceSection();
}
