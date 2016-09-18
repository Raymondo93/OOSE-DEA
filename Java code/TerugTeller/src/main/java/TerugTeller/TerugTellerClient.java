package TerugTeller;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class TerugTellerClient extends UnicastRemoteObject implements ICallback{

    public TerugTellerClient() throws RemoteException{
        ITerugTeller teller = null;
        try {
            teller = (ITerugTeller) LocateRegistry.getRegistry().lookup("terugteller");
            teller.addCallbackListener(this);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

        teller.setValue(200);

        for(int i = 0; i < 100; i++){
            teller.decrement();
        }
    }

    public static void main(String[] args){
        try {
            TerugTellerClient client = new TerugTellerClient();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void notifyChange(int value) throws RemoteException {
        System.out.println(value);
    }
}
