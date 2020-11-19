package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to group several rows from a layout, in order to show or hide them all in a
 * single call.
 *
 * <p>This allows to handle dynamic layouts where some rows appear or disappear based on some user
 * settings or actions.
 *
 * <p>Rows can be added at the time they are defined by calling {@link IRowCreator#group}.
 *
 * <p>The following snippet shows {@code RowGroup} usage:
 *
 * <pre>
 * // Set the layout
 * ...
 * RowGroup addressGroup = new RowGroup();
 * layout.row().group(group).grid(label("Address 1")).add(field(""));
 * layout.row().group(group).grid(label("Address 2")).add(field(""));
 * layout.row().group(group).grid(label("Zip")).add(field("")).empty(3);
 * layout.row().group(group).grid(label("City")).add(field(""));
 * ...
 * // Later on, depending on some user action or some other setting
 * addressGroup.hide();
 * </pre>
 *
 * @author Jean-Francois Poilpret
 */
public final class RowGroup {
  void add(IHideable row) {
    _rows.add(new WeakReference<IHideable>(row));
  }

  /**
   * Hides all rows in this {@code RowGroup}, by calling {@link IHideable#hide()} on each of them.
   */
  public void hide() {
    for (WeakReference<IHideable> rowRef : _rows) {
      IHideable row = rowRef.get();
      if (row != null) {
        row.hide();
      }
    }
  }

  /**
   * Restores all rows to their initial visible state, by calling {@link IHideable#show()} for each
   * of them.
   */
  public void show() {
    for (WeakReference<IHideable> rowRef : _rows) {
      IHideable row = rowRef.get();
      if (row != null) {
        row.show();
      }
    }
  }

  private final List<WeakReference<IHideable>> _rows = new ArrayList<WeakReference<IHideable>>();
}
