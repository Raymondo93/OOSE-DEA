package nl.oose.dea.orderservice.withsrp;

import nl.oose.dea.orderservice.withoutsrp.MailClient;

import javax.mail.MessagingException;
import java.util.logging.Logger;

/**
 * Created by Rene on 26-9-2016.
 */
public class MailNotificationService implements NotificationService {
    private Logger logger = Logger.getLogger(getClass().getName());
    @Override
    public void notifyCustomer(Cart cart) {
        MailClient mailClient = new MailClient();
        try {
            mailClient.send("Your order is processed.", cart.getCustomerEmail());
        } catch (MessagingException e) {
            logger.severe(e.getMessage());
            throw new OrderException("Cannot send mail to " + cart.getCustomerEmail(), e);
        }
    }
}
