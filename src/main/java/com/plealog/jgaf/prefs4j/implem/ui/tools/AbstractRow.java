package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.awt.Container;
import java.util.List;
import javax.swing.JComponent;

abstract class AbstractRow implements IHideable {
  @Override
  public final void show() {
    if (_hidden > 0) {
      _hidden--;
      if (_hidden == 0) {
        // Restore visibility of all items
        for (IRowItem item : allItems()) {
          item.show();
        }
      }
    }
  }

  @Override
  public final void hide() {
    if (_hidden == 0) {
      // Hide all items
      for (IRowItem item : allItems()) {
        item.hide();
      }
    }
    _hidden++;
  }

  // Called by DesignGridLayout immediately after instantiation
  final void init(
      ParentWrapper<Container> wrapper,
      HeightGrowPolicy heightTester,
      OrientationPolicy orientation) {
    _wrapper = wrapper;
    _heightTester = heightTester;
    _orientation = orientation;
  }

  // Used by children
  protected final ParentWrapper<Container> parent() {
    return _wrapper;
  }

  // Used by children
  protected final void checkAddedComponent(JComponent component) {
    _wrapper.checkAddedComponent(component);
  }

  // Used by children
  protected final HeightGrowPolicy growPolicy() {
    return _heightTester;
  }

  // Used by children
  protected final OrientationPolicy orientation() {
    return _orientation;
  }

  final void setUnrelatedGap() {
    _unrelatedGap = true;
  }

  final boolean hasUnrelatedGap() {
    return _unrelatedGap;
  }

  final void vgap(int vgap) {
    _vgap = vgap;
  }

  final int vgap() {
    return (_hidden == 0 ? _vgap : 0);
  }

  final void init() {
    _height = ComponentHelper.maxValues(allItems(), PrefHeightExtractor.INSTANCE);
    _baseline = ComponentHelper.maxValues(allItems(), BaselineExtractor.INSTANCE);
    boolean fixedHeight = ComponentHelper.isFixedHeight(_heightTester, items());
    if (fixedHeight || _growWeight == -1.0) {
      _growWeight = (fixedHeight ? 0.0 : 1.0);
    }
  }

  void setLabelAlignment(LabelAlignment align) {}

  protected final int baseline() {
    return (_hidden == 0 ? _baseline : 0);
  }

  final int height() {
    return (_hidden == 0 ? _height : 0);
  }

  final void actualHeight(int height) {
    _actualHeight = height;
  }

  final int actualHeight() {
    return (_hidden == 0 ? _actualHeight : 0);
  }

  final void growWeight(double weight) {
    if (weight >= 0.0) {
      _growWeight = weight;
    }
  }

  final double growWeight() {
    return (_hidden == 0 ? _growWeight : 0.0);
  }

  int numGrids() {
    return 0;
  }

  void totalGrids(int totalGrids) {}

  int gridspan(int grid) {
    return 1;
  }

  int gridColumns(int grid) {
    return 0;
  }

  int labelWidth(int grid) {
    return 0;
  }

  int maxColumnWidth(int grid, int maxColumns, IExtractor extractor) {
    return 0;
  }

  int totalNonGridWidth(int hgap, int unrelhgap) {
    return 0;
  }

  int componentNonGridWidth() {
    return 0;
  }

  void forceComponentNonGridWidth(int width) {}

  int hgap() {
    return ComponentHelper.hgap(allItems(), _wrapper.parent());
  }

  int unrelhgap() {
    return ComponentHelper.unrelhgap(allItems(), _wrapper.parent());
  }

  int gridgap() {
    return 0;
  }

  boolean isEmpty() {
    return allItems().isEmpty();
  }

  JComponent leftComponent() {
    return (allItems().isEmpty() ? null : allItems().get(0).component());
  }

  JComponent rightComponent() {
    return (allItems().isEmpty() ? null : allItems().get(allItems().size() - 1).component());
  }

  void checkSpanRows() {}

  abstract List<? extends IRowItem> items();

  // Returns all items including potential labels
  List<? extends IRowItem> allItems() {
    return items();
  }

  // Returns the actual extra height allocated to the row
  // CSOFF: ParameterNumber
  final int layout(
      LayoutHelper helper,
      int left,
      int hgap,
      int gridgap,
      int unrelhgap,
      int rowWidth,
      int gridsWidth,
      List<Integer> labelsWidth) {
    if (_hidden == 0) {
      return layoutRow(helper, left, hgap, gridgap, unrelhgap, rowWidth, gridsWidth, labelsWidth);
    } else {
      return 0;
    }
  }

  abstract int layoutRow(
      LayoutHelper helper,
      int left,
      int hgap,
      int gridgap,
      int unrelhgap,
      int rowWidth,
      int gridsWidth,
      List<Integer> labelsWidth);
  // CSON: ParameterNumber

  private ParentWrapper<Container> _wrapper;
  private HeightGrowPolicy _heightTester;
  private OrientationPolicy _orientation;
  private boolean _unrelatedGap = false;
  private int _vgap = 0;
  private int _baseline;
  private int _height;
  private double _growWeight = -1.0;
  private int _actualHeight;
  private int _hidden = 0;
}
