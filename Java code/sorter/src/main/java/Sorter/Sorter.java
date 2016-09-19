package Sorter;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Rene on 14-9-2016.
 */
public class Sorter extends UnicastRemoteObject implements ISorter {

    protected Sorter() throws RemoteException {
    }

    public Integer[] sortIntegers(Integer[] integers) throws IllegalArgumentException, RemoteException {
        if(integers == null || integers.length == 0)
        {
            throw new IllegalArgumentException("The list was empty");
        }

        List<Integer> list = new ArrayList<Integer>(Arrays.asList(integers));
        list.removeAll(Collections.singleton(null));
        Integer[] integerToBeSorted = list.toArray(new Integer[list.size()]);
        Arrays.sort(integerToBeSorted);

        return integerToBeSorted;
    }
}
