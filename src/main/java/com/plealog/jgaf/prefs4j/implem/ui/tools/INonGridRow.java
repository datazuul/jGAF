package com.plealog.jgaf.prefs4j.implem.ui.tools;

import javax.swing.JComponent;

/**
 * Any row created by one of {@code DesignGridLayout.row().left()}, {@code
 * DesignGridLayout.row().center()} or {@code DesignGridLayout.row().right()} implements this
 * interface. Through this interface, you can add components to the current row.
 *
 * <p>All added components share the same width (the maximum of all components preferred widths) and
 * are aligned on the left, center or right depending on which {@link IRowCreator} (returned by
 * {@link DesignGridLayout#row()}) method was called to create this row.
 *
 * @author Jean-Francois Poilpret
 */
public interface INonGridRow extends IRow {
  /*
   * (non-Javadoc)
   * @see IRow#add(javax.swing.JComponent[])
   */
  @Override
  public abstract INonGridRow add(JComponent... children);

  /*
   * (non-Javadoc)
   * @see IRow#addMulti(javax.swing.JComponent[])
   */
  @Override
  public abstract INonGridRow addMulti(JComponent... children);

  /*
   * (non-Javadoc)
   * @see net.java.dev.designgridlayout.IRow#indent()
   */
  @Override
  public abstract INonGridRow indent();

  /*
   * (non-Javadoc)
   * @see net.java.dev.designgridlayout.IRow#indent(int)
   */
  @Override
  public abstract INonGridRow indent(int n);

  /**
   * Sets the "extreme" component(s) of this row to fill the whole space towards the container
   * border. Extreme components are defined as follows:
   *
   * <ul>
   *   <li>For a left-aligned row: the rightmost component
   *   <li>For a centered row: the leftmost and rightmost components
   *   <li>For a right-aligned row: the leftmost component
   * </ul>
   *
   * This proves useful for implementing "group separators" as advised by Karsten Lentzsch (JLabel +
   * JSeparator).
   *
   * @return {@code this} row (to allow chaining other methods for the current row)
   */
  public abstract INonGridRow fill();

  /**
   * Makes this row independent of other non-grid rows in terms of component width. By default,
   * DesignGridLayout ensures that all non-grid rows in a layout use the same width for all
   * components of all these rows. In general, this is the behavior expected by end-users; however,
   * there are some situations where this behavior is not desirable, e.g. when using {@link #fill()}
   * to create a "group separator" where we want the group JLabel to be exactly at its preferred
   * width.
   *
   * <pre>
   * DesignGridLayout layout = new DesignGridLayout(this);
   * //...
   * layout.row().left().add(addressLabel, new JSeparator()).fill().withOwnRowWidth();
   * //...
   * </pre>
   *
   * <p>Note that you can disable DesignGridLayout feature of consistent widths across non-grid rows
   * with {@link DesignGridLayout#withoutConsistentWidthAcrossNonGridRows()}.
   *
   * @return {@code this} row (to allow chaining other methods for the current row)
   */
  public abstract INonGridRow withOwnRowWidth();
}
