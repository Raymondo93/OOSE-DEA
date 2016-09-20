package sorter.app;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;


/**
 * Created by Ray on 19/09/16.
 */
public class Sort extends UnicastRemoteObject implements ISorter {

    protected Sort() throws RemoteException {
    }

    public synchronized int[] sortInts(int[] data) throws IllegalArgumentException {

        if (data.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        } else {
            Arrays.sort(data);
            return data;
        }
    }
}

