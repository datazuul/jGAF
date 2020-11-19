package com.plealog.jgaf.genericapp.api.test;

import com.plealog.jgaf.genericapp.api.file.EZFileManager;
import com.plealog.jgaf.genericapp.api.log.EZLogger;
import java.io.File;

/**
 * Make some UI tests on the EZFileManager dialogs.
 *
 * @author Patrick G. Durand
 */
public class EZFileManagerTest {

  public static void main(String[] args) {
    File f;

    f = EZFileManager.chooseDirectory();
    if (f != null) EZLogger.info("Chosen directory is: " + f.getAbsolutePath());

    f = EZFileManager.chooseFileForOpenAction();
    if (f != null) EZLogger.info("Chosen file is: " + f.getAbsolutePath());

    File[] files;

    files = EZFileManager.chooseFilesForOpenAction();
    if (files != null) {
      for (File ff : files) {
        EZLogger.info("Chosen file is: " + ff.getAbsolutePath());
      }
    }

    EZFileManager.useOSNativeFileDialog(false);

    files = EZFileManager.chooseFilesForOpenAction();
    if (files != null) {
      for (File ff : files) {
        EZLogger.info("Chosen file is: " + ff.getAbsolutePath());
      }
    }
  }
}
