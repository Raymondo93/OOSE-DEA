package nl.ica.oose;

import java.awt.peer.SystemTrayPeer;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Ray on 19/09/16.
 */
public class TerugTellerClient extends UnicastRemoteObject implements ICallBack {

    //ITerugTeller teller = new TerugTeller();

    public static void main(String[] args) throws RemoteException {
        TerugTellerClient t = new TerugTellerClient();
    }

    public TerugTellerClient() throws RemoteException {
        try{
            ITerugTeller tellers = (ITerugTeller) LocateRegistry.getRegistry().lookup("terugteller");
            tellers.setValue(200);
            tellers.addCallbackListener(this);
            for (int i = 0; i < 100; i++) {
                tellers.decrement();
            }
            System.out.println(tellers.getValue());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void notifyChange(int value) throws RemoteException {
        System.out.println("Dit is een veelvoud van 25 " + value);
    }
}
