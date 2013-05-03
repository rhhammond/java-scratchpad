package com.rob.calculator.ui;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;

import com.rob.calculator.InfixCalculator;
import com.rob.calculator.ReversePolishCalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorWindow {

	private JFrame frmCalculator;
	private ReversePolishCalculator reversePolish;
	private InfixCalculator inFix;
	private CalculatorButtonsPanel panel;
	private JRadioButtonMenuItem reversePolishRadio;
	private JRadioButtonMenuItem inFixRadio;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorWindow window = new CalculatorWindow();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorWindow() {
		reversePolish = new ReversePolishCalculator();
		inFix = new InfixCalculator(reversePolish);
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 450, 300);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new CalculatorButtonsPanel(reversePolish);
		frmCalculator.setContentPane(panel);
		
		JMenuBar menuBar = new JMenuBar();
		frmCalculator.setJMenuBar(menuBar);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		reversePolishRadio = new JRadioButtonMenuItem("Reverse Polish", true);
		reversePolishRadio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setCalculator(reversePolish);				
			}
		});
		mnSettings.add(reversePolishRadio);
		
		inFixRadio = new JRadioButtonMenuItem("Infix");
		inFixRadio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setCalculator(inFix);
				
			}
		});
		mnSettings.add(inFixRadio);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(reversePolishRadio);
		bg.add(inFixRadio);	
	}

}
