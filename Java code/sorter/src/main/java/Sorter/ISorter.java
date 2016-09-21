package Sorter;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISorter extends Remote{

    Integer[] sortIntegers(Integer[] integers) throws IllegalArgumentException, RemoteException;
}
