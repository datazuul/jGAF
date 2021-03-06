package com.plealog.jgaf.prefs4j.implem.ui.components;

import com.plealog.jgaf.genericapp.api.EZEnvironment;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class JFoldedButton extends JCheckBox {

  private static final long serialVersionUID = 2365941878616795115L;
  private static final ImageIcon FOLDED_ARROW = EZEnvironment.getImageIcon("collapse-group.png");
  private static final ImageIcon UNFOLDED_ARROW = EZEnvironment.getImageIcon("expand-group.png");

  public JFoldedButton() {
    super();
  }

  public JFoldedButton(Icon arg0) {
    super(arg0);
  }

  public JFoldedButton(String arg0) {
    super(arg0);
  }

  public JFoldedButton(Action arg0) {
    super(arg0);
  }

  public JFoldedButton(Icon arg0, boolean arg1) {
    super(arg0, arg1);
  }

  public JFoldedButton(String arg0, boolean arg1) {
    super(arg0, arg1);
  }

  public JFoldedButton(String arg0, Icon arg1) {
    super(arg0, arg1);
  }

  public JFoldedButton(String arg0, Icon arg1, boolean arg2) {
    super(arg0, arg1, arg2);
  }

  public void paintComponent(Graphics g) {
    Rectangle r = getBounds();
    g.setColor(getBackground());
    g.clearRect(0, 0, r.width, r.height);
    g.fillRect(0, 0, r.width, r.height);
    if (this.isSelected()) {
      g.drawImage(UNFOLDED_ARROW.getImage(), 2, this.getHeight() / 2 - 8, null, null);
    } else {
      g.drawImage(FOLDED_ARROW.getImage(), 2, this.getHeight() / 2 - 8, null, null);
    }
    g.setColor(this.getForeground());
    FontMetrics fm = this.getFontMetrics(this.getFont());
    g.setFont(this.getFont());
    g.drawString(this.getText(), 25, this.getHeight() / 2 + fm.getHeight() / 2);
  }
}
