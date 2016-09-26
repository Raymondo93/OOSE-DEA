package nl.oose.dea.orderservice.withsrp;

/**
 * Created by Rene on 26-9-2016.
 */
public abstract class Order {
    private PaymentDetails paymentDetails;
    private Cart cart;

    public Order(Cart cart){
        this.cart = cart;
    }

    public Order(Cart cart, PaymentDetails paymentDetails) {
        this.cart = cart;
        this.paymentDetails = paymentDetails;
    }

    public void checkout(){

    }
}
