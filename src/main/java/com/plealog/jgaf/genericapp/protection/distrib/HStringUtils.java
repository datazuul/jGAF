package com.plealog.jgaf.genericapp.protection.distrib;

/** Utility class to encode and decode strings to and from hexadecimal representation. */
public final class HStringUtils {

  private static final char[] hexDigit = {
    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
  };

  private static char toHex(int v) {
    return hexDigit[(v & 0xF)];
  }

  private static final String encrypt(String string) {
    char chars[] = string.toCharArray();
    int len, i = 0;
    for (len = chars.length; i < len; i++) chars[i] = (char) (~chars[i]);
    return new String(chars);
  }

  private static final String decrypt(String string) {
    char chars[] = string.toCharArray();
    int len, i = 0;
    for (len = chars.length; i < len; i++) chars[i] = (char) (~chars[i]);
    return new String(chars);
  }

  /**
   * Decrypt a string from its hexadecimal representation.
   *
   * @param s the hexa-encoded string
   * @return the decoded string
   */
  public static final String decryptHexString(String s) {
    StringBuffer outBuffer = new StringBuffer();
    char achar;
    int x, i, len = s.length(), value;

    for (i = 0; i < len; ) {
      value = 0;
      for (x = 0; x < 4; x++) {
        achar = s.charAt(i++);
        switch (achar) {
          case '0':
          case '1':
          case '2':
          case '3':
          case '4':
          case '5':
          case '6':
          case '7':
          case '8':
          case '9':
            value = (value << 4) + achar - '0';
            break;
          case 'A':
          case 'B':
          case 'C':
          case 'D':
          case 'E':
          case 'F':
            value = (value << 4) + 10 + achar - 'A';
            break;
        }
      }
      outBuffer.append((char) value);
    }
    return (HStringUtils.decrypt(outBuffer.toString()));
  }

  /**
   * Encode a string into a hexadecimal string.
   *
   * @param s the string to encode
   * @return the encoded string
   */
  public static final String encryptHexString(String s) {
    int i, len = s.length();
    StringBuffer outBuffer = new StringBuffer();
    String encS = HStringUtils.encrypt(s);

    for (i = 0; i < len; i++) {
      char aChar = encS.charAt(i);
      outBuffer.append(toHex((aChar >> 12) & 0xF));
      outBuffer.append(toHex((aChar >> 8) & 0xF));
      outBuffer.append(toHex((aChar >> 4) & 0xF));
      outBuffer.append(toHex(aChar & 0xF));
    }
    return outBuffer.toString();
  }
}
