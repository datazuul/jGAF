package com.plealog.jgaf.genericapp.protection.distrib;

/** Auto generated class: do not modify by hand! */
import java.util.Calendar;
import java.util.Date;

/** Class used to control the validity of the library given an expiration date. */
public final class LibraryDateProtectorController {
  /**
   * Returns true if the library has expired.
   *
   * @return Returns true if the library has expired.
   */
  public static final boolean libExpired() {
    String uid, control;
    boolean bRet = false;
    Date d1, d2;

    try {
      uid = HStringUtils.decryptHexString(new HStringCoder("TM1I").toString());
      control = HStringUtils.decryptHexString(new HStringCoder("TM1I").toString());
      if (uid.hashCode() != Integer.valueOf(control)) {
        bRet = true;
      }
      d1 = Calendar.getInstance().getTime();
      d2 = LibraryProtectorBase.DATE_FORM.parse(uid);
      if (d1.after(d2)) {
        bRet = true;
      }
    } catch (Exception e) {
      bRet = true;
    }
    return bRet;
  }
}
