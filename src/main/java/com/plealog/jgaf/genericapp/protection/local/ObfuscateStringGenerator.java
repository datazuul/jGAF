package com.plealog.jgaf.genericapp.protection.local;

import com.plealog.jgaf.genericapp.protection.distrib.HStringCoder;

/**
 * This class is used to generate obfuscated strings.
 *
 * <p>DO NOT distribute this class with the library.
 */
public class ObfuscateStringGenerator {

  public static void main(String[] args) {

    System.out.println(HStringCoder.obfuscate("GenericApp Library"));
    // System.out.println(new HStringCoder("2RuVXZpJ0YwFCcMBWayJXY5J").toString() /* => GenericApp
    // Library */);
  }
}
