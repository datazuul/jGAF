package com.plealog.jgaf.prefs4j.implem.ui.tools;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JComponent;

final class ParentWrapper<T extends Container> {
  ParentWrapper(T parent) {
    _parent = parent;
  }

  void checkParent(Container parent) {
    if (parent != _parent) {
      throw new IllegalArgumentException("Must use layout instance with original parent container");
    }
  }

  void add(Component child) {
    try {
      _addChild = true;
      _parent.add(child);
    } finally {
      _addChild = false;
    }
  }

  void checkAddedComponent(JComponent component) {
    Container parent = component;
    while (parent != null) {
      if (parent == _parent) {
        throw new IllegalArgumentException("Do not add the same component twice");
      }
      parent = parent.getParent();
    }
  }

  void checkAdd() {
    if (!_addChild) {
      // TODO better message
      throw new IllegalArgumentException("Do not use this method");
    }
  }

  T parent() {
    return _parent;
  }

  private final T _parent;
  private boolean _addChild = false;
}
