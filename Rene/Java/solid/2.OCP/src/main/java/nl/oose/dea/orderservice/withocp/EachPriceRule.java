package nl.oose.dea.orderservice.withocp;

/**
 * Created by Rene on 28-9-2016.
 */
public class EachPriceRule extends PriceRule {
    @Override
    public boolean isMatch(Item item) {
        if(item.sku.startsWith("EACH"))
            return true;

        return false;
    }

    @Override
    public double calculatePrice(Item item) {
        return item.quantity * 5.0;
    }
}
