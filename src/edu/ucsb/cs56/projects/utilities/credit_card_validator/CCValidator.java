package edu.ucsb.cs56.projects.utilities.credit_card_validator;
import java.util.Scanner;
/**
 *
 * @author jicheng & Christopher Langford
 */
public class CCValidator {
    
    /**
		string to hold credit card number
    */

	/**
		reversed cc number used in validation algorithm
	*/
	/**
	   a character array that holds the string of credit card number
	*/

	/** 
		tells whether credit card number is valid or not
	*/

   /* public CCValidator(String cardNumber) {
    	this.cardNumber = new String(cardNumber);
    	this.reversedNumber = new StringBuilder(this.cardNumber).reverse().toString();
    	this.reversedDigitArray = this.reversedNumber.toCharArray();
    }*/

    /**
       checks if the credit card number is valid.
       returns a string of "approved" or "denied"
       as the result of checking the credit card number
       @param string of credit card number
    */
    public static boolean isValid(String cardNumber) {
    	String reversedNumber = new StringBuilder(cardNumber).reverse().toString();
    	char [] reversedDigitArray = reversedNumber.toCharArray();
	/**
	   temerialy holds a single digit from the character array
	*/
        char tempDigitHolder;
	/**
	   holds the single digit of the credit card number as an integer
	*/
        int singleDigit;
	/**
	   the sum after adding up all values in the algorathism
	*/
        int sum = 0;
	

	// Luhn algorithm for checking a valid credit card

    // First find the sum according to the algorithm

		for (int x = 0; x < 16; x++){ // Starting from the 1st digit, we double every other number
								  // Then sum each of the digits in the modified digit list
			if (x%2 == 1) {
				tempDigitHolder = (char)(int) reversedDigitArray[x];
				singleDigit = Character.getNumericValue(tempDigitHolder);
				singleDigit = singleDigit * 2; // double every other digit starting from first digit

				if (singleDigit > 9) {
			    	singleDigit = singleDigit%10 + 1; // 10 = 1 + 0 so take %10 and add 1
			    	sum += singleDigit;
				}
				else {
			    	sum += singleDigit;
				}
			}

		    else {
				tempDigitHolder = (char)(int) reversedDigitArray[x];
				singleDigit = Character.getNumericValue(tempDigitHolder);
	        	sum += singleDigit; // if we are looking at o
		    }

		}

	// if sum is a multiple of 10 and is not equal to 0, then cc number is valid
		if(sum%10 == 0 && sum != 0) {
		    return true;
		}
		// else not a valid number
		else {
		    return false;
		}
	
	}
    
}
