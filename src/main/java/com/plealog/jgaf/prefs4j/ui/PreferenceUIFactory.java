package com.plealog.jgaf.prefs4j.ui;

import com.plealog.jgaf.prefs4j.api.PreferenceException;
import com.plealog.jgaf.prefs4j.api.PreferenceModel;
import com.plealog.jgaf.prefs4j.implem.ui.components.PreferenceDialog;
import com.plealog.jgaf.prefs4j.implem.ui.components.PreferencePanel;
import java.awt.Frame;
import java.util.Set;

/** This factory defines method to instantiates PreferenceModel viewer. */
public class PreferenceUIFactory {
  private PreferenceUIFactory() {}
  /** Display the PreferenceModel Editor Dialog Box. Dialog box is modal. */
  public static void showPreferenceDialog(Frame owner, String dlgTitle, PreferenceModel model)
      throws PreferenceException {
    PreferenceDialog dlg;

    dlg = new PreferenceDialog(owner, dlgTitle, model);
    dlg.showDlg();
  }

  /** Display the PreferenceModel Editor Dialog Box. Dialog box is modal. */
  public static void showPreferenceDialog(
      Frame owner, String dlgTitle, PreferenceModel model, Set<PreferenceEditor.PROPERTY> props)
      throws PreferenceException {
    PreferenceDialog dlg;

    dlg = new PreferenceDialog(owner, dlgTitle, model, props);
    dlg.showDlg();
  }
  /** Creates a UI Component given a PreferenceModel. */
  public static PreferenceComponent getPreferenceComponent(PreferenceModel model)
      throws PreferenceException {
    return new PreferencePanel(model);
  }
}
