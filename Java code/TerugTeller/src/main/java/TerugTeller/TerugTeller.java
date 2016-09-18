package TerugTeller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class TerugTeller extends UnicastRemoteObject implements ITerugTeller {

    private int value;
    private ArrayList<ICallback> callbackList;

    protected TerugTeller() throws RemoteException {
        callbackList = new ArrayList<ICallback>();
    }

    public void setValue(int value) throws RemoteException {
        this.value = value;
    }

    public int getValue() throws RemoteException {
        return value;
    }

    public void decrement() throws RemoteException {
        value--;
        if(value % 25 == 0) {
            for (ICallback callback: callbackList) {
                callback.notifyChange(value);
            }
        }
    }

    public void addCallbackListener(ICallback callback) throws RemoteException {
        callbackList.add(callback);
    }
}
