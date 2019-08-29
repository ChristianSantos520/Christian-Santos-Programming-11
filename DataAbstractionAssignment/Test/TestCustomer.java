import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestCustomer {
    private Date date;

    @Before
    public void setup() {
        date = new Date();
    }

    @Test
    public void testDeposit() {
        System.out.println("testDeposit **********************************************");
        Customer testCustomer = new Customer("Christian", 1, 0.0, 0.0);

        // First time deposit in CHECKING.  Check balance is same as deposited amount.
        double amt = 100.0;
        double balance = testCustomer.deposit(amt, date, Customer.CHECKING);
        assertEquals(amt, balance);
        //tests if checkingBalance is not equals to 0.0
        assertFalse(0.0 == testCustomer.deposit(0.0, date, Customer.CHECKING));

        // First time deposit in SAVINGS.  Check balance is same as deposited amount.
        amt = 100.0;
        balance = testCustomer.deposit(amt, date, Customer.SAVING);
        assertEquals(amt, balance);
        //tests if savingBalance is not equals to 0.0
        assertFalse(0.0 == testCustomer.deposit(0.0, date, Customer.SAVING));

        Customer testCustomer2 = new Customer("Christian", 1, 100.0, 0.0);
        Date date2 = new Date();

        //tests if there will be an error if amt less than or equals to 0
        assertEquals(-1.0, testCustomer2.deposit(-1.0, date2, Customer.CHECKING));

        //tests if there will be an error if account is nether CHECKING or SAVING
        assertEquals(-1.0, testCustomer2.deposit(1.0, date2, "ERROR"));
    }

    @Test
    public void testWithdraw() {
        System.out.println("testWithdraw **********************************************");

        Customer testCustomer = new Customer("Christian", 1, 0.0, 0.0);

        //tests if amt is lower than 0 and not above checkBalance which will make withdraw return -1 determining that
        //this is an error
        assertEquals(-1.0, testCustomer.withdraw(-1, date, Customer.SAVING));

        //tests if overdraft is true by the withdraw method returning -1
        assertEquals(-1.0, testCustomer.withdraw(1000.0, date, Customer.CHECKING));

        //test if withdraw will return -1 if account is neither CHECKING or SAVING
        assertEquals(-1.0, testCustomer.withdraw(1.0, date, "ERROR"));

        testCustomer = new Customer("Christian", 1, 100, 100);

        //tests if checkBalance is 50 if withdraw method is called and if the account is CHECKING
        assertEquals(50.0, testCustomer.withdraw(50.0, date, Customer.CHECKING));

        //tests if savingBalance is 50 if withdraw method is called and if the account is SAVING
        assertEquals(50.0, testCustomer.withdraw(50.0, date, Customer.SAVING));
    }

    @Test
    public void displayTests(){
        //tests if displayDeposits() and displayWithdraws() print the right things
        Customer testCustomer = new Customer("Christian", 1, 0.0, 0.0);
        testCustomer.deposit(10.0, new Date(), Customer.SAVING);
        testCustomer.withdraw(5.0, new Date(), Customer.SAVING);

        testCustomer.deposit(13.0, new Date(), Customer.SAVING);
        testCustomer.withdraw(6.5, new Date(), Customer.SAVING);

        testCustomer.deposit(24.0, new Date(), Customer.CHECKING);
        testCustomer.withdraw(12.0, new Date(), Customer.CHECKING);

        testCustomer.deposit(16.5, new Date(), Customer.SAVING);
        testCustomer.withdraw(7.0, new Date(), Customer.SAVING);

        testCustomer.deposit(10.0, new Date(), Customer.SAVING);
        testCustomer.withdraw(1.0, new Date(), Customer.SAVING);

        testCustomer.displayDeposits();
        testCustomer.displayWithdraws();
    }
}
