package com.plealog.jgaf.prefs4j.implem.ui.tools;

/**
 * Tag that can be assigned to a {@code JComponent} (normally a {@code JButton}) so that
 * DesignGridLayout know where to locate it in an {@link IBarRow}, based on the UI guidelines for
 * the current platform.
 *
 * @see IBarRow#add(javax.swing.JComponent, Tag)
 * @author Jean-Francois Poilpret
 */
public enum Tag {
  /** Tag for the "Help" button. */
  HELP('H'),

  /** Tag for the "Yes" button typically used in a message box. */
  YES('Y'),

  /** Tag for the "No" button typically used in a message box. */
  NO('N'),

  /** Tag for the "Next >" button typically used in a wizard dialog. */
  NEXT('>'),

  /** Tag for the "Previous <" button typically used in a wizard dialog. */
  PREVIOUS('<'),

  /**
   * Tag for the "Finish" button typically used in a wizard dialog in order to validate the wizard
   * sequence and close the wizard dialog.
   */
  FINISH('F'),

  /**
   * Tag for the "Apply" button typically used in a dialog to validate user input without closing
   * the dialog.
   */
  APPLY('A'),

  /**
   * Tag for the "Cancel" button typically used in a dialog to cancel user input and close the
   * dialog.
   */
  CANCEL('C'),

  /**
   * Tag for the "OK" button typically used in a dialog to validate user input and then close the
   * dialog.
   */
  OK('O'),

  /** Special tag for any non-standard button to be located on the left of a {@link IBarRow}. */
  LEFT('L'),

  /** Special tag for any non-standard button to be located in the middle of a {@link IBarRow}. */
  OTHER('X'),

  /** Special tag for any non-standard button to be located on the rigth of a {@link IBarRow}. */
  RIGHT('R');

  private Tag(char code) {
    _code = code;
  }

  static Tag fromCode(char value) {
    for (Tag tag : Tag.values()) {
      if (tag._code == value) {
        return tag;
      }
    }
    return null;
  }

  private final char _code;
}
