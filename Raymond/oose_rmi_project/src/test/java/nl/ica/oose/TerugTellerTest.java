package nl.ica.oose;
import junit.framework.TestCase;

/**
 * Created by Ray on 19/09/16.
 */
public class TerugTellerTest extends TestCase {
    private TerugTeller test;

    public void setUp() throws Exception {
        test = new TerugTeller();
    }

    public void testGetValue() {
        try {
            test.setValue(10);
            assertEquals(test.getValue(), 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testDecrement() {
        try {
            test.setValue(10);
            test.decrement();
            assertEquals(test.getValue(), 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
