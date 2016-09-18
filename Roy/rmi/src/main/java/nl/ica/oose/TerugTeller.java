package nl.ica.oose;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by royho on 17-9-2016.
 */
public class TerugTeller extends UnicastRemoteObject implements ITerugTeller {
    private int value;
    private List<ICallback> callbacks = new ArrayList<ICallback>();

    public TerugTeller() throws RemoteException {

    }

    public void setValue(int value) throws RemoteException {
        this.value = value;
    }

    public int getValue() throws RemoteException {
        return value;
    }

    public void decrement() throws RemoteException {
        value--;
        if(value %25 == 0)
        {
            for(ICallback iCallback:callbacks)
            {
                iCallback.notifyChange(value);
            }
        }
    }


    public void addCallbackListener(ICallback callback) throws RemoteException {
        callbacks.add(callback);
    }
}
