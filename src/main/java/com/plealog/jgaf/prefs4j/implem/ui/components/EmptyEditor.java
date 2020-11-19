package com.plealog.jgaf.prefs4j.implem.ui.components;

import com.plealog.jgaf.genericapp.ui.starter.EZEnvironmentImplem;
import com.plealog.jgaf.prefs4j.api.PreferenceException;
import com.plealog.jgaf.prefs4j.api.PreferenceSection;
import com.plealog.jgaf.prefs4j.ui.PreferenceEditor;
import java.awt.BorderLayout;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EmptyEditor extends JPanel implements PreferenceEditor {
  private JLabel header;

  public EmptyEditor() {}

  public EmptyEditor(PreferenceSection co) {
    this(co, new HashSet<PreferenceEditor.PROPERTY>());
  }

  public EmptyEditor(PreferenceSection co, HashSet<PreferenceEditor.PROPERTY> props) {
    JPanel headerPanel, pnl;

    pnl = new JPanel(new BorderLayout());
    header = new JLabel("Expand the tree to edit preferences for a specific feature.");
    pnl.add(header, BorderLayout.NORTH);
    pnl.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 0));

    headerPanel = new JPanel(new BorderLayout());
    if (props.contains(PreferenceEditor.PROPERTY.HEADER))
      headerPanel.add(EZEnvironmentImplem.getTitlePanel(co.getName()), BorderLayout.NORTH);

    this.setLayout(new BorderLayout());
    this.add(headerPanel, BorderLayout.NORTH);
    this.add(pnl, BorderLayout.WEST);
  }

  public PreferenceEditor newInstance(
      PreferenceSection co, HashSet<PreferenceEditor.PROPERTY> props) {
    return new EmptyEditor(co, props);
  }

  @Override
  public String getName() {
    return "None";
  }

  @Override
  public boolean isEdited() {
    return false;
  }

  @Override
  public void saveData() throws PreferenceException {}

  @Override
  public JComponent getEditor() {
    return this;
  }

  @Override
  public void editorShowed() {}

  @Override
  public PreferenceSection getPreferenceSection() {
    return null;
  }
}
