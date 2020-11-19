package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.awt.Container;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

final class ComponentGapsHelper {
  public static ComponentGapsHelper instance() {
    return new ComponentGapsHelper();
  }

  public int getHorizontalIndent() {
    if (_indent == -1) {
      JLabel label1 = new JLabel("Top label");
      JLabel label2 = new JLabel("Bottom label");
      _indent =
          _style.getPreferredGap(
              label1, label2, ComponentPlacement.INDENT, SwingConstants.SOUTH, null);
    }
    return _indent;
  }

  public int getVerticalGap(
      JComponent component1, JComponent component2, ComponentPlacement type, Container parent) {
    return _style.getPreferredGap(component1, component2, type, SwingConstants.SOUTH, parent);
  }

  public int getHorizontalGap(
      JComponent component1, JComponent component2, ComponentPlacement type, Container parent) {
    return _style.getPreferredGap(component1, component2, type, SwingConstants.EAST, parent);
  }

  public int getNorthContainerGap(JComponent component, Container parent) {
    return _style.getContainerGap(component, SwingConstants.NORTH, parent);
  }

  public int getSouthContainerGap(JComponent component, Container parent) {
    return _style.getContainerGap(component, SwingConstants.SOUTH, parent);
  }

  public int getWestContainerGap(JComponent component, Container parent) {
    return _style.getContainerGap(component, SwingConstants.WEST, parent);
  }

  public int getEastContainerGap(JComponent component, Container parent) {
    return _style.getContainerGap(component, SwingConstants.EAST, parent);
  }

  private final LayoutStyle _style = LayoutStyle.getInstance();
  private int _indent = -1;
}
