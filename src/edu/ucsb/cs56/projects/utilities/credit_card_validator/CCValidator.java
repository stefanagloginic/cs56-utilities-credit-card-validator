package edu.ucsb.cs56.projects.utilities.credit_card_validator;
import java.util.Scanner;
/**
 *
 * @author jicheng & Christopher Langford
 */
public class CCValidator {
    
    /**
       checks if the credit card number is valid.
       returns a string of "approved" or "denied"
       as the result of checking the credit card number
       @param cardNumber a string of numbers representing credit card number
    */
    public static String CheckCard(String cardNumber) {
	/**
	   holds the user input number in a string 
	*/
        String CCnumber = null;
	/**
	   a character array that holds the string of credit card number
	*/
        char[] CCnumberArray;
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
	
	//algorathism of checking a valid credit card
	CCnumber = cardNumber;
	CCnumberArray = CCnumber.toCharArray();
	for (int x = 0; x < 16; x++){
	    if (x%2 == 0){
		tempDigitHolder = (char)(int) CCnumberArray[x];
		singleDigit = Character.getNumericValue(tempDigitHolder);
		singleDigit = singleDigit * 2;
		if (singleDigit > 9){
		    singleDigit = singleDigit%10 + (singleDigit - singleDigit%10)/10;
		    sum += singleDigit;
		}
		else
		    sum += singleDigit;
	    }
	    else{
		tempDigitHolder = (char)(int) CCnumberArray[x];
		singleDigit = Character.getNumericValue(tempDigitHolder);
                    sum += singleDigit;
	    }
	}  
        
//checks if the first number is 0
	tempDigitHolder = (char)(int) CCnumberArray[0];
	singleDigit = Character.getNumericValue(tempDigitHolder);

//returns final result
	if(sum%10 == 0 & singleDigit != 0){
	    return "approved";
	}
	else{
	    return "denied";
	}
	
        
        
    }
    
}
