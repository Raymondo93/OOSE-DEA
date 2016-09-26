package nl.oose.dea.orderservice.withsrp;

/**
 * Created by Rene on 26-9-2016.
 */
public class OnlineOrder extends Order implements NotificationService, ReservationService, PaymentProcessor{
    public OnlineOrder(Cart cart, PaymentDetails paymentDetails) {
        super(cart, paymentDetails);
    }

    @Override
    public void reserveInventory(Cart cartWithSufficientInventory) {

    }

    @Override
    public boolean isOnStock(String sku, int i) {
        return false;
    }

    @Override
    public void notifyCustomer(Cart cart) {

    }

    @Override
    public boolean chargeCard(PaymentDetails paymentDetails, Cart cart) {
        return false;
    }

    @Override
    public void checkout() throws OrderException{

        try {
            throw new Exception("fdfdsf");
        } catch (Exception e) {
            throw new OrderException("fdsfsdf", e);
        }
    }
}
