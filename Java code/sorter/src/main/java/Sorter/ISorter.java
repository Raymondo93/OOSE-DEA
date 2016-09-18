package Sorter;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rene on 14-9-2016.
 */
public interface ISorter extends Remote{

    ArrayList<Integer> sortIntegers(ArrayList<Integer> integers) throws IllegalArgumentException, RemoteException;
}
