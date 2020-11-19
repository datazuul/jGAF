package com.plealog.jgaf.genericapp.util;

public class EZUtilities {
  /**
   * Replace all occurrences of a string by another string within a string.
   *
   * @param str source string
   * @param sFind string to find in str
   * @param sReplace replacement string
   * @return a new string or str if sFind was not found.
   */
  public static String replaceAll(String str, String sFind, String sReplace) {
    boolean bFound;
    int iPos = -1;

    String newStr = "";
    do {
      iPos = str.indexOf(sFind, ++iPos);
      if (iPos > -1) {
        newStr =
            newStr
                + str.substring(0, iPos)
                + sReplace
                + str.substring(iPos + sFind.length(), str.length());
        str = newStr;
        newStr = "";
        iPos += (sReplace.length() - 1);
        bFound = true;
      } else {
        bFound = false;
      }
    } while (bFound);
    return (str);
  }
}
