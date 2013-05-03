package com.rob.calculator.ui;

import javax.swing.JPanel;

import com.rob.calculator.ICalculatorBehavior;
import com.rob.calculator.ParserException;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CalculatorButtonsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICalculatorBehavior _calculator;
	private JTextField inputText;
	private JLabel label;
	/**
	 * Create the panel.
	 */
	public CalculatorButtonsPanel(ICalculatorBehavior calculator) {
		_calculator = calculator;
		
		setLayout(new BorderLayout());
		
		label = new JLabel();
		label.setVisible(true);
		add(label, BorderLayout.SOUTH);
		//number panel
		JPanel numberPanel = new JPanel();
		numberPanel.setLayout(new GridLayout(4,3,10,0));
		
		JButton button = new JButton("1");
		button.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				appendNumber(1);				
			}
		});
		numberPanel.add(button);
		
		JButton button_1 = new JButton("2");
		button_1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				appendNumber(2);				
			}
		});
		numberPanel.add(button_1);
		
		JButton button_2 = new JButton("3");
		button_2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				appendNumber(3);				
			}
		});
		numberPanel.add(button_2);
		
		JButton button_3 = new JButton("4");
		button_3.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				appendNumber(4);				
			}
		});
		numberPanel.add(button_3);
		
		JButton button_4 = new JButton("5");
		button_4.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				appendNumber(5);				
			}
		});
		numberPanel.add(button_4);
		
		JButton button_5 = new JButton("6");
		button_5.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				appendNumber(6);				
			}
		});
		numberPanel.add(button_5);
		
		JButton button_6 = new JButton("7");
		button_6.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				appendNumber(7);				
			}
		});
		numberPanel.add(button_6);
		
		JButton button_7 = new JButton("8");
		button_7.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				appendNumber(8);				
			}
		});
		numberPanel.add(button_7);
		
		JButton button_8 = new JButton("9");
		button_8.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				appendNumber(9);				
			}
		});
		numberPanel.add(button_8);
		
		JButton button_9 = new JButton(".");
		button_9.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				inputText.setText(inputText.getText() +".");				
			}
		});
		numberPanel.add(button_9);
		
		JButton button_10 = new JButton("0");
		button_10.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				appendNumber(0);				
			}
		});
		numberPanel.add(button_10);
		
		JButton button_11 = new JButton("C");
		button_11.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				inputText.setText("");	
				label.setText("");
			}
		});
		numberPanel.add(button_11);
		
		add(numberPanel, BorderLayout.CENTER);
		
		inputText = new JTextField();
		inputText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					evaluate();
				}
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					inputText.setText("");
					label.setText("");
				}
			}
		});
		
		add(inputText, BorderLayout.NORTH);
		
		JPanel operationsPanel = new JPanel();
		operationsPanel.setLayout(new GridLayout(5,2,5,5));
		
		JButton button_12 = new JButton("+");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputText.setText(inputText.getText() + " + ");
			}
		});
		operationsPanel.add(button_12);
		JButton button_13 = new JButton("-");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputText.setText(inputText.getText() + " - ");
			}
		});
		operationsPanel.add(button_13);
		JButton button_14 = new JButton("*");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputText.setText(inputText.getText() + " * ");
			}
		});
		operationsPanel.add(button_14);
		JButton button_15 = new JButton("/");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputText.setText(inputText.getText() + " / ");
			}
		});
		operationsPanel.add(button_15);
		JButton button_16 = new JButton("%");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputText.setText(inputText.getText() + " % ");
			}
		});
		operationsPanel.add(button_16);
		JButton button_17 = new JButton("^");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputText.setText(inputText.getText() + " ^ ");
			}
		});
		operationsPanel.add(button_17);
		JButton button_18 = new JButton("(");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputText.setText(inputText.getText() + " ( ");
			}
		});
		operationsPanel.add(button_18);
		JButton button_19 = new JButton(")");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputText.setText(inputText.getText() + " ) ");
			}
		});
		operationsPanel.add(button_19);
		JButton button_20 = new JButton("=");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				evaluate();
				
			}
		});
		operationsPanel.add(button_20);
		JButton button_21 = new JButton("Convert");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				try {
					String convertedExpression = _calculator.convert(inputText.getText());
					String s = String.format("%s = %s", inputText.getText(), convertedExpression);
					label.setText(s);
				} catch (ParserException e1) {

				}
			}
		});
		operationsPanel.add(button_21);
		add(operationsPanel, BorderLayout.EAST);
		
		
	}
	
	private void evaluate() {
		try{
			double result = _calculator.calculate(inputText.getText());
			inputText.setText(Double.toString(result));
		}
		catch(ParserException pe){
			
		}
	}
	
	private void appendNumber(int number){
		inputText.setText(inputText.getText() + number);
	}
	
	public void setCalculator(ICalculatorBehavior calculator){
		_calculator = calculator;
	}
}
