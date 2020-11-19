package com.plealog.jgaf.genericapp.ui.common;

import com.plealog.jgaf.genericapp.api.EZEnvironment;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 * This class implements dialog box where the user can choose among various options by way of
 * commented radio buttons. These options are symbolized by RadioChooserEntry objects.
 *
 * @author Patrick G. Durand
 */
public class RadioChooserDialog extends JDialog {
  private static final long serialVersionUID = 8090763316799051200L;
  private RadioChooserPanel _chooser;
  private RadioChooserEntry _selectedEntry;

  /**
   * Constructor.
   *
   * @param owner the owner of this dialog box
   * @param title the dialog box title
   * @param entries the list of entries
   */
  public RadioChooserDialog(Frame owner, String title, List<RadioChooserEntry> entries) {
    super(owner, title, true);
    buildGUI(entries);
    this.pack();
    this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    this.addWindowListener(new ConfDialogAdapter());
  }

  /** Shows the dialog box on screen. */
  public void showDlg() {
    centerOnScreen();
    setVisible(true);
  }

  /** Centers the dialog on the screen. */
  private void centerOnScreen() {
    Dimension screenSize = this.getToolkit().getScreenSize();
    Dimension dlgSize = this.getSize();

    this.setLocation(
        screenSize.width / 2 - dlgSize.width / 2, screenSize.height / 2 - dlgSize.height / 2);
  }

  /**
   * Creates the GUI.
   *
   * @param entries the list of entries
   */
  private void buildGUI(List<RadioChooserEntry> entries) {

    JPanel mainPanel, btnPanel;
    JButton ok, cancel;
    Border eBorder;
    boolean macOS;

    eBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

    _chooser = new RadioChooserPanel(entries);

    // btn panel
    cancel = new JButton("Cancel");
    cancel.addActionListener(new CloseDialogAction());
    ok = new JButton("OK");
    ok.addActionListener(new OkDialogAction());
    Dimension dim = cancel.getPreferredSize();
    ok.setPreferredSize(dim);

    btnPanel = new JPanel();
    btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
    btnPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));

    macOS = EZEnvironment.getOSType() == EZEnvironment.MAC_OS;

    btnPanel.add(Box.createHorizontalGlue());
    btnPanel.add(macOS ? cancel : ok);
    btnPanel.add(Box.createRigidArea(new Dimension(10, 0)));
    btnPanel.add(macOS ? ok : cancel);
    if (!macOS) btnPanel.add(Box.createHorizontalGlue());

    // assemble the whole thing
    mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());
    mainPanel.add(_chooser, BorderLayout.CENTER);
    mainPanel.add(btnPanel, BorderLayout.SOUTH);
    mainPanel.setBorder(eBorder);
    getContentPane().setLayout(new BorderLayout());
    getContentPane().add(mainPanel, BorderLayout.CENTER);
  }

  /** Listener of JDialog events. */
  private class ConfDialogAdapter extends WindowAdapter {
    /** Manages windowClosing event: hide the dialog. */
    public void windowClosing(WindowEvent e) {
      dispose();
    }
  }

  /**
   * Return the entry selected by the user.
   *
   * @return selected entry
   */
  public RadioChooserEntry getSelectedEntry() {
    return _selectedEntry;
  }
  /** This inner class manages actions coming from the JButton OkDialog */
  private class OkDialogAction extends AbstractAction {
    private static final long serialVersionUID = -8975702864471257012L;

    public OkDialogAction() {}
    /**
     * Manages JButton action
     *
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) {
      _selectedEntry = _chooser.getSelectedEntry();
      dispose();
    }
  }

  /** This inner class manages actions coming from the JButton CloseDialog */
  private class CloseDialogAction extends AbstractAction {
    private static final long serialVersionUID = -1526622440345558949L;

    /**
     * Manages JButton action
     *
     * @param e action event
     */
    public void actionPerformed(ActionEvent e) {
      _selectedEntry = null;
      dispose();
    }
  }
}
