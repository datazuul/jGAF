package com.plealog.jgaf.prefs4j.implem.ui.tools;

import javax.swing.JComponent;

/**
 * Any row created by {@code DesignGridLayout.row().grid()} implements this interface. Through this
 * interface, you can add components to the current row; position and size of components will use
 * the canonical grid calculated for the whole layout.
 *
 * @author Jean-Francois Poilpret
 */
public interface IGridRow extends IRow, ISubGridStarter {
  /*
   * (non-Javadoc)
   * @see IRow#add(javax.swing.JComponent[])
   */
  @Override
  public abstract IGridRow add(JComponent... children);

  /**
   * Adds one component to this row and allows it to span several columns of the canonical grid.
   *
   * <p>The order of calls match the order in which the components will be added to this row.
   * Components are added left to right, in the same order as they appear in the arguments list.
   *
   * @param child component to add to this row; it is added to the right of the component that was
   *     added by the nearest previous call to an add method.
   * @param span the number of columns to span (must be &gt; 0)
   * @return {@code this} row (to allow chaining other methods for the current row)
   */
  public abstract IGridRow add(JComponent child, int span);

  /**
   * Adds an empty column to the current row.
   *
   * @return {@code this} row (to allow chaining other methods for the current row)
   */
  public abstract IGridRow empty();

  /**
   * Adds one or more empty columns to the current row.
   *
   * @param span the number of columns to span (must be &gt; 0)
   * @return {@code this} row (to allow chaining other methods for the current row)
   */
  public abstract IGridRow empty(int span);

  /*
   * (non-Javadoc)
   * @see IRow#addMulti(javax.swing.JComponent[])
   */
  @Override
  public abstract IGridRow addMulti(JComponent... children);

  /*
   * (non-Javadoc)
   * @see net.java.dev.designgridlayout.IRow#indent()
   */
  @Override
  public abstract IGridRow indent();

  /*
   * (non-Javadoc)
   * @see net.java.dev.designgridlayout.IRow#indent(int)
   */
  @Override
  public abstract IGridRow indent(int n);

  /**
   * Adds components to this row; all components are "assembled" as one global component and span a
   * given number of columns in the row.
   *
   * <p>Note that the width of each individual component will never grow bigger than its preferred
   * width.
   *
   * @param span the number of columns to span (must be &gt; 0)
   * @param children components to assemble and add to this row
   * @return {@code this} row (to allow chaining other methods for the current row)
   * @deprecated Use {@link #add(JComponent, int)} with {@link Componentizer} instead.
   */
  @Deprecated
  public abstract IGridRow addMulti(int span, JComponent... children);
}
