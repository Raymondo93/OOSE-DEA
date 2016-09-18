package nl.ica.oose;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by royho on 18-9-2016.
 */
public interface ICallback extends Remote {
    void notifyChange(int value) throws RemoteException;
}
