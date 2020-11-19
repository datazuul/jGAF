package com.plealog.jgaf.wizard.ui;

import com.plealog.jgaf.wizard.model.WizardStepModel;
import java.util.List;

/** Basic implementation of WizardListener. */
public class WizardListenerAdapter implements WizardListener {

  @Override
  public void update() {}

  @Override
  public void finishableChanged(boolean canFinish) {}

  @Override
  public void nextableChanged(boolean canNext) {}

  @Override
  public void previousChanged(boolean canPrevious) {}

  @Override
  public void currentStep(WizardStepModel oldStep, WizardStepModel newStep) {}

  @Override
  public void historyChanged(List<WizardStepModel> stepHistory) {}

  @Override
  public void userFinishes() {}

  @Override
  public void userCancels() {}
}
