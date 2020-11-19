package com.plealog.jgaf.prefs4j.implem.ui.components;

import com.plealog.jgaf.genericapp.api.EZEnvironment;
import com.plealog.jgaf.genericapp.ui.starter.EZEnvironmentImplem;
import com.plealog.jgaf.prefs4j.api.DataConnector;
import com.plealog.jgaf.prefs4j.api.PreferenceException;
import com.plealog.jgaf.prefs4j.api.PreferenceSection;
import com.plealog.jgaf.prefs4j.api.RawDataConnector;
import com.plealog.jgaf.prefs4j.ui.PreferenceEditor;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 * This class implements a Configuration Editor that is just simple text editor.
 *
 * @author Patrick G. Durand
 */
@SuppressWarnings("serial")
public class CTextEditor extends JPanel implements PreferenceEditor {
  private SimpleTextEditor _editor;
  private PreferenceSection _co;

  public CTextEditor() {}

  public CTextEditor(PreferenceSection co) {
    this(co, new HashSet<PreferenceEditor.PROPERTY>());
  }

  public CTextEditor(PreferenceSection co, HashSet<PreferenceEditor.PROPERTY> props) {
    JButton restoreBtn, saveDefBtn;
    JPanel mainPanel, btnPanel, hPanel;
    boolean showHeader, showRestoreBtn, showSaveAsDefBtn;

    if (co == null || !co.getConfType().equalsIgnoreCase(PreferenceEditor.TYPE.txt.toString()))
      throw new PreferenceException("CTextEditor: argument is null or invalid");
    _co = co;

    _editor = new SimpleTextEditor();
    _editor.setText(readConfFile());
    restoreBtn = new JButton(EZEnvironment.getMessage("__EZPropertiesPanel.btn.restore"));
    restoreBtn.addActionListener(new RestoreDefaultsAction());
    saveDefBtn = new JButton(EZEnvironment.getMessage("__EZPropertiesPanel.btn.savedef"));
    saveDefBtn.addActionListener(new SaveAsDefaultsAction());

    btnPanel = new JPanel(new BorderLayout());
    btnPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
    btnPanel.add(saveDefBtn, BorderLayout.WEST);
    btnPanel.add(restoreBtn, BorderLayout.EAST);
    showRestoreBtn = props.contains(PreferenceEditor.PROPERTY.RESTORE_DEF_BTN);
    showSaveAsDefBtn = props.contains(PreferenceEditor.PROPERTY.SAVE_AS_DEF_BTN);
    if (showRestoreBtn) {
      if (co.getDefaultConfigurationLocator() == null
          || co.getDataConnector().canRead(co.getDefaultConfigurationLocator()) == false) {
        showRestoreBtn = false;
      }
    }
    if (showSaveAsDefBtn) {
      if (co.getDefaultConfigurationLocator() == null
          || co.getDataConnector().canWrite(co.getDefaultConfigurationLocator()) == false) {
        showSaveAsDefBtn = false;
      }
    }
    saveDefBtn.setVisible(showSaveAsDefBtn);
    restoreBtn.setVisible(showRestoreBtn);
    showHeader = props.contains(PreferenceEditor.PROPERTY.HEADER);

    mainPanel = new JPanel(new BorderLayout());
    if (showHeader) {
      hPanel = EZEnvironmentImplem.getTitlePanel(co.getName());
      hPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      mainPanel.add(hPanel, BorderLayout.NORTH);
    }
    mainPanel.add(_editor, BorderLayout.CENTER);
    mainPanel.add(btnPanel, BorderLayout.SOUTH);
    this.setLayout(new BorderLayout());
    this.add(mainPanel, BorderLayout.CENTER);
  }

  private String readConfFile() throws PreferenceException {
    DataConnector conn;
    String data = "", msg;

    conn = _co.getDataConnector();
    if (conn instanceof RawDataConnector == false) {
      throw new PreferenceException("invalid DataConnector: expected a RawDataConnector");
    }
    try {
      data = ((RawDataConnector) conn).load(_co.getConfigurationLocator());
    } catch (Exception e) {
      msg =
          _co.getName()
              + ": "
              + EZEnvironment.getMessage("__EZCTextEditor.err.load")
              + ": "
              + _co.getConfigurationLocator()
              + ": "
              + e.toString();
      throw new PreferenceException(msg);
    }
    return data;
  }

  private String readDefaultConfFile() throws PreferenceException {
    DataConnector conn;
    String data = "", msg;

    if (_co.getDefaultConfigurationLocator() == null) return null;
    conn = _co.getDataConnector();
    if (conn instanceof RawDataConnector == false) {
      throw new PreferenceException("invalid DataConnector: expected a RawDataConnector");
    }
    try {
      data = ((RawDataConnector) conn).load(_co.getDefaultConfigurationLocator());
    } catch (Exception e) {
      msg =
          _co.getName()
              + ": "
              + EZEnvironment.getMessage("__EZCTextEditor.err.load")
              + ": "
              + _co.getDefaultConfigurationLocator()
              + ": "
              + e.toString();
      throw new PreferenceException(msg);
    }
    return data;
  }

  public PreferenceEditor newInstance(
      PreferenceSection co, HashSet<PreferenceEditor.PROPERTY> props) {
    return new CTextEditor(co, props);
  }

  public String getName() {
    return _co.getName();
  }

  public boolean isEdited() {
    return _editor.isEdited();
  }

  private void saveData(String path) throws PreferenceException {
    String msg = null;
    DataConnector conn;

    if (path == null) return;
    conn = _co.getDataConnector();
    if (conn instanceof RawDataConnector == false) {
      throw new PreferenceException("invalid DataConnector: expected a RawDataConnector");
    }
    try {
      ((RawDataConnector) conn).save(path, _editor.getText());
    } catch (Exception e) {
      msg =
          _co.getName()
              + ": \n"
              + EZEnvironment.getMessage("__EZCTextEditor.err.save")
              + ":\n"
              + path
              + ":\n"
              + e.getMessage();
      throw new PreferenceException(msg);
    }
  }

  public void saveData() throws PreferenceException {
    saveData(_co.getConfigurationLocator());
  }

  public JComponent getEditor() {
    return this;
  }

  public void editorShowed() {}

  public PreferenceSection getPreferenceSection() {
    return _co;
  }

  private class RestoreDefaultsAction implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      try {
        String txt = readDefaultConfFile();
        if (txt == null) return;
        _editor.setText(txt);
        _editor.setEdited(true);
      } catch (PreferenceException e) {
        EZEnvironment.displayWarnMessage(CTextEditor.this, e.getMessage());
      }
    }
  }

  private class SaveAsDefaultsAction implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      if (!EZEnvironment.confirmMessage(
          CTextEditor.this, EZEnvironment.getMessage("__EZConfDlg.saveDef.msg"))) {
        return;
      }
      try {
        saveData(_co.getDefaultConfigurationLocator());
      } catch (PreferenceException e) {
        EZEnvironment.displayWarnMessage(CTextEditor.this, e.getMessage());
      }
    }
  }
}
