import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class IntegerSetTests {
    IntegerSet testSet;

    @Before
    public void setup() {
        testSet = new IntegerSet();
    }

    @Test
    public void testInsertAlreadyThere(){
        int value = 3;
        assertTrue(testSet.size()==0); // Make sure set is empty.
        testSet.insert(value); // Insert the value for the first time.
        assertTrue(testSet.size()==1); // Make sure size is now 1.
        assertTrue(testSet.contains(value)); // Expect to find the value.
        testSet.insert(value); //Insert value for the second time
        assertTrue(testSet.size() == 1); // Checks to make sure the size of the set is still 1
        assertTrue(testSet.contains(value)); // Expect to find the value, still.
    }
}
