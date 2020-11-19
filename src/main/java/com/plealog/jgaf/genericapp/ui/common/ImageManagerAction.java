package com.plealog.jgaf.genericapp.ui.common;

import com.plealog.jgaf.genericapp.api.EZEnvironment;
import com.plealog.jgaf.genericapp.api.file.EZFileManager;
import com.plealog.jgaf.genericapp.api.log.EZLogger;
import com.plealog.jgaf.genericapp.implem.file.EZFileExtDescriptor;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JComponent;

/**
 * This class handles the action allowing a user to export a component in a JPG or PNG file.
 *
 * @author Patrick G. Durand
 */
public class ImageManagerAction extends AbstractAction {
  private static final long serialVersionUID = -6466186889968041634L;
  private JComponent _compo;
  private JComponent[] _compos;

  /**
   * Action constructor.
   *
   * @param name the name of the action.
   */
  public ImageManagerAction(String name) {
    super(name);
  }

  /**
   * Action constructor.
   *
   * @param name the name of the action.
   * @param icon the icon of the action.
   */
  public ImageManagerAction(String name, Icon icon) {
    super(name, icon);
  }

  /**
   * Set the component to export.
   *
   * @param cp the component to write as an image
   */
  public void setComponent(JComponent cp) {
    _compo = cp;
  }
  /**
   * Set the components to export.
   *
   * @param cp the components to write as an image
   */
  public void setComponents(JComponent[] cp) {
    _compos = cp;
  }
  /**
   * File selector.
   *
   * @return a file or null
   */
  private File chooseFile() {
    ArrayList<EZFileExtDescriptor> types;

    types = new ArrayList<EZFileExtDescriptor>();
    types.add(new EZFileExtDescriptor("png", "PNG files"));
    types.add(new EZFileExtDescriptor("jpg", "JPEG files"));
    return EZFileManager.chooseFileForSaveAction(
        EZEnvironment.getParentFrame(), "Save an image file", null, types);
  }

  /** @see Action#actionPerformed(ActionEvent) */
  public void actionPerformed(ActionEvent event) {
    if (_compos != null) {
      new ImagerThread(_compos, this).start();
    } else if (_compo != null) {
      new ImagerThread(new JComponent[] {_compo}, this).start();
    }
  }
  /** Inner class doing the export. */
  private class ImagerThread extends Thread {
    private JComponent[] _cp;
    private Action _act;

    public ImagerThread(JComponent[] compo, Action act) {
      _cp = compo;
      _act = act;
    }
    /** @see Thread#run() */
    public void run() {
      String path;

      File f = chooseFile();

      if (f == null) return;
      path = f.getAbsolutePath();
      _act.setEnabled(false);
      try {
        if (_cp.length == 1) ImageCapture.createImage(_cp[0], path);
        else ImageCapture.createImage(_cp, path);
      } catch (IOException e) {
        EZEnvironment.displayWarnMessage(
            EZEnvironment.getParentFrame(), "An error occurred while creating the image.");
        EZLogger.warn("ImageCapture: " + e);
      } catch (OutOfMemoryError e2) {
        EZEnvironment.displayWarnMessage(
            EZEnvironment.getParentFrame(), "Not enough memory to create an image.");
        EZLogger.warn("ImageCapture: " + e2);
      } catch (Exception e3) {
        EZLogger.warn("ImageCapture: " + e3);
      }

      System.gc();
      _act.setEnabled(true);
    }
  }
}
