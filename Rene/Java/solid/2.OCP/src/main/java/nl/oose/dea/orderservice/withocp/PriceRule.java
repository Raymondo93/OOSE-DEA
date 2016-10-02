package nl.oose.dea.orderservice.withocp;

/**
 * Created by Rene on 28-9-2016.
 */
abstract class PriceRule {

    abstract boolean isMatch(Item item);

    abstract double calculatePrice(Item item);
}
