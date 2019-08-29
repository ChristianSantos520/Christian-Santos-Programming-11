import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class TestWithdraw {
    private Withdraw testWithdraw;
    private Date currentDate;

    @Before
    public void setup(){
        currentDate = new Date();
        testWithdraw = new Withdraw(100.0, currentDate, Customer.CHECKING);
    }

    @Test
    public void testWithdraw(){
        //tests if the toString() is the same as the expected result
        String testAnswer = testWithdraw.toString();
        assertEquals(testAnswer, "Withdrawal of: $100.00 Date: " + currentDate + " into account: Checking");
    }
}
