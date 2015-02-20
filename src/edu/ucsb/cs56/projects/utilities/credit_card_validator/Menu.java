package edu.ucsb.cs56.projects.utilities.credit_card_validator;

import java.util.Scanner;

public class Menu{
/**
	the main function
	which is a menu let user to choose from
*/	
    public static void main(String args[]) {
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
		    System.out.println("Here?");
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
