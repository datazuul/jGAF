package com.plealog.jgaf.prefs4j.ui;

import com.plealog.jgaf.prefs4j.api.PreferenceException;
import com.plealog.jgaf.prefs4j.api.PreferenceSection;
import com.plealog.jgaf.prefs4j.implem.ui.components.CTextEditor;
import com.plealog.jgaf.prefs4j.implem.ui.components.EmptyEditor;
import com.plealog.jgaf.prefs4j.implem.ui.components.PropertiesEditor;
import java.util.HashSet;
import java.util.Hashtable;

/** This class is a PreferenceEditor factory. */
public class PreferenceEditorFactory {
  private static Hashtable<String, PreferenceEditor> _editors;

  static {
    _editors = new Hashtable<String, PreferenceEditor>();
    _editors.put(PreferenceEditor.TYPE.kvp.toString(), new PropertiesEditor());
    _editors.put(PreferenceEditor.TYPE.txt.toString(), new CTextEditor());
    _editors.put(PreferenceEditor.TYPE.none.toString(), new EmptyEditor());
  }

  private PreferenceEditorFactory() {}
  /**
   * Creates a new instance of an editor.
   *
   * @param co the PreferenceSection for which the editor has to be created
   * @param props the set of properties to apply to the editor
   * @return a new instance of an editor
   */
  public static PreferenceEditor getEditor(
      PreferenceSection co, HashSet<PreferenceEditor.PROPERTY> props) throws PreferenceException {
    PreferenceEditor pEdit;

    if (co == null || co.getConfType() == null)
      throw new PreferenceException("PreferenceSection not defined");
    pEdit = _editors.get(co.getConfType().toString());
    if (pEdit == null)
      throw new PreferenceException("unknown editor type: " + co.getConfType().toString());
    if (props != null) return pEdit.newInstance(co, props);
    else return pEdit.newInstance(co, new HashSet<PreferenceEditor.PROPERTY>());
  }

  /**
   * Register a new editor.
   *
   * @param type is an editor type. It can be one of PreferenceEditor.TYPE values or a user defined
   *     new string. In the former case, framework-defined default editor will be replaced by the
   *     one passed in with argument editor.
   * @param editor a instance of an editor. Please note that this instance will not be returned when
   *     calling getEditor(PreferenceSection,HashSet&lt;PreferenceEditor.PROPERTIES&gt;) factory.
   *     Instead, the factory will use method newInstance() as defined by PreferenceEditor interface
   *     to always return a fresh instance of the editor.
   */
  public static void registerEditor(String type, PreferenceEditor editor) {
    _editors.put(type, editor);
  }
}
