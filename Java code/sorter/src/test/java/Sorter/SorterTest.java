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
            Integer[] emptyList = {};
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
            Integer[] nullList = null;
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
            Integer[] sortedIntegers = {1,2,3,4,5};

            Integer[] resortedIntegers = null;
            resortedIntegers = sorter.sortIntegers(sortedIntegers);
            assertEquals(sortedIntegers, resortedIntegers);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
