package sorter.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

import java.rmi.RemoteException;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase {

    public void testSorterNormal() {
        int[] data = {2, 4, 5, 1, 6, 3};
        int[] answer = {1, 2, 3, 4, 5, 6};
        Sort s = null;
        try {
            s = new Sort();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        s.sortInts(data);

        for (int i = 0; i < data.length; i++) {
            assertEquals(answer[i], data[i]);
        }
    }

    public void testSorterWhenAlreadySorted() {
        int[] data = {1, 2, 3, 4, 5};
        int[] answer = {1, 2, 3, 4, 5};
        Sort s = null;
        try {
            s = new Sort();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        s.sortInts(data);

        for (int i = 0; i < data.length; i++){
            assertEquals(answer[i], data[i]);
        }
    }

    public void testSorterWhenArrayIsEmpty() {
        int[] data = {};
        Sort s = null;
        try {
            s = new Sort();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            s.sortInts(data);
            fail("Expected to fail the test");
        } catch (IllegalArgumentException e) {
            assertEquals("Array is empty", e.getMessage());
        }
    }


    //Deze functie doet het niet, nullpointer exception
    public void testSorterWhenNull() {
        int[] data = null;
        Sort s = null;
        try {
            s = new Sort();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        try {
            s.sortInts(data);
            fail("Array is null");
        } catch (IllegalArgumentException e) {
            assertEquals("Array is null", e.getMessage());
        }
    }


    public static void testSorterNegativeNumbers() {
        int[] data = {-2, -4, -3, -1, 0};
        int[] answers = {-4, -3, -2, -1, 0};
        Sort s = null;
        try {
            s = new Sort();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        s.sortInts(data);
        for (int i = 0; i < data.length; i++) {
            assertEquals(answers[i], data[i]);
        }
    }

/*    public static void testGenerateRandomNumbers() {
        SortClient s = new SortClient();
        s.generateRandomIntegers(5);
    }*/

}

