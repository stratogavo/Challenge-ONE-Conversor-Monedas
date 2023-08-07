package mx.com.unitconverter.gui;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ComboBoxEditor;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicComboBoxEditor;

public class AutoCompleteComboBox extends JComboBox<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int caretPos = 0;
	private JTextField tfield = null;

	public AutoCompleteComboBox(final ComboBoxModel<String> items) {
		super(items);
		setEditor(new BasicComboBoxEditor());
		setEditable(true);
	}

	public void setSelectedIndex(int index) {
		super.setSelectedIndex(index);
		tfield.setText(getItemAt(index).toString());
		tfield.setSelectionEnd(caretPos + tfield.getText().length());
		tfield.moveCaretPosition(caretPos);
	}

	public void setEditor(ComboBoxEditor editor) {
		super.setEditor(editor);
		if (editor.getEditorComponent() instanceof JTextField) {
			tfield = (JTextField) editor.getEditorComponent();
			tfield.setCaretColor(new Color(240,240,240));
			tfield.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent ke) {
					char key = ke.getKeyChar();
					if (!(Character.isLetterOrDigit(key) || Character.isSpaceChar(key)))
						return;
					caretPos = tfield.getCaretPosition();
					String text = "";
					try {
						text = tfield.getText(0, caretPos);
					} catch (javax.swing.text.BadLocationException e) {
						e.printStackTrace();
					}
					for (int i = 0; i < getItemCount(); i++) {
						String element = (String) getItemAt(i);
						if (element.startsWith(text)) {
							setSelectedIndex(i);
							caretPos = 0;
							return;
						}
					}
				}
			});
		}
	}

}
