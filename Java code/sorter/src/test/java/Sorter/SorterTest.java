package Sorter;

import junit.framework.TestCase;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by Rene on 14-9-2016.
 */
public class SorterTest extends TestCase {

    public void testEmptyList(){


        try {
            ISorter sorter = new Sorter();
            ArrayList<Integer> emptyList = new ArrayList<Integer>();
            sorter.sortIntegers(emptyList);
            fail("Expected exception: illegalArgumentException");
        }catch(IllegalArgumentException e){
            assertEquals("The list was empty", e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void testNullList(){


        try {
            ISorter sorter = new Sorter();
            ArrayList<Integer> nullList = null;
            sorter.sortIntegers(nullList);
            fail("Expected exception: illegalArgumentException");
        }catch(IllegalArgumentException e){
            assertEquals("The list was empty", e.getMessage());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void testAlreadySorted(){

        try {
            ISorter sorter = new Sorter();
            ArrayList<Integer> sortedIntegers = new ArrayList<Integer>();

            sortedIntegers.add(1);
            sortedIntegers.add(2);
            sortedIntegers.add(3);
            sortedIntegers.add(4);
            sortedIntegers.add(5);

            ArrayList<Integer> resortedIntegers = null;
            resortedIntegers = sorter.sortIntegers(sortedIntegers);
            assertEquals(sortedIntegers, resortedIntegers);
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }

}
