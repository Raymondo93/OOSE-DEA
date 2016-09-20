package sorter.app;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;

/**
 * Created by Ray on 19/09/16.
 */
public class SortServer {
    public static void main(String[] args) throws RemoteException {
        ISorter s1 = new Sort();
        ISorter s2 = new Sort();


        Registry register = LocateRegistry.createRegistry(1099);
        register.rebind("sorter1", s1);
        register.rebind("sorter2", s2);
    }
}
