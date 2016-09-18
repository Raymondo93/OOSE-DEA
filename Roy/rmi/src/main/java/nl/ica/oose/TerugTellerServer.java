package nl.ica.oose;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by royho on 17-9-2016.
 */
public class TerugTellerServer {
    public static void main(String[] args) {
        TerugTeller teller;

        try {
            teller = new TerugTeller();
            Registry r = LocateRegistry.createRegistry(1099);
            r.bind("terugteller", teller);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
