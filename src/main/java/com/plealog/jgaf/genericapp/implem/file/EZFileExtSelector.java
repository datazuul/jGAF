package com.plealog.jgaf.genericapp.implem.file;

import com.plealog.jgaf.genericapp.ui.common.ResizableComboboxPopupMenuListener;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * This is a basic component aims at displaying a list of {@link EZFileExtDescriptor} within a
 * JComboBox. For internal use only
 */
public class EZFileExtSelector extends JPanel {
  private static final long serialVersionUID = 3087118831467808734L;

  private JComboBox<EZFileExtDescriptor> _selector;
  private List<EZFileExtDescriptor> _types;

  public EZFileExtSelector(List<EZFileExtDescriptor> types) {
    _types = types;
    createGUI();
  }

  public EZFileExtDescriptor getSelectedFType() {
    return (EZFileExtDescriptor) _selector.getSelectedItem();
  }

  private void createGUI() {
    JPanel pnl;

    _selector = new JComboBox<>();
    _selector.addPopupMenuListener(new ResizableComboboxPopupMenuListener());
    for (EZFileExtDescriptor dft : _types) {
      _selector.addItem(dft);
    }
    pnl = new JPanel(new BorderLayout());
    pnl.add(_selector, BorderLayout.CENTER);
    pnl.setBorder(BorderFactory.createTitledBorder("Export format to use:"));
    this.setLayout(new BorderLayout());
    this.add(pnl, BorderLayout.CENTER);
  }
}
