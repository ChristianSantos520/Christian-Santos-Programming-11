import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class TestDeposit {
    private Deposit testDeposit;
    private Date currentDate;

    @Before
    public void setup(){
        currentDate = new Date();
        testDeposit = new Deposit(100.0, currentDate, Customer.SAVING);
    }

    @Test
    public void testDeposit(){
        //test if the toString() is the same as the expected result
        String testAnswer = testDeposit.toString();
        assertEquals(testAnswer, "Deposit 0f: $100.00 Date: " + currentDate + "into account Saving");
    }
}
