package nl.ica.oose;
import java.rmi.*;

/**
 * Created by Ray on 17/09/16.
 */
public interface ITerugTeller extends Remote {

    void setValue(int value) throws RemoteException;

    int getValue() throws RemoteException;

    void decrement() throws  RemoteException;

    void addCallbackListener(ICallBack callBack) throws RemoteException;

}
