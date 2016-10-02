package nl.oose.dea.orderservice.withocp;

public class SpecialPriceRule extends PriceRule {
    @Override
    boolean isMatch(Item item) {
        return false;
    }

    @Override
    double calculatePrice(Item item) {
        return 0;
    }
}
