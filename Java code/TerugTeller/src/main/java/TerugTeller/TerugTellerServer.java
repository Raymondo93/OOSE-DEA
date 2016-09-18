package TerugTeller;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TerugTellerServer {

    public static void main(String[] args){
        ITerugTeller teller;
        try{
            teller = new TerugTeller();
            Registry r = LocateRegistry.createRegistry(1099);
            r.bind("terugteller", teller);
        } catch (AccessException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
