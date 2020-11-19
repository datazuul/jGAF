package com.plealog.jgaf.genericapp.ui.common;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

/**
 * This is a utility class aims at creating a button that displays a user defined popup menus
 * containing some commands. Usage: call one of the constructor, then pass your popup menu with the
 * setPopup() method.
 *
 * @author Patrick G. Durand
 */
public class OptionMenuButton extends JButton {
  /** */
  private static final long serialVersionUID = -2938126933408941391L;

  private JPopupMenu _popup;

  public OptionMenuButton() {
    super();
    init();
  }

  public OptionMenuButton(Action a) {
    super(a);
    init();
  }

  public OptionMenuButton(Icon icon) {
    super(icon);
    init();
  }

  public OptionMenuButton(String text, Icon icon) {
    super(text, icon);
    init();
  }

  public OptionMenuButton(String text) {
    super(text);
    init();
  }

  public void setPopup(JPopupMenu popup) {
    _popup = popup;
  }

  private void init() {
    this.setHorizontalAlignment(SwingConstants.LEFT);
    Dimension dim = this.getPreferredSize();
    dim.width += 20;
    this.setPreferredSize(dim);
    this.addActionListener(new MyActionListener());
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Rectangle bounds;
    Insets insets;
    int x, y;

    bounds = this.getBounds();
    insets = this.getInsets();
    x = bounds.width - insets.right - 10;
    y = bounds.height / 2 - 2;
    g.drawLine(x, y, x + 3, y + 3);
    g.drawLine(x + 3, y + 3, x + 6, y);
    y++;
    g.drawLine(x, y, x + 3, y + 3);
    g.drawLine(x + 3, y + 3, x + 6, y);
  }

  private class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (_popup == null) return;
      _popup.show(OptionMenuButton.this, 0, OptionMenuButton.this.getBounds().height);
    }
  }
}
