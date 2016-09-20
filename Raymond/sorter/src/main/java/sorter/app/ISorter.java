package sorter.app;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Ray on 19/09/16.
 */
public interface ISorter extends Remote {
     int[] sortInts(int[] data) throws RemoteException;
}
