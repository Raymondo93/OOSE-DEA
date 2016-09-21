package Sorter;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SortServer {

    public static void main(String[] args){

        try {
            ISorter sorter1 = new Sorter();
            ISorter sorter2 = new Sorter();
            Registry r = LocateRegistry.createRegistry(1099);
            r.bind("sorter1", sorter1);
            r.bind("sorter2", sorter2);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
