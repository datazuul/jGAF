package com.plealog.jgaf.prefs4j.implem.ui.tools;

import static com.plealog.jgaf.prefs4j.implem.ui.tools.Componentizer.WidthPolicy.MIN_AND_MORE;
import static com.plealog.jgaf.prefs4j.implem.ui.tools.Componentizer.WidthPolicy.MIN_TO_PREF;
import static com.plealog.jgaf.prefs4j.implem.ui.tools.Componentizer.WidthPolicy.PREF_AND_MORE;
import static com.plealog.jgaf.prefs4j.implem.ui.tools.Componentizer.WidthPolicy.PREF_FIXED;

import com.plealog.jgaf.prefs4j.implem.ui.tools.Componentizer.WidthPolicy;
import javax.swing.JComponent;

// Used for all components added to a Componentizer
class ComponentizerItem extends BasicItem {
  public ComponentizerItem(JComponent component, WidthPolicy widthPolicy) {
    super(component);
    _widthPolicy = widthPolicy;
  }

  @Override
  public int minimumWidth() {
    switch (_widthPolicy) {
      case PREF_FIXED:
      case PREF_AND_MORE:
        return preferredWidth();

      case MIN_TO_PREF:
      case MIN_AND_MORE:
      default:
        return super.minimumWidth();
    }
  }

  public WidthPolicy widthPolicy() {
    return _widthPolicy;
  }

  private final WidthPolicy _widthPolicy;
}
