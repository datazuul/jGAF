package com.plealog.jgaf.genericapp.ui.desktop;

import java.awt.BorderLayout;
import java.beans.PropertyVetoException;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

/**
 * Implements a JDesktop pane ready to be used along with a Documents Menu.
 *
 * @author Patrick G. Durand
 * @since 2006
 */
public class GDesktopPane extends JPanel {

  private static final long serialVersionUID = -3280873664739690228L;
  /** the desktop panel */
  protected JDesktopPane _desktop = new JDesktopPane();

  /** Default constructor. */
  public GDesktopPane() {
    _desktop = new JDesktopPane();
    this.setLayout(new BorderLayout());
    this.add(_desktop, BorderLayout.CENTER);
    this.setBorder(new ShadowBorder());
  }

  /** Returns the real implementation of the desktop panel. */
  public JDesktopPane getDesktopPane() {
    return (_desktop);
  }

  /**
   * Returns the currently selected internal frame If none is selected, then the first one will be
   * selected.
   *
   * @return JInternalFrame
   */
  public synchronized JInternalFrame getCurrentInternalFrame() {
    JInternalFrame internalFrame;
    JInternalFrame[] frames;

    internalFrame = _desktop.getSelectedFrame();
    if (internalFrame == null) {
      frames = _desktop.getAllFrames();
      if (frames.length > 0) {
        try {
          frames[0].setSelected(true);
          internalFrame = frames[0];
        } catch (PropertyVetoException e) {
          return null;
        }
      }
    }
    if (internalFrame == null) return (null);
    return (internalFrame);
  }

  /** Adds a new Internal Frame. */
  public synchronized void addGInternalFrame(GInternalFrame f) {
    if (f == null) return;
    _desktop.add(f);
    try {
      f.setSelected(true);
    } catch (Exception ex) {
    }
  }

  /** Removes the specified Internal Frame. */
  public synchronized void removeGInternalFrame(GInternalFrame f) {
    JInternalFrame[] frames;

    if (f == null) return;
    f.setVisible(false);
    f.dispose();
    _desktop.remove(f);
    frames = _desktop.getAllFrames();
    if (frames.length > 0) {
      try {
        frames[0].setSelected(true);
      } catch (PropertyVetoException e) {
      }
    }
  }

  /** Returns an array of all Internal Frames. */
  public synchronized JInternalFrame[] getAllFrames() {
    return _desktop.getAllFrames();
  }
}
