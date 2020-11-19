package com.plealog.jgaf.genericapp.ui.common;

import com.plealog.jgaf.genericapp.api.log.EZLogger;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JComponent;

/**
 * This class handles the action allowing a user to print a JComponent.
 *
 * @author Patrick G. Durand
 */
public class ComponentPrintManagerAction extends AbstractAction {
  private static final long serialVersionUID = 1484643563363416953L;
  private JComponent _compo;

  /**
   * Action constructor.
   *
   * @param name the name of the action.
   */
  public ComponentPrintManagerAction(String name) {
    super(name);
  }

  /**
   * Action constructor.
   *
   * @param name the name of the action.
   * @param icon the icon of the action.
   */
  public ComponentPrintManagerAction(String name, Icon icon) {
    super(name, icon);
  }

  /** Passes in the component to print. */
  public void setComponent(JComponent compo) {
    _compo = compo;
  }

  public void actionPerformed(ActionEvent event) {
    if (_compo == null) return;
    try {
      PrinterJob pj = PrinterJob.getPrinterJob();
      PageFormat mPageFormat = pj.defaultPage();
      ComponentPrintable cp = new ComponentPrintable(_compo);
      pj.setPrintable(cp, mPageFormat);
      HashPrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
      if (pj.printDialog(attr)) {
        pj.print(attr);
      }
    } catch (PrinterException e) {
      EZLogger.warn("Unable to print: " + e);
    }
  }

  private class ComponentPrintable implements Printable {
    private Component mComponent;

    public ComponentPrintable(Component c) {
      mComponent = c;
    }

    public int print(Graphics g, PageFormat pageFormat, int pageIndex) {
      Graphics2D g2;
      AffineTransform oldTrans;
      boolean wasBuffered;
      double scaler, scaler1, scaler2;
      if (pageIndex > 0) return NO_SUCH_PAGE;
      g2 = (Graphics2D) g;
      oldTrans = g2.getTransform();
      g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
      mComponent.getSize();
      // fit the component to the page
      scaler1 = pageFormat.getImageableWidth() / (double) (mComponent.getSize().getWidth());
      scaler2 = pageFormat.getImageableHeight() / (double) (mComponent.getSize().getHeight());
      scaler = Math.min(scaler1, scaler2);
      if (scaler < 1.0) g2.scale(scaler, scaler);
      wasBuffered = disableDoubleBuffering(mComponent);
      mComponent.paint(g2);
      restoreDoubleBuffering(mComponent, wasBuffered);
      g2.setTransform(oldTrans);
      return PAGE_EXISTS;
    }

    private boolean disableDoubleBuffering(Component c) {
      if (c instanceof JComponent == false) return false;
      JComponent jc = (JComponent) c;
      boolean wasBuffered = jc.isDoubleBuffered();
      jc.setDoubleBuffered(false);
      return wasBuffered;
    }

    private void restoreDoubleBuffering(Component c, boolean wasBuffered) {
      if (c instanceof JComponent) ((JComponent) c).setDoubleBuffered(wasBuffered);
    }
  }
}
