package com.plealog.jgaf.prefs4j.test;

import com.plealog.jgaf.prefs4j.api.PreferenceModel;
import com.plealog.jgaf.prefs4j.api.PreferenceModelFactory;
import com.plealog.jgaf.prefs4j.ui.PreferenceUIFactory;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class EZFormTreeTest {
  private static final String cfgPath = "./conf/";

  public static void locateOnOpticalScreenCenter(Component component) {
    Dimension paneSize = component.getSize();
    Dimension screenSize = component.getToolkit().getScreenSize();
    component.setLocation(
        (screenSize.width - paneSize.width) / 2,
        (int) ((screenSize.height - paneSize.height) * 0.45));
  }

  /** @param args */
  public static void main(String[] args) {
    // ConfigurationEditor getEditor;

    try {
      PreferenceModel model;

      JFrame frame = new JFrame();
      frame.setTitle(EZFormTreeTest.class.getName());
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      // Patrick Durand : L8P78-A5RL7-J4YP2-F3BBZ-7W57Y
      // PreferenceSystem.setUserInformation("Patrick Durand",
      // "L8P78-A5RL7-J4YP2-F3BBZ-7W57Y");
      model = PreferenceModelFactory.getModel(cfgPath + "editor.desc");
      // PreferencePanel editor = new ConfigurationPanel(model);
      // JPanel mainpanel.add(editor,BorderLayout.CENTER);
      // frame.getContentPane().add(mainpanel);
      frame.getContentPane().add(new JButton(new ValidateAction(model)));
      frame.pack();
      EZFormTreeTest.locateOnOpticalScreenCenter(frame);
      frame.setVisible(true);
    } catch (Exception e) {
      System.err.println("Error: " + e);
    }
  }

  @SuppressWarnings("serial")
  private static class ValidateAction extends AbstractAction {
    private PreferenceModel model;

    private ValidateAction(final PreferenceModel model) {
      super("...");
      this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
      try {
        PreferenceUIFactory.showPreferenceDialog(null, "Config", model);
      } catch (Exception e) {
        System.err.println(e);
      }
    }
  }
}
