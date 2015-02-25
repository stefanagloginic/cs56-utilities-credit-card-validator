package edu.ucsb.cs56.projects.utilities.credit_card_validator;

import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
public class Menu extends JFrame{


	// Textfield where user can enter cardNumber
	private JTextField cardNumber;
	// User presses this button when ready to validate CC number
	private JButton validateCardNumber;

	// User presses this button to generate card numbers
	private JButton generateCardNumber;

	// Textfield where generated card number will show up
	private JTextField generatedNumber;
	// Constructor for Menu calls the initUI() method
	public Menu() {
		initUI();
	}


	class ValidateListener implements ActionListener {

		// Gotta change this to verify if the vard is validated or not
		public void actionPerformed (ActionEvent ae) {
			String temp2 = new String(cardNumber.getText());
			if (temp2.length() != 16)
				cardNumber.setText("Not a valid credit card number!");
			else if (CCValidator.isValid(temp2))
			    cardNumber.setText("This is a valid credit card number!");
			else
			    cardNumber.setText("This is an invalid credit card number!");
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
		String preText = generatedNumber.getText();
		while (preText.equals(generatedNumber.getText())) {
			String tempNumber = RandomCardGen.RandomCard();
			if (CCValidator.isValid(tempNumber)){
	   			generatedNumber.setText(tempNumber);
				//System.out.println("This is a: " + RandomCardGen.CardType + " Card");
				//cardMade += 1;
			}
		}
	}

	//private JPanel panel;


	// creates the text field and buttons and adds them to JFrame
	public void initUI() {
		cardNumber = new JTextField(12);
		validateCardNumber = new JButton("Validate");
		generateCardNumber = new JButton("Generate");
		generatedNumber = new JTextField(12);
		cardNumber.setText("Enter your credit card number here");
		generatedNumber.setText("Your generated card number will display here");
		this.setTitle("Credit Card Validator");
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(BorderLayout.NORTH,cardNumber);
		this.getContentPane().add(BorderLayout.EAST,validateCardNumber);
		this.getContentPane().add(BorderLayout.WEST,generateCardNumber);
		this.getContentPane().add(BorderLayout.SOUTH,generatedNumber);
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
