package com.plealog.jgaf.genericapp.api.file;

import java.util.Hashtable;

/**
 * This class manages file types. The easiest way to use this class consists in using method
 * registerFileTypes(String, String) to add a file type, then use getFileFilter(String) to retrieve
 * a instance of EZFileFilter.
 */
public abstract class EZFileTypes {
  /** list of valid file types */
  private static Hashtable<String, String> _acceptedFiles = new Hashtable<String, String>();

  /**
   * Registers a new file type.
   *
   * @param extension file extension
   * @param description file extension description
   */
  public static void registerFileType(String extension, String description) {
    _acceptedFiles.put(extension, description);
  }

  /**
   * Gets a file filter for the given extension file type.
   *
   * @param extension file extension to search for
   * @return a EZFileFilter object or null if extension has not been registered to this manager.
   */
  public static EZFileFilter getFileFilter(String extension) {
    EZFileFilter glff;

    if (_acceptedFiles.containsKey(extension) == false) return null;
    glff = new EZFileFilter(extension, (String) _acceptedFiles.get(extension));

    return (glff);
  }
}
