package com.plealog.jgaf.genericapp.api.log;

import com.plealog.jgaf.genericapp.api.EZApplicationBranding;
import java.util.logging.Logger;

/**
 * Entry point of the Generic Application logging system. This class is a wrapper around the
 * standard Java Util Logging API. If you want to use this class, please configure the logging
 * system using EZLoggerManager class. The use of this EZLogger class avoid the use of class-based
 * loggers. Indeed, EZLogger analyzes the stack trace to locate the method that does the call to
 * EZLogger, then reports that information within logging message.
 */
public class EZLogger {
  private static Logger LOGGER = Logger.getLogger(EZApplicationBranding.getAppName());

  public static void info(String msg) {
    String caller = getMethodCaller();
    if (caller != null) LOGGER.info(formatMessage(caller, msg));
    else LOGGER.info(msg);
  }

  public static void warn(String msg) {
    String caller = getMethodCaller();
    if (caller != null) LOGGER.warning(formatMessage(caller, msg));
    else LOGGER.warning(msg);
  }

  public static void error(String msg) {
    String caller = getMethodCaller();
    if (caller != null) LOGGER.severe(formatMessage(caller, msg));
    else LOGGER.severe(msg);
  }

  public static void debug(String msg) {
    String caller = getMethodCaller();
    if (caller != null) LOGGER.config(formatMessage(caller, msg));
    else LOGGER.config(msg);
  }

  private static String formatMessage(String caller, String msg) {
    StringBuffer buf = new StringBuffer(caller);

    if (EZLoggerManager.isInitialized()) buf.append("&&");
    else buf.append(": ");
    buf.append(msg);
    return buf.toString();
  }

  private static String getMethodCaller() {
    StackTraceElement[] elements = new Throwable().getStackTrace();
    if (elements.length < 3) return null;
    else return elements[2].toString();
  }
}
