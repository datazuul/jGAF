package com.plealog.jgaf.genericapp.ui.common;

import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * A sample component aims at displaying check boxes within a JList. This is a utility class to be
 * used with CheckBoxChooserDialog.
 *
 * @author Patrick G. Durand
 */
// adapted from
// https://stackoverflow.com/questions/19766/how-do-i-make-a-list-with-checkboxes-in-java-swing
public class JCheckBoxList extends JList<JCheckBox> {
  private static final long serialVersionUID = -1260025907269942772L;
  protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

  public JCheckBoxList() {
    setCellRenderer(new CellRenderer());
    // redirect JList mouse click to JCheckBox
    addMouseListener(
        new MouseAdapter() {
          public void mousePressed(MouseEvent e) {
            int index = locationToIndex(e.getPoint());
            if (index != -1) {
              JCheckBox checkbox = (JCheckBox) getModel().getElementAt(index);
              checkbox.setSelected(!checkbox.isSelected());
              repaint();
            }
          }
        });
    // handle keyboard appropriately
    addKeyListener(
        new KeyAdapter() {
          @Override
          public void keyPressed(KeyEvent e) {
            int index = getSelectedIndex();
            if (index != -1 && e.getKeyCode() == KeyEvent.VK_SPACE) {
              boolean newVal = !((JCheckBox) (getModel().getElementAt(index))).isSelected();
              for (int i : getSelectedIndices()) {
                JCheckBox checkbox = (JCheckBox) getModel().getElementAt(i);
                checkbox.setSelected(newVal);
                repaint();
              }
            }
          }
        });
    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  }

  public JCheckBoxList(ListModel<JCheckBox> model) {
    this();
    setModel(model);
  }

  protected class CellRenderer implements ListCellRenderer<JCheckBox> {
    public Component getListCellRendererComponent(
        JList<? extends JCheckBox> list,
        JCheckBox value,
        int index,
        boolean isSelected,
        boolean cellHasFocus) {
      JCheckBox checkbox = value;

      checkbox.setBackground(isSelected ? getSelectionBackground() : getBackground());
      checkbox.setForeground(isSelected ? getSelectionForeground() : getForeground());
      checkbox.setEnabled(isEnabled());
      checkbox.setFont(getFont());
      checkbox.setFocusPainted(false);
      checkbox.setBorderPainted(true);
      checkbox.setBorder(
          isSelected ? UIManager.getBorder("List.focusCellHighlightBorder") : noFocusBorder);
      return checkbox;
    }
  }
}
