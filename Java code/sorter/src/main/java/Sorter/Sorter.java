package Sorter;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rene on 14-9-2016.
 */
public class Sorter extends UnicastRemoteObject implements ISorter {

    protected Sorter() throws RemoteException {
    }

    public ArrayList<Integer> sortIntegers(ArrayList<Integer> integers) throws IllegalArgumentException, RemoteException {
        if(integers == null || integers.size() == 0)
        {
            throw new IllegalArgumentException("The list was empty");
        }

        Integer[] IntegerToBeSorted = integers.toArray(new Integer[integers.size()]);
        Arrays.sort(IntegerToBeSorted);

        ArrayList<Integer> sortedIntegers = new ArrayList<Integer>(Arrays.asList(IntegerToBeSorted));

        return sortedIntegers;
    }
}
