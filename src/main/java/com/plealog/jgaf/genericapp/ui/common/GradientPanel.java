/*
 * Copyright (c) 2003 JGoodies Karsten Lentzsch. All Rights Reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  o Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  o Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 *  o Neither the name of JGoodies Karsten Lentzsch nor the names of
 *    its contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.plealog.jgaf.genericapp.ui.common;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JPanel;

/**
 * A basic implementation of a JPanel with a gradient colored background.
 *
 * @author Karsten Lentzsch
 */
public class GradientPanel extends JPanel {
  private static final long serialVersionUID = 3645214319959566285L;
  private boolean _selected;
  private int _orientation;
  private Color _color1;
  private Color _color2;

  public static final int GRAD_ORIENTATION_LtoR = 0;
  public static final int GRAD_ORIENTATION_TLtoBR = 1;

  public GradientPanel(Color color1, Color color2) {
    super();
    _color1 = color1;
    _color2 = color2;
  }

  public void setGradientOrientation(int orientation) {
    _orientation = orientation;
  }

  public void setSelected(boolean sel) {
    _selected = sel;
  }

  public boolean isSelected() {
    return _selected;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (!isOpaque() || isSelected()) {
      return;
    }
    int width = getWidth();
    int height = getHeight();

    Graphics2D g2 = (Graphics2D) g;
    Paint storedPaint = g2.getPaint();
    GradientPaint gp;
    switch (_orientation) {
      case GRAD_ORIENTATION_TLtoBR:
        gp = new GradientPaint(0, 0, _color1, width, height, _color2);
        break;
      default:
        gp = new GradientPaint(0, 0, _color1, width, 0, _color2);
    }
    g2.setPaint(gp);

    g2.fillRect(0, 0, width, height);
    g2.setPaint(storedPaint);
  }
}
