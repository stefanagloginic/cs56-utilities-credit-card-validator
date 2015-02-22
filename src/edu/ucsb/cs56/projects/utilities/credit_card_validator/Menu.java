package edu.ucsb.cs56.projects.utilities.credit_card_validator;

import java.util.Scanner;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
public class Menu extends JFrame{

	class ValidateListener implements ActionListener {

		// Gotta change this to verify if the vard is validated or not
		public void actionPerformed (ActionEvent ae) {
			cardNumber.setText("Clicked Validate");
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
			String checkResult = CCValidator.CheckCard(tempNumber);
			if (checkResult == "approved"){
	   			generatedNumber.setText(tempNumber);
				//System.out.println("This is a: " + RandomCardGen.CardType + " Card");
				//cardMade += 1;
			}
		}
	}

	//private JPanel panel;

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
        String CCnumber = null;	

		System.out.println("Welcome to the Credit Card Validator");
		System.out.println("(A) Generate random cards");
		System.out.println("(B) Check if your card is valid");
		boolean running = true;
	// checks user input of which choice
		while (running){
		    System.out.println("Please pick a menu option from the above:");
		    Scanner s = new Scanner(System.in); 
		    String UserInput;
		    UserInput = s.nextLine(); //Changed this from nextLine() to next()
	// creating a random credit card number until it's valid

		    if(UserInput.equals("A") | UserInput.equals("a")) {
				running = false;
				System.out.println("How many random card number you want to create?");
				UserInput = s.nextLine();
				int request = Integer.parseInt(UserInput);
				s.close();
				int cardMade = 0;
			    while(cardMade < request){
					String tempNumber = RandomCardGen.RandomCard();
					String checkResult = CCValidator.CheckCard(tempNumber);
					if (checkResult == "approved"){
				   		System.out.println(tempNumber);
			    		System.out.println("This is a: " + RandomCardGen.CardType + " Card");
			    		cardMade += 1;
					}
			    } // The card numbers that this generates turn out to be invalid when you check them
		    }
		    
	// to check if a credit card is valid
		    if(UserInput.equals("B") | UserInput.equals("b")){
				running = false;
				boolean intaking = true;
				System.out.println("Please Enter Your Card Number:  ");
				String temp2 = null;
				temp2 = s.nextLine();
				while (intaking){
			    	temp2 = temp2.replace(" ", "");
			    	temp2 = temp2.replace("-", "");
			    	if (temp2.length() == 16){
						CCnumber = temp2;
						intaking = false;
						s.close();
			    	}
			    
			    	else{
						System.out.println("Please Enter the Correct Number!");
						temp2 = s.nextLine();
			    	}
				} 
				String result = null;
				result = CCValidator.CheckCard(CCnumber);
				if (result == "approved")
			    	System.out.println("This is a valid card!");
				if (result == "denied")
			    	System.out.println("This is an invalid card!");
			
		    }
		}	
	}
}
