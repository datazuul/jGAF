package com.plealog.jgaf.wizard.model;

/**
 * Contains some utility methods coming from Apache Commons Lang StringUtils class. To avoid
 * including the entire package, we just have retrieved the necessary materials.
 */
public class WizardUtils {

  public static boolean isBlank(final CharSequence cs) {
    int strLen;
    if (cs == null || (strLen = cs.length()) == 0) {
      return true;
    }
    for (int i = 0; i < strLen; i++) {
      if (Character.isWhitespace(cs.charAt(i)) == false) {
        return false;
      }
    }
    return true;
  }

  public static boolean isNotBlank(final CharSequence cs) {
    return !isBlank(cs);
  }
}
