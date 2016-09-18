package TerugTeller;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITerugTeller extends Remote {

    public void setValue(int value) throws RemoteException;

    public int getValue() throws RemoteException;

    public void decrement() throws RemoteException;

    public void addCallbackListener(ICallback callback) throws RemoteException;
}
