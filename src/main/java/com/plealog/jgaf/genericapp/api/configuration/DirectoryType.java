package com.plealog.jgaf.genericapp.api.configuration;

/**
 * A directory type defines a particular local data storage. It has to be seen as a sub-directory
 * located in {@link DirectoryManager#getApplicationDataPath()}
 *
 * @author Patrick G. Durand
 */
public interface DirectoryType {
  /**
   * Return directory name. It can be a simple string or a path. In the latter case, DO NOT start
   * path with the path separator character.
   *
   * @return a directory name.
   */
  public String getDirectory();

  /**
   * Prepare the directory. This method is automatically called when calling {@link
   * DirectoryManager#prepareApplicationDataPath(boolean, List)}, and has the opportunity to do some
   * preparation of this particular sub-directory.
   *
   * @throws DirectoryManagerException method implementation is advised to throw such an exception
   *     in case or error
   */
  public void prepareDirectory() throws DirectoryManagerException;
}
