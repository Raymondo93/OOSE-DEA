package nl.oose.dea.orderservice.withocp;

public class PerGramPriceRule extends PriceRule {
    @Override
    boolean isMatch(Item item) {
        return item.sku.startsWith("WEIGHT");
    }

    @Override
    double calculatePrice(Item item) {
        return (item.quantity / 3) * 0.2;
    }
}
