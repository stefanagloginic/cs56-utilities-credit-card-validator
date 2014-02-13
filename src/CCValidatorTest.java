import org.junit.Test;
import static org.junit.Assert.assertEquals;

/** test class for CCValidator
@author Jicheng Huang @ Christopher Langford
@version Mantis Ticket for CS56, Spring 2011
@see CCValidator
*/



public class CCValidatorTest {
    /**
       tests if the outcome of RandomCardGen is valid
    */
    @Test public void testRandomCardGen() {
	String result = null;
	
	String testCard = RandomCardGen.RandomCard();
	result = CCValidator.CheckCard(testCard);
	assertEquals("approved", result);
    }
    
    /**
       test CheckCard Method in CCValidator class
     */
    @Test public void testCheckCard() {
	String result = null;

	String testCard2 = "5000000000000000";
	result = CCValidator.CheckCard(testCard2);
	assertEquals("denied", result);

	String testCard3 = "4200000000000000";
	result = CCValidator.CheckCard(testCard3);
	assertEquals("approved", result);
    }

    /**
       test CheckCard Method with card number contain spaces and "-"
     */
    @Test public void testCardWithSpace(){
	String result = null;

	String testCard4 = "5000 0000 0000 0000";
	result = CCValidator.CheckCard(testCard4);
	assertEquals("denied", result);

	String testCard5 = "4200 0000 0000 0000";
	result = CCValidator.CheckCard(testCard5);	
	assertEquals("approved", result);

	String testCard6 = "5000-0000-0000-0000";
	result = CCValidator.CheckCard(testCard6);
	assertEquals("denied", result);

	String testCard7 = "4200-0000-0000-0000";
	result = CCValidator.CheckCard(testCard7);
	assertEquals("approved", result);
    }
}
