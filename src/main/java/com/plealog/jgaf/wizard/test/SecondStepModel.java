package com.plealog.jgaf.wizard.test;

import com.plealog.jgaf.wizard.model.WizardStepModel;
import com.plealog.jgaf.wizard.ui.WizardStepView;

/** Data model of the second wizard's step. */
public class SecondStepModel extends WizardStepModel {

  private SecondStepView view;

  public SecondStepModel() {
    this.view = new SecondStepView(this);
  }

  @Override
  public WizardStepModel next() {
    return null;
  }

  @Override
  public WizardStepView getView() {
    return this.view;
  }

  @Override
  public String getDescription() {
    return "Where are you from ?";
  }

  @Override
  public String getShortDescription() {
    return "Address";
  }
}
