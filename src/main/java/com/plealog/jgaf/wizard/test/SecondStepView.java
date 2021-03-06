package com.plealog.jgaf.wizard.test;

import com.plealog.jgaf.prefs4j.implem.ui.tools.DesignGridLayout;
import com.plealog.jgaf.wizard.model.WizardStepModel;
import com.plealog.jgaf.wizard.model.WizardUtils;
import com.plealog.jgaf.wizard.ui.WizardStepView;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** View of the second wizard's step. */
public class SecondStepView extends WizardStepView {

  private boolean init = false;
  private JPanel ui;
  private JTextField street;
  private JTextField city;

  public SecondStepView(WizardStepModel wizardStepModel) {
    super(wizardStepModel);
  }

  @Override
  public boolean commit() {

    String street_str = "";
    if (WizardUtils.isNotBlank(street.getText())) street_str = street.getText();

    String city_str = "";
    if (WizardUtils.isNotBlank(city.getText())) city_str = city.getText();

    this.getModel().setSummary(street_str + ", " + city_str);
    return true;
  }

  @Override
  public void updateUI() {
    init();
    ui.updateUI();
  }

  @Override
  public JComponent getUI() {
    init();
    return ui;
  }

  private void init() {
    if (!init) {
      ui = new JPanel();
      street = new JTextField();
      city = new JTextField();
      DesignGridLayout layout = new DesignGridLayout(ui);
      layout.row().grid(new JLabel("Street: ")).add(street);
      layout.row().grid(new JLabel("City: ")).add(city);
    }
  }
}
