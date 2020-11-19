package com.plealog.jgaf.genericapp.api.file;

import com.plealog.jgaf.genericapp.implem.file.EZFileExtDescriptor;
import java.io.File;

/**
 * This class is used to handle a file with a particular file extension descriptor. For internal use
 * only.
 */
public class EZFileExt {
  private File file;
  private EZFileExtDescriptor fileType;

  public EZFileExt(File file) {
    super();
    this.file = file;
  }

  public EZFileExt(File file, EZFileExtDescriptor fileType) {
    super();
    this.file = file;
    this.fileType = fileType;
  }

  public File getFile() {
    return file;
  }

  public void setFile(File file) {
    this.file = file;
  }

  public EZFileExtDescriptor getFileType() {
    return fileType;
  }

  public void setFileType(EZFileExtDescriptor fileType) {
    this.fileType = fileType;
  }
}
