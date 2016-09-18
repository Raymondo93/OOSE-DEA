package TerugTeller;


import org.junit.Before;
import org.junit.Test;

import java.rmi.RemoteException;

import static org.junit.Assert.assertEquals;

public class TerugTellerTest {

    private TerugTeller teller;

    @Before
    public void setUp() throws Exception{
        teller = new TerugTeller();
    }

    @Test
    public void testGetValue(){
        try {
            teller.setValue(10);
            assertEquals(teller.getValue(), 10);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDecrement(){
        try {
            teller.setValue(10);
            teller.decrement();
            assertEquals(teller.getValue(),9);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
