package Sorter;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by renet on 9/18/2016.
 */
public class SortClient {

    public static void main(String[] args){


        SortClient client = new SortClient();
        client.sort();

    }

    public void sort(){
        int[] randomInts = {44, 32, 445,677,554,444,33,1,2,35,1,2,3,66,43,4,66,43,2,45,78,76};

        ArrayList<Integer> intList = new ArrayList<Integer>();

        for (int i = 0; i < randomInts.length; i++)
        {
            intList.add(randomInts[i]);
        }

        try {
            ISorter sorter = (ISorter) LocateRegistry.getRegistry().lookup("sorter1");
            System.out.println(sorter.sortIntegers(intList));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }


}
