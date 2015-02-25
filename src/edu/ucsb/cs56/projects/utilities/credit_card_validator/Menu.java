package edu.ucsb.cs56.projects.utilities.credit_card_validator;

import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
public class Menu extends JFrame{


	// Textfield where user can enter cardNumberField
	private JTextField cardNumberField;
	// User presses this button when ready to validate CC number
	private JButton validateCardNumber;

	// User presses this button to generate card numbers
	private JButton generateCardNumber;

	private JLabel cardTypeLabel;

	// Constructor for Menu calls the initUI() method
	public Menu() {
		initUI();
	}


	class ValidateListener implements ActionListener {

		// Gotta change this to verify if the vard is validated or not
		public void actionPerformed (ActionEvent ae) {
			String temp2 = new String(cardNumberField.getText());
			if (temp2.length() != 16)
				cardNumberField.setText("Not a valid credit card number!");
			else if (CCValidator.isValid(temp2))
			    cardNumberField.setText("This is a valid credit card number!");
			else
			    cardNumberField.setText("This is an invalid credit card number!");
		}
	}

	// Works
	class GenerateListener implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			generateCard();
		}
	}

	// generates a card number and enters it in the bottom text field
	public void generateCard() {
		String preText = cardNumberField.getText();
		while (preText.equals(cardNumberField.getText())) {
			String tempNumber = RandomCardGen.RandomCard();
			if (CCValidator.isValid(tempNumber)){
	   			cardNumberField.setText(tempNumber);
				//System.out.println("This is a: " + RandomCardGen.CardType + " Card");
				//cardMade += 1;
			}
		}
	}

	//private JPanel panel;


	// creates the text field and buttons and adds them to JFrame
	public void initUI() {
		cardNumberField = new JTextField(12);
		validateCardNumber = new JButton("Validate");
		generateCardNumber = new JButton("Generate");
		cardNumberField = new JTextField(12);
		cardNumberField.setText("Enter your credit card number here");
		cardTypeLabel = new JLabel("Card Type:");
		this.setTitle("Credit Card Validator");
		this.setSize(600,100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GroupLayout layout = new GroupLayout(this.getContentPane());
    	this.getContentPane().setLayout(layout);

    	layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		    .addGroup(layout.createSequentialGroup()
		    	.addComponent(generateCardNumber, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		        .addComponent(validateCardNumber, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		    .addComponent(cardTypeLabel, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		    .addComponent(cardNumberField, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		layout.setVerticalGroup(layout.createSequentialGroup()
		    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		        .addComponent(generateCardNumber).addComponent(validateCardNumber))
		    .addComponent(cardTypeLabel)
		    .addComponent(cardNumberField));
		this.setVisible(true);
		validateCardNumber.addActionListener(new ValidateListener());
		generateCardNumber.addActionListener(new GenerateListener());
		this.repaint();
		
	}

	// GUI is refreshed when a button is clicked
	public void actionPerformed(ActionEvent ae) {
		this.repaint();
	}

	// This is what gets shown on the screen
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawString("clicked",50,50);
	}


/**
	the main function
	which is a menu let user to choose from
*/	

	// This is the logic of the menu
    public static void main(String args[]) {
        Menu gui = new Menu();
	}
}
