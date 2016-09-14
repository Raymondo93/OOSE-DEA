package Sorter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rene on 14-9-2016.
 */
public class Sorter implements ISorter {

    public ArrayList<Integer> sortIntegers(ArrayList<Integer> integers) throws IllegalArgumentException {
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
