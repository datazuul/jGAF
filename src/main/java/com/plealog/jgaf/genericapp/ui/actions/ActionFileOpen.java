package com.plealog.jgaf.genericapp.ui.actions;

import com.plealog.jgaf.genericapp.ui.menu.EZBasicAction;
import java.awt.event.ActionEvent;

/**
 * FileExit action.
 *
 * @author Patrick G. Durand
 */
public class ActionFileOpen extends EZBasicAction {

  private static final long serialVersionUID = 2324015564370531703L;

  /** Default constructor. */
  public ActionFileOpen() {
    super();
  }

  /** Performs the action. */
  public void actionPerformed(ActionEvent e) {
    /*File f;

    f = EZFileManager.chooseDirectory();
    EZLogger.info("Chosen file is: "+f.getAbsolutePath());
    f = EZFileManager.chooseFileForSaveAction();
    EZLogger.info("Chosen file is: "+f.getAbsolutePath());
    f = EZFileManager.chooseFileForOpenAction();
    EZLogger.info("Chosen file is: "+f.getAbsolutePath());

    EZFileManager.useOSNativeFileDialog(false);
    f = EZFileManager.chooseDirectory();
    EZLogger.info("Chosen file is: "+f.getAbsolutePath());
    f = EZFileManager.chooseFileForSaveAction();
    EZLogger.info("Chosen file is: "+f.getAbsolutePath());
    f = EZFileManager.chooseFileForOpenAction();
    EZLogger.info("Chosen file is: "+f.getAbsolutePath());*/
  }
}
