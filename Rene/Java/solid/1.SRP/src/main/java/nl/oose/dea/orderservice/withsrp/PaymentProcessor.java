package nl.oose.dea.orderservice.withsrp;

/**
 * Created by Rene on 26-9-2016.
 */
public interface PaymentProcessor {
    boolean chargeCard(PaymentDetails paymentDetails, Cart cart);
}
