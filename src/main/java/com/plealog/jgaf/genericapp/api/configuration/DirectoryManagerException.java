package com.plealog.jgaf.genericapp.api.configuration;

/**
 * A RuntimeException flavor for the Directory manager.
 *
 * @author Patrick G. Durand
 */
public class DirectoryManagerException extends RuntimeException {
  private static final long serialVersionUID = 8646674334142417052L;

  /**
   * Constructor.
   *
   * @param message a message
   */
  public DirectoryManagerException(String message) {
    super(message);
  }
}
