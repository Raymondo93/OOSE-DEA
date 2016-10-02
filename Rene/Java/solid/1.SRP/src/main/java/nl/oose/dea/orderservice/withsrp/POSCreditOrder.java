package nl.oose.dea.orderservice.withsrp;

/**
 * Created by Rene on 26-9-2016.
 */
public class POSCreditOrder extends Order implements PaymentProcessor{
    public POSCreditOrder(Cart cart, PaymentDetails paymentDetails) {
        super(cart, paymentDetails);
    }

    @Override
    public boolean chargeCard(PaymentDetails paymentDetails, Cart cart) {
        return false;
    }
}
