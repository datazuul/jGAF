package com.plealog.jgaf.genericapp.ui.common;

import com.plealog.jgaf.genericapp.api.log.EZLogger;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

/**
 * Implements copy to and paste from clipboard functions.
 *
 * @author Patrick G. Durand
 */
public class ClipBoardTextTransfer implements ClipboardOwner {

  /** Implementation of ClipboardOwner interface. */
  public void lostOwnership(Clipboard arg0, Transferable arg1) {}

  /**
   * Place a String on the system clipboard, and make this class the owner of the Clipboard&apos;s
   * contents.
   */
  public void setClipboardContents(String aString) {
    StringSelection stringSelection = new StringSelection(aString);
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(stringSelection, this);
  }

  /**
   * Get the String residing on the system clipboard.
   *
   * @return any text found on the system clipboard; if none found, return an empty String.
   */
  public String getClipboardContents() {
    String result = "";
    Clipboard clipboard;
    Transferable contents;
    boolean hasTransferableText;

    try {
      clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
      // odd: the Object param of getContents is not currently used
      contents = clipboard.getContents(null);
      hasTransferableText =
          (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
      if (hasTransferableText) {
        try {
          result = (String) contents.getTransferData(DataFlavor.stringFlavor);
        } catch (Exception ex) {
          EZLogger.warn(ex.toString());
        }
      }
    } catch (OutOfMemoryError E) {
    }

    return result;
  }
}
