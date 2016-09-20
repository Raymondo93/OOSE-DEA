package nl.ica.oose;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.*;

/**
 * Created by Ray on 19/09/16.
 */
public class TerugTellerServer  {


    public static void main(String[] args) throws RemoteException {
        ITerugTeller teller = new TerugTeller();
        Registry register = LocateRegistry.createRegistry(1099);
        register.rebind("terugteller", teller);
    }
}
