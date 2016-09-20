package nl.ica.oose;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;

/**
 * Created by Ray on 17/09/16.
 */
public class TerugTeller extends UnicastRemoteObject implements ITerugTeller {

    private int value;
    private ArrayList<ICallBack> callbacks = new ArrayList<ICallBack>();

    public TerugTeller() throws RemoteException {

    }

    public synchronized void setValue(int newValue) throws RemoteException {
        value = newValue;
    }

    public int getValue() throws RemoteException{
        return value;
    }

    public synchronized void decrement() throws RemoteException{
        value--;
        if (value % 25 == 0) {
            for (ICallBack Icallback: callbacks) {
                Icallback.notifyChange(value);
            }
        }
    }

    public void addCallbackListener(ICallBack list) throws RemoteException {
        callbacks.add(list);
    }
}
