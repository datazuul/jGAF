package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JLabel;

final class MarkerHelper {
  private MarkerHelper() {}

  static JComponent createMarker(int span, String tooltip) {
    JLabel marker = new JLabel(MARKER_LABEL);
    marker.setName(MARKER_NAME);
    marker.setHorizontalAlignment(JLabel.CENTER);
    marker.setOpaque(true);
    marker.setBackground(Color.RED);
    marker.setToolTipText(tooltip);
    return marker;
  }

  static boolean isMarker(JComponent component) {
    return (component instanceof JLabel) && (MARKER_NAME.equals(component.getName()));
  }

  private static final String MARKER_LABEL = "spanRow()";
  private static final String MARKER_NAME = "DesignGridLayout.spanRow-Marker";
}
