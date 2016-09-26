package nl.oose.dea.orderservice.withsrp;

/**
 * Created by Rene on 26-9-2016.
 */
public class POSCashOrder extends Order {
    public POSCashOrder(Cart cart) {
        super(cart);
    }

    @Override
    public void checkout() {

    }
}
