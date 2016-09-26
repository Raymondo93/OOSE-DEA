package nl.oose.dea.orderservice.withsrp;

/**
 * Created by Rene on 26-9-2016.
 */
public interface ReservationService {
    void reserveInventory(Cart cartWithSufficientInventory);

    boolean isOnStock(String sku, int amount);
}
