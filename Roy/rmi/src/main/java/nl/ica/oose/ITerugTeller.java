package nl.ica.oose;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by royho on 17-9-2016.
 */
public interface ITerugTeller extends Remote {
    void setValue(int value) throws RemoteException;

    int getValue() throws RemoteException;

    void decrement() throws RemoteException;

    void addCallbackListener(ICallback callback) throws RemoteException;
}
