package nl.ica.oose;

import junit.framework.TestCase;


/**
 * Created by royho on 18-9-2016.
 */
public class TerugTellerTest extends TestCase {
    TerugTeller terugTeller;

    public void setUp() throws Exception {
        terugTeller = new TerugTeller();
    }

    public void testGetValue() {
        try {
            terugTeller.setValue(10);
            assertEquals(terugTeller.getValue(), 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void testDecrement() {
        try {
            terugTeller.setValue(10);
            terugTeller.decrement();
            assertEquals(terugTeller.getValue(), 9);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
