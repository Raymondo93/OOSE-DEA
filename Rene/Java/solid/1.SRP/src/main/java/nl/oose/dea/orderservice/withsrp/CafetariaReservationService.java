package nl.oose.dea.orderservice.withsrp;

/**
 * Created by Rene on 26-9-2016.
 */
public class CafetariaReservationService implements ReservationService {
    @SuppressWarnings("Duplicates")
    @Override
    public void reserveInventory(Cart cartWithSufficientInventory) {
        for(Item item : cartWithSufficientInventory.getItems())
        {
            try {
                InventorySystem inventorySystem = new InventorySystem();
                inventorySystem.reserve(item.sku, item.quantity);
            } catch(InsufficientInventoryException insufficientInventoryException)
            {
                throw new OrderException("Insufficient inventory for item " + item.sku, insufficientInventoryException);
            }
        }
    }

    @Override
    public boolean isOnStock(String sku, int amount) {
        InventorySystem inventorySystem = new InventorySystem();

        return inventorySystem.isOnStock(sku, amount);
    }
}
