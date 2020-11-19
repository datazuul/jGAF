package com.plealog.jgaf.genericapp.protection.local;

import com.plealog.jgaf.genericapp.protection.distrib.LicenseKeyController;

/**
 * This class is intended to create a license key given a user name
 *
 * <p>DO NOT distribute this class with the library.
 */
public class LicenseKeyGenerator {
  /** @param args */
  public static void main(String[] args) {
    System.out.println("User name: [" + args[0] + "]");
    System.out.println("License  : " + LicenseKeyController.generate(args[0]));
  }
  // Patrick Durand : L8P78-A5RL7-J4YP2-F3BBZ-7W57Y

}
