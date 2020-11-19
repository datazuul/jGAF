package com.plealog.jgaf.prefs4j.implem.ui.tools;

/**
 * Any row created by {@link DesignGridLayout} implements this minimal interface. Through this
 * interface you can hide or show the row.
 *
 * @author Jean-Francois Poilpret
 */
public interface IHideable {
  /**
   * Hides the whole row, ie all its components, forcing its visible height to 0. This allows to
   * handle dynamic layouts where some rows appear or disappear based on some user settings or
   * actions.
   *
   * <p>An {@code IRow} that has been hidden can be shown again by calling {@link #show()}.
   *
   * <p>Note that you can call {@code hide()} several times, but you must then call {@link #show()}
   * the same number of times to make the row visible again.
   *
   * <p>When a row containing a spanned component (see {@link ISpannableGridRow#spanRow()}) is
   * hidden, resize behavior is not well handled unless all rows containing the same spanning
   * component are also hidden altogether (which is the common use case).
   */
  public abstract void hide();

  /**
   * Restores the whole row to a visible state, ie all its components' visibilities are restored to
   * their original state prior to calling {@link #hide()}.
   *
   * <p>Note that calling {@code show()} on an already visible row has no effect at all.
   *
   * <p>Also, if {@link #hide()} has been called several times, then {@code show()} will have to be
   * called the same number of times for the row to become visible again.
   */
  public abstract void show();
}
