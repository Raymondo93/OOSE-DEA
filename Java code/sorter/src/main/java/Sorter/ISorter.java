package Sorter;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by Rene on 14-9-2016.
 */
public interface ISorter extends Remote{

    Integer[] sortIntegers(Integer[] integers) throws IllegalArgumentException, RemoteException;
}
