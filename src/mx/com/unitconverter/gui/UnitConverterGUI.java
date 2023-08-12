package mx.com.unitconverter.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.awt.Cursor;
import javax.swing.border.LineBorder;


import mx.com.unitconverter.magnitudedef.CurrencyType;
import mx.com.unitconverter.magnitudedef.MagnitudeType;
import mx.com.unitconverter.magnitudedef.UnitType;
import mx.com.unitconverter.model.Magnitude;
import mx.com.unitconverter.model.MeasurementUnit;
import mx.com.unitconverter.model.MonetaryUnit;

import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.CompoundBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.ImageIcon;


public class UnitConverterGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private int xMouse, yMouse;
	
	private MagnitudeType selectedMagnitude = MagnitudeType.CURRENCY;
	private int selectedMenuIndex = 0;
	private boolean inputJustFocused = false;
	
	private Magnitude fromUnit = new MonetaryUnit(CurrencyType.USD);
	private Magnitude toUnit = new MonetaryUnit(CurrencyType.MXN);
	private Magnitude fromUnitRates = new MonetaryUnit(CurrencyType.USD);
	private Magnitude toUnitRates = new MonetaryUnit(CurrencyType.MXN);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnitConverterGUI frame = new UnitConverterGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UnitConverterGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 275);
		setLocationByPlatform(true);
		setUndecorated(true);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel bgContentFrame = new JPanel();
		bgContentFrame.setBorder(new EmptyBorder(0, 0, 0, 0));
		bgContentFrame.setBackground(new Color(244, 246, 247));
		bgContentFrame.setForeground(new Color(255, 255, 255));
		bgContentFrame.setBounds(0, 0, 600, 275);
		contentPane.add(bgContentFrame);
		bgContentFrame.setLayout(null);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xMouse, y - yMouse);
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		header.setOpaque(false);
		header.setBounds(0, 0, 600, 40);
		bgContentFrame.add(header);
		header.setLayout(null);
		
		JLabel btnExit = new JLabel("X");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setOpaque(true);
		btnExit.setBackground(new Color(0, 134, 190));
		btnExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(new Color(0, 134, 190));
			}
		});
		btnExit.setHorizontalAlignment(SwingConstants.CENTER);
		btnExit.setBounds(560, 0, 40, 40);
		btnExit.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		header.add(btnExit);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(0, 134, 190));
		menuPanel.setBounds(0, 0, 186, 275);
		bgContentFrame.add(menuPanel);
		
		JLabel logoLabel = new JLabel("iConvert");
		logoLabel.setForeground(new Color(255, 255, 255));
		logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logoLabel.setFont(new Font("Roboto", Font.BOLD, 24));
		logoLabel.setBounds(0, 0, 186, 75);
		menuPanel.add(logoLabel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(0, 134, 190));
		buttonPanel.setBounds(0, 75, 186, 175);
		
		JLabel currencyBtn = new JLabel("Divisas");
		currencyBtn.setIcon(new ImageIcon(UnitConverterGUI.class.getResource("/mx/com/unitconverter/images/logoCurrency.png")));
		currencyBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		currencyBtn.setBackground(new Color(0, 141, 202));
		currencyBtn.setOpaque(true);
		currencyBtn.setBounds(0, 0, 186, 25);
		currencyBtn.setPreferredSize(new Dimension(186, 25));
		currencyBtn.setForeground(new Color(255, 255, 255));
		currencyBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		currencyBtn.setBorder(new EmptyBorder(0, 10, 0, 0));
		
		JLabel lengthBtn = new JLabel("Longitud");
		lengthBtn.setIcon(new ImageIcon(UnitConverterGUI.class.getResource("/mx/com/unitconverter/images/logoLength.png")));
		lengthBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lengthBtn.setBackground(new Color(0, 134, 190));
		lengthBtn.setOpaque(true);
		lengthBtn.setBounds(0, 25, 186, 25);
		lengthBtn.setPreferredSize(new Dimension(186, 25));
		lengthBtn.setForeground(Color.WHITE);
		lengthBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		lengthBtn.setBorder(new EmptyBorder(0, 10, 0, 0));
		buttonPanel.setLayout(null);
		buttonPanel.add(currencyBtn);
		buttonPanel.add(lengthBtn);
		
		JLabel massBtn = new JLabel("Masa");
		massBtn.setIcon(new ImageIcon(UnitConverterGUI.class.getResource("/mx/com/unitconverter/images/logoMass.png")));
		massBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		massBtn.setBackground(new Color(0, 134, 190));
		massBtn.setOpaque(true);
		massBtn.setPreferredSize(new Dimension(186, 25));
		massBtn.setForeground(Color.WHITE);
		massBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		massBtn.setBorder(new EmptyBorder(0, 10, 0, 0));
		massBtn.setBounds(0, 50, 186, 25);
		buttonPanel.add(massBtn);
		
		JLabel volumeBtn = new JLabel("Volumen");
		volumeBtn.setIcon(new ImageIcon(UnitConverterGUI.class.getResource("/mx/com/unitconverter/images/logoVolume.png")));
		volumeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		volumeBtn.setBackground(new Color(0, 134, 190));
		volumeBtn.setOpaque(true);
		volumeBtn.setPreferredSize(new Dimension(186, 25));
		volumeBtn.setForeground(Color.WHITE);
		volumeBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		volumeBtn.setBorder(new EmptyBorder(0, 10, 0, 0));
		volumeBtn.setBounds(0, 75, 186, 25);
		buttonPanel.add(volumeBtn);
		
		JLabel temperatureBtn = new JLabel("Temperatura");
		temperatureBtn.setIcon(new ImageIcon(UnitConverterGUI.class.getResource("/mx/com/unitconverter/images/logoTemperature.png")));
		temperatureBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		temperatureBtn.setBackground(new Color(0, 134, 190));
		temperatureBtn.setOpaque(true);
		temperatureBtn.setPreferredSize(new Dimension(186, 25));
		temperatureBtn.setForeground(Color.WHITE);
		temperatureBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		temperatureBtn.setBorder(new EmptyBorder(0, 10, 0, 0));
		temperatureBtn.setBounds(0, 100, 186, 25);
		buttonPanel.add(temperatureBtn);
		
		JLabel aboutBtn = new JLabel("Acerca de");
		aboutBtn.setIcon(new ImageIcon(UnitConverterGUI.class.getResource("/mx/com/unitconverter/images/logoAbout.png")));
		aboutBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		aboutBtn.setBackground(new Color(0, 134, 190));
		aboutBtn.setOpaque(true);
		aboutBtn.setPreferredSize(new Dimension(186, 25));
		aboutBtn.setForeground(Color.WHITE);
		aboutBtn.setFont(new Font("Roboto", Font.BOLD, 14));
		aboutBtn.setBorder(new EmptyBorder(0, 10, 0, 0));
		aboutBtn.setBounds(0, 149, 186, 25);
		buttonPanel.add(aboutBtn);
		menuPanel.setLayout(null);
		menuPanel.add(buttonPanel);
		
		List<JLabel> menuBtn = new ArrayList<>();
		menuBtn.add(currencyBtn);
		menuBtn.add(lengthBtn);
		menuBtn.add(massBtn);
		menuBtn.add(volumeBtn);
		menuBtn.add(temperatureBtn);
		
		JTextField inputValueTxt = new JTextField();
		inputValueTxt.setFocusable(false);
		inputValueTxt.setCaretColor(new Color(200, 200, 200));
		inputValueTxt.setForeground(new Color(200, 200, 200));
		inputValueTxt.setText("0");
		inputValueTxt.setFont(new Font("Roboto Light", Font.BOLD, 16));
		inputValueTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		inputValueTxt.setBounds(198, 75, 123, 40);
		inputValueTxt.setColumns(10);
		inputValueTxt.setBorder(new CompoundBorder(new LineBorder(new Color(230, 230, 230)), new EmptyBorder(0, 0, 0, 10)));
		bgContentFrame.add(inputValueTxt);
		
		JTextField outputValueTxt = new JTextField();
		outputValueTxt.setText("0");
		outputValueTxt.setHorizontalAlignment(SwingConstants.RIGHT);
		outputValueTxt.setForeground(new Color(200, 200, 200));
		outputValueTxt.setFont(new Font("Roboto Light", Font.BOLD, 16));
		outputValueTxt.setFocusable(false);
		outputValueTxt.setColumns(10);
		outputValueTxt.setCaretColor(new Color(200, 200, 200));
		outputValueTxt.setBorder(new CompoundBorder(new LineBorder(new Color(230, 230, 230)), new EmptyBorder(0, 0, 0, 10)));
		outputValueTxt.setBounds(198, 125, 123, 40);
		bgContentFrame.add(outputValueTxt);
		
		AutoCompleteComboBox fromUnitCBox = new AutoCompleteComboBox(new DefaultComboBoxModel<String>());
		fromUnitCBox.setToolTipText("");
		fromUnitCBox.setModel(getComboBoxItems(selectedMagnitude));
		fromUnitCBox.setSelectedItem(fromUnit.getName());
		fromUnitCBox.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		fromUnitCBox.setBackground(new Color(255, 255, 255));
		fromUnitCBox.setBounds(333, 75, 197, 40);
		fromUnitCBox.setBorder(new CompoundBorder(new LineBorder(new Color(230, 230, 230)), new EmptyBorder(0, 10, 0, 0)));
		bgContentFrame.add(fromUnitCBox);
		
		AutoCompleteComboBox toUnitCBox = new AutoCompleteComboBox(new DefaultComboBoxModel<String>());
		toUnitCBox.setModel(getComboBoxItems(selectedMagnitude));
		toUnitCBox.setSelectedItem(toUnit.getName());
		toUnitCBox.setBackground(new Color(255, 255, 255));
		toUnitCBox.setBounds(333, 125, 197, 40);
		toUnitCBox.setBorder(new CompoundBorder(new LineBorder(new Color(230, 230, 230)), new EmptyBorder(0, 10, 0, 0)));
		toUnitCBox.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		bgContentFrame.add(toUnitCBox);
		
		JLabel fromResultFormulaLbl = new JLabel("New label");
		fromResultFormulaLbl.setHorizontalAlignment(SwingConstants.RIGHT);
		fromResultFormulaLbl.setFont(new Font("Roboto Black", Font.BOLD, 24));
		fromResultFormulaLbl.setBounds(198, 194, 107, 28);
		bgContentFrame.add(fromResultFormulaLbl);
		
		JLabel equalsFormulaLbl = new JLabel("=");
		equalsFormulaLbl.setFont(new Font("Roboto Black", Font.BOLD, 24));
		equalsFormulaLbl.setBounds(320, 194, 15, 28);
		bgContentFrame.add(equalsFormulaLbl);
		
		JLabel toResultFormulaLbl = new JLabel("New label");
		toResultFormulaLbl.setHorizontalAlignment(SwingConstants.LEFT);
		toResultFormulaLbl.setFont(new Font("Roboto Black", Font.BOLD, 24));
		toResultFormulaLbl.setBounds(346, 194, 197, 28);
		bgContentFrame.add(toResultFormulaLbl);
		
		JLabel swapBtn = new JLabel("");
		swapBtn.setBorder(new LineBorder(new Color(0, 142, 204), 1, true));
		swapBtn.setIcon(new ImageIcon(UnitConverterGUI.class.getResource("/mx/com/unitconverter/images/logoInterchange.png")));
		swapBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		swapBtn.setOpaque(true);
		swapBtn.setBackground(new Color(0, 134, 190));
		swapBtn.setBounds(540, 94, 50, 50);
		bgContentFrame.add(swapBtn);
		
		fromUnitRates.setValue(1);
		fromResultFormulaLbl.setText("1 " + fromUnit.getSymbol());
		try {
			toUnitRates.setValue(fromUnitRates.convertTo(toUnitRates));
		} catch (Exception e) {
			e.printStackTrace();
		}
		toResultFormulaLbl.setText(String.valueOf(toUnitRates.getValue()) + " " + toUnitRates.getSymbol());
		
		currencyBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				currencyBtn.setBackground(new Color(0, 141, 202));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (selectedMenuIndex != 0)
					currencyBtn.setBackground(new Color(0, 134, 190));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMagnitude = MagnitudeType.CURRENCY;
				selectedMenuIndex = 0;
				fromUnitCBox.setModel(getComboBoxItems(selectedMagnitude));
				toUnitCBox.setModel(getComboBoxItems(selectedMagnitude));
				fromUnitCBox.setSelectedItem(CurrencyType.USD.getName());
				toUnitCBox.setSelectedItem(CurrencyType.MXN.getName());
				
				menuBtn.forEach(menu -> menu.setBackground(new Color(0, 134, 190)));
				menuBtn.get(selectedMenuIndex).setBackground(new Color(0, 141, 202));
			}
		});
		
		lengthBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lengthBtn.setBackground(new Color(0, 141, 202));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (selectedMenuIndex != 1)
					lengthBtn.setBackground(new Color(0, 134, 190));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMagnitude = MagnitudeType.LENGTH;
				selectedMenuIndex = 1;
				fromUnitCBox.setModel(getComboBoxItems(selectedMagnitude));
				toUnitCBox.setModel(getComboBoxItems(selectedMagnitude));
				fromUnitCBox.setSelectedItem(UnitType.METER.getName());
				toUnitCBox.setSelectedItem(UnitType.CENTIMETER.getName());
				
				menuBtn.forEach(menu -> menu.setBackground(new Color(0, 134, 190)));
				menuBtn.get(selectedMenuIndex).setBackground(new Color(0, 141, 202));
			}
		});
		
		massBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				massBtn.setBackground(new Color(0, 141, 202));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (selectedMenuIndex != 2)
					massBtn.setBackground(new Color(0, 134, 190));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMagnitude = MagnitudeType.MASS;
				selectedMenuIndex = 2;
				fromUnitCBox.setModel(getComboBoxItems(selectedMagnitude));
				toUnitCBox.setModel(getComboBoxItems(selectedMagnitude));
				fromUnitCBox.setSelectedItem(UnitType.KILOGRAM.getName());
				toUnitCBox.setSelectedItem(UnitType.GRAM.getName());
				
				menuBtn.forEach(menu -> menu.setBackground(new Color(0, 134, 190)));
				menuBtn.get(selectedMenuIndex).setBackground(new Color(0, 141, 202));
			}
		});
		
		volumeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				volumeBtn.setBackground(new Color(0, 141, 202));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (selectedMenuIndex != 3)
					volumeBtn.setBackground(new Color(0, 134, 190));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMagnitude = MagnitudeType.VOLUME;
				selectedMenuIndex = 3;
				fromUnitCBox.setModel(getComboBoxItems(selectedMagnitude));
				toUnitCBox.setModel(getComboBoxItems(selectedMagnitude));
				fromUnitCBox.setSelectedItem(UnitType.LITER.getName());
				toUnitCBox.setSelectedItem(UnitType.MILILITER.getName());
				
				menuBtn.forEach(menu -> menu.setBackground(new Color(0, 134, 190)));
				menuBtn.get(selectedMenuIndex).setBackground(new Color(0, 141, 202));
			}
		});
		
		temperatureBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				temperatureBtn.setBackground(new Color(0, 141, 202));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (selectedMenuIndex != 4)
					temperatureBtn.setBackground(new Color(0, 134, 190));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMagnitude = MagnitudeType.TEMPERATURE;
				selectedMenuIndex = 4;
				fromUnitCBox.setModel(getComboBoxItems(selectedMagnitude));
				toUnitCBox.setModel(getComboBoxItems(selectedMagnitude));
				fromUnitCBox.setSelectedItem(UnitType.CELSIUS.getName());
				toUnitCBox.setSelectedItem(UnitType.FAHRENHEIT.getName());
				
				menuBtn.forEach(menu -> menu.setBackground(new Color(0, 134, 190)));
				menuBtn.get(selectedMenuIndex).setBackground(new Color(0, 141, 202));
			}
		});
		
		aboutBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				aboutBtn.setBackground(new Color(0, 141, 202));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				aboutBtn.setBackground(new Color(0, 134, 190));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int currentYear = Year.now().getValue();
				String msgDialogMsg, msgDialogTitle = "About iConvert";
				msgDialogMsg = "iConvert Version 0.1.0\n\n";
				msgDialogMsg += "Copyleft " + currentYear + " Program by Gerardo Velasco\n\n";
				msgDialogMsg += "You are granted a free license to use iConvert for\n ";
				msgDialogMsg += "personal and internal business purposes.\n\n";
				msgDialogMsg += "https://github.com/stratogavo\n\n";
				JOptionPane.showMessageDialog(bgContentFrame, msgDialogMsg, msgDialogTitle, JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		inputValueTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String inputText = inputValueTxt.getText();
				if (inputText.equals("0") || inputText.equals("")) {
					inputValueTxt.setFocusable(true);
					inputValueTxt.requestFocus();
					inputJustFocused = true;
					inputValueTxt.setCaretPosition(inputValueTxt.getText().length());
				}
				inputValueTxt.setBorder(new CompoundBorder(
						new LineBorder(new Color(0, 134, 190)), new EmptyBorder(0, 0, 0, 10)));
			}
		});
		
		inputValueTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(inputJustFocused) {
					inputJustFocused = false;
					inputValueTxt.setText("");
					inputValueTxt.setForeground(new Color(51, 51, 51));
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				outputValueTxt.setForeground(new Color(51, 51, 51));
				
				String inputText = inputValueTxt.getText();
				if (inputText.equals(".") ||inputText.equals("")) {
					outputValueTxt.setForeground(new Color(200, 200, 200));
					inputText = "0";
				}
				
				String fromMagnitude = fromUnitCBox.getSelectedItem().toString();
				String toMagnitude = toUnitCBox.getSelectedItem().toString();
				Double magnitudeValue;
				
				if (inputValueTxt.getText().equals("") || inputValueTxt.getText().equals("."))
					magnitudeValue = 0D;
				else
					magnitudeValue = Double.parseDouble(inputValueTxt.getText());
				
				List<String> conversion = getConversionResults(magnitudeValue, fromMagnitude, toMagnitude);
				outputValueTxt.setText(conversion.get(0));
				fromResultFormulaLbl.setText("1 " + conversion.get(1));
				toResultFormulaLbl.setText(conversion.get(2));
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && c != '.') {
					e.consume(); // ignore event
				}
			}
		});
		
		inputValueTxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String inputText = inputValueTxt.getText();
				if(inputText.equals("0") || inputText.equals("") || inputText.equals(".")) {
					inputValueTxt.setForeground(new Color(200, 200, 200));
					outputValueTxt.setForeground(new Color(200, 200, 200));
					inputValueTxt.setText("0");
				}
				inputValueTxt.setBorder(
						new CompoundBorder(new LineBorder(new Color(230, 230, 230)), new EmptyBorder(0, 0, 0, 10)));
			}
		});
		
		fromUnitCBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String fromMagnitude = fromUnitCBox.getSelectedItem().toString();
				String toMagnitude = toUnitCBox.getSelectedItem().toString();
				Double magnitudeValue;
				
				if (inputValueTxt.getText().equals("") || inputValueTxt.getText().equals("."))
					magnitudeValue = 0D;
				else
					magnitudeValue = Double.parseDouble(inputValueTxt.getText());
				
				List<String> conversion = getConversionResults(magnitudeValue, fromMagnitude, toMagnitude);
				outputValueTxt.setText(conversion.get(0));
				fromResultFormulaLbl.setText("1 " + conversion.get(1));
				toResultFormulaLbl.setText(conversion.get(2));	
			}
		});
		
		toUnitCBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String fromMagnitude = fromUnitCBox.getSelectedItem().toString();
				String toMagnitude = toUnitCBox.getSelectedItem().toString();
				Double magnitudeValue;
				
				if (inputValueTxt.getText().equals("") || inputValueTxt.getText().equals("."))
					magnitudeValue = 0D;
				else
					magnitudeValue = Double.parseDouble(inputValueTxt.getText());
				
				List<String> conversion = getConversionResults(magnitudeValue, fromMagnitude, toMagnitude);
				outputValueTxt.setText(conversion.get(0));
				fromResultFormulaLbl.setText("1 " + conversion.get(1));
				toResultFormulaLbl.setText(conversion.get(2));
			}
		});
		
		swapBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				swapBtn.setBackground(new Color(0, 141, 202));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				swapBtn.setBackground(new Color(0, 134, 190));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int fromInitialIndex = fromUnitCBox.getSelectedIndex();
				int toInitialIndex = toUnitCBox.getSelectedIndex();
				fromUnitCBox.setSelectedIndex(toInitialIndex);
				toUnitCBox.setSelectedIndex(fromInitialIndex);
			}
		});
		
	}
	
	private DefaultComboBoxModel<String> getComboBoxItems(MagnitudeType type) {
		List<String> magnitudeList = new ArrayList<>();
		if (type == MagnitudeType.CURRENCY) 
			CurrencyType.stream().filter(measurementUnit -> measurementUnit.getType().equals(type.toString())).
				forEach(measurementUnit -> magnitudeList.add(measurementUnit.getName()));
		else 
			UnitType.stream().filter(measurementUnit -> measurementUnit.getType().equals(type.toString())).
				forEach(measurementUnit -> magnitudeList.add(measurementUnit.getName()));
		return new DefaultComboBoxModel<String>(magnitudeList.toArray(new String[0]));
	}
	
	private List<String> getConversionResults(Double magnitudeValue, String fromMagnitude, String toMagnitude) {
		List<String> conversionResult = new LinkedList<>();
		Magnitude fromResult, toResult;
		Magnitude fromResultFormula, toResultFormula;
		
		CurrencyType fromCurrency = CurrencyType.getCurrencyByName(fromMagnitude);
		CurrencyType toCurrency = CurrencyType.getCurrencyByName(toMagnitude);
		
		if (fromCurrency != null && toCurrency != null) {
			fromResult = new MonetaryUnit(magnitudeValue, fromCurrency);
			toResult = new MonetaryUnit(toCurrency);
			fromResultFormula = new MonetaryUnit(1, fromCurrency);
			toResultFormula = new MonetaryUnit(toCurrency);
		} else {
			UnitType fromUnit = UnitType.getUnitByName(fromMagnitude);
			UnitType toUnit = UnitType.getUnitByName(toMagnitude);
			fromResult = new MeasurementUnit(magnitudeValue, fromUnit);
			toResult = new MeasurementUnit(toUnit);
			fromResultFormula = new MeasurementUnit(1, fromUnit);
			toResultFormula = new MeasurementUnit(toUnit);
		}
		
		try {
			// Gets conversion result and stores its value in class toResul
			toResult.setValue(fromResult.convertTo(toResult));
			//Gets conversion factor and stores its value in class toResultFormula
			toResultFormula.setValue(fromResultFormula.convertTo(toResultFormula));
			
			conversionResult.add(String.valueOf(toResult.getValue()));
			conversionResult.add(fromResultFormula.getSymbol());
			conversionResult.add(String.valueOf(toResultFormula.getValue()) + " " + toResultFormula.getSymbol());
			
			// Shows temperature conversion formula
			if (fromResult.getType().equals(MagnitudeType.TEMPERATURE.toString()) && 
					toResult.getType().equals(MagnitudeType.TEMPERATURE.toString())) {
				Double tempConvRate = UnitType.getConversionRate(fromMagnitude, toMagnitude);
				BigDecimal roundedTempConvRate = new BigDecimal(tempConvRate).setScale(2, RoundingMode.HALF_UP);
				Double tempOffset = UnitType.getTempConversionOffset(fromMagnitude, toMagnitude);
				BigDecimal roundedTempOffset = new BigDecimal(tempOffset).setScale(2, RoundingMode.HALF_UP);
				
				if (tempOffset < 0)
					conversionResult.set(2, String.valueOf(roundedTempConvRate) + " " + toResultFormula.getSymbol() + 
							" - " + String.valueOf(roundedTempOffset.doubleValue() * -1));
				else if (tempOffset == 0)
					conversionResult.set(2, String.valueOf(roundedTempConvRate) + " " + toResultFormula.getSymbol());
				else
					conversionResult.set(2, String.valueOf(roundedTempConvRate) + " " + toResultFormula.getSymbol() + 
							" + " + String.valueOf(roundedTempOffset.doubleValue()));
			// --------------------------------------------------------------------------------------------------------	
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conversionResult;
	}
}
