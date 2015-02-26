package edu.ucsb.cs56.projects.utilities.credit_card_validator;

import java.util.Scanner;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;


public class Menu extends JFrame{


	// Textfield where user can enter cardNumberField
	private JTextField cardNumberField;
	
	// User presses this button when ready to validate CC number
	private JButton validateButton;

	// User presses this button to generate card numbers
	private JButton generateButton;

	//Simple Label to explain to user what radio buttons do 
	private JLabel cardTypeLabel;

	//Radio buttons for the different card types we can make
	private JComboBox cardTypeComboBox = new JComboBox();
	//JRadioButton visaRadioButton = new JRadioButton("Visa");
    //JRadioButton masterCardRadioButton = new JRadioButton("MasterCard");
    //JRadioButton amexRadioButton = new JRadioButton("Amex");
    //JRadioButton discoverRadioButton = new JRadioButton("Discover");

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


	class ComboBoxListener implements ActionListener {
		public void actionPerformed (ActionEvent ae) {
			
		}
	}

	// TODO: add action listeners for RadioButtones and part in validate to check a box based on card type


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
		validateButton = new JButton("Validate");
		generateButton = new JButton("Generate");

        cardTypeLabel = new JLabel("Card Type:");
		cardNumberField.setText("Enter your credit card number here");
		cardTypeComboBox = new JComboBox();
		
		
		this.setTitle("Credit Card Validator");
		this.setSize(600,100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		String[] description = { "Visa", "MasterCard","Amex","Discover"};
		for (int i = 0; i < 4; i++){cardTypeComboBox.addItem(description[i]);}
      	
 
        //create new grouplayout and set contentpane to this layout
        GroupLayout layout = new GroupLayout(this.getContentPane());
    	this.getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
 
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(cardNumberField)
            	.addGroup(layout.createParallelGroup()
                    .addComponent(cardTypeLabel)
                    .addComponent(cardTypeComboBox)))
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(validateButton)
                .addComponent(generateButton))
        );
        
        layout.linkSize(SwingConstants.HORIZONTAL, validateButton, generateButton);
 
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(BASELINE)
                .addComponent(cardNumberField)
                .addComponent(validateButton))
            .addGroup(layout.createParallelGroup(LEADING)
            	.addComponent(cardTypeLabel)
                .addComponent(generateButton))
        	.addComponent(cardTypeComboBox));

        pack();
     	this.setVisible(true);

		validateButton.addActionListener(new ValidateListener());
		generateButton.addActionListener(new GenerateListener());
		cardTypeComboBox.addActionListener(new ComboBoxListener());
		
		
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
