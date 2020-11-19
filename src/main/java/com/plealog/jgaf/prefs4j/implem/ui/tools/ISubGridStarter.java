package com.plealog.jgaf.prefs4j.implem.ui.tools;

import javax.swing.JLabel;

/**
 * This interface is used to start a new canonical grid row (when called from {@link
 * DesignGridLayout#row()}), or to start a new canonical sub-grid in the current grid row (when
 * called from {@link IGridRow}).
 *
 * <p>Using one of the {@code grid()} methods of this interface is mandatory before adding any
 * further component to the current row.
 *
 * <p>Every time {@code grid()} is called for the current row, a new sub-grid is started, with its
 * own specific label column, and additional gap from the previous sub-grid.
 *
 * @author Jean-Francois Poilpret
 */
public interface ISubGridStarter {
  /**
   * Starts a new sub-grid in the row, starting with a label.
   *
   * <p>Labels have a special treatment: they are not a part of the canonical grid but use a
   * fixed-width on the left of the canonical grid. Labels are automatically right-aligned.
   *
   * <p>The new sub-grid initiated by this call will span all space on its right unless another call
   * to a {@code grid()} method occurs in the same row.
   *
   * <p>That sub-grid also allows adding span components, i.e. components that have been added to a
   * row above {@code this} row.
   *
   * @param label the label to add to this row
   * @return {@code this} row (to allow chaining other methods for the current row)
   * @see ISpannableGridRow#spanRow()
   */
  public abstract ISpannableGridRow grid(JLabel label);

  /**
   * Starts a new sub-grid in the row, starting with a label.
   *
   * <p>Labels have a special treatment: they are not a part of the canonical grid but use a
   * fixed-width on the left of the canonical grid. Labels are automatically right-aligned.
   *
   * <p>The new sub-grid initiated by this call will span a certain number of sub-grids on its
   * right, as determined by {@code gridspan}.
   *
   * @param label the label to add to this row
   * @param gridspan the number of sub-grids this new sub-grid should span; if {@code <= 0}, then
   *     the behavior is the same as {@link #grid(JLabel)}.
   * @return {@code this} row (to allow chaining other methods for the current row)
   */
  public abstract IGridRow grid(JLabel label, int gridspan);

  /**
   * Starts a new sub-grid in the row, starting with an empty label.
   *
   * <p>Labels (empty or not) have a special treatment: they are not a part of the canonical grid
   * but use a fixed-width on the left of the canonical grid. Labels are automatically
   * right-aligned.
   *
   * <p>The new sub-grid initiated by this call will span all space on its right unless another call
   * to a {@code grid()} method occurs in the same row.
   *
   * <p>That sub-grid also allows adding span components, i.e. components that have been added to a
   * row above {@code this} row.
   *
   * @return {@code this} row (to allow chaining other methods for the current row)
   * @see ISpannableGridRow#spanRow()
   */
  public abstract ISpannableGridRow grid();

  /**
   * Starts a new sub-grid in the row, starting with an empty label.
   *
   * <p>Labels (empty or not) have a special treatment: they are not a part of the canonical grid
   * but use a fixed-width on the left of the canonical grid. Labels are automatically
   * right-aligned.
   *
   * <p>The new sub-grid initiated by this call will span a certain number of sub-grids on its
   * right, as determined by {@code gridspan}.
   *
   * @param gridspan the number of sub-grids this new sub-grid should span; if {@code <= 0}, then
   *     the behavior is the same as {@link #grid()}.
   * @return {@code this} row (to allow chaining other methods for the current row)
   */
  public abstract IGridRow grid(int gridspan);
}
