package com.plealog.jgaf.genericapp.implem.file;

import com.plealog.jgaf.genericapp.api.file.EZFileManager;

/**
 * This class is used to describe a file extension. It is mainly designed to be used with the {@link
 * EZFileExtSelector} that can be displayed within the File Chooser dialogue boxes available from
 * {@link EZFileManager}.
 */
public class EZFileExtDescriptor {
  private String _ext;
  private String _desc;
  private String _buf;

  public EZFileExtDescriptor() {}

  /**
   * Constructor.
   *
   * @param extension file extension
   * @param description file description
   */
  public EZFileExtDescriptor(String extension, String description) {
    super();
    this._ext = extension;
    this._desc = description;
  }

  public String getExtension() {
    return _ext;
  }

  public void setExtension(String extension) {
    this._ext = extension;
    _buf = null;
  }

  public String getDescription() {
    return _desc;
  }

  public void setDescription(String description) {
    this._desc = description;
    _buf = null;
  }

  public String toString() {
    if (_buf == null) _buf = _desc;
    return _buf;
  }
}
