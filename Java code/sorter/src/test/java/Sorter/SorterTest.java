package Sorter;

import junit.framework.TestCase;

import java.util.ArrayList;

/**
 * Created by Rene on 14-9-2016.
 */
public class SorterTest extends TestCase {

    public void testEmptyList(){
        ISorter sorter = new Sorter();
        ArrayList<Integer> emptyList = new ArrayList<Integer>();

        try {
            sorter.sortIntegers(emptyList);
            fail("Expected exception: illegalArgumentException");
        }catch(IllegalArgumentException e){
            assertEquals("The list was empty", e.getMessage());
        }
    }

    public void testNullList(){
        ISorter sorter = new Sorter();
        ArrayList<Integer> nullList = null;

        try {
            sorter.sortIntegers(nullList);
            fail("Expected exception: illegalArgumentException");
        }catch(IllegalArgumentException e){
            assertEquals("The list was empty", e.getMessage());
        }
    }

    public void testAlreadySorted(){
        ISorter sorter = new Sorter();
        ArrayList<Integer> sortedIntegers = new ArrayList<Integer>();

        sortedIntegers.add(1);
        sortedIntegers.add(2);
        sortedIntegers.add(3);
        sortedIntegers.add(4);
        sortedIntegers.add(5);

        ArrayList<Integer> resortedIntegers = sorter.sortIntegers(sortedIntegers);

        assertEquals(sortedIntegers, resortedIntegers);
    }

}
