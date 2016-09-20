package nl.ica.oose;

import java.rmi.*;

/**
 * Created by Ray on 19/09/16.
 */
public interface ICallBack extends Remote {
    void notifyChange(int value) throws RemoteException;
}
