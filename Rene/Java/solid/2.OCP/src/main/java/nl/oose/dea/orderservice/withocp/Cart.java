package nl.oose.dea.orderservice.withocp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rene on 28-9-2016.
 */
public class Cart {
    private PricingCalculator pricingCalculator;
    private List<Item> items;

    public Cart(PricingCalculator pricingCalculator) {
        this.pricingCalculator = pricingCalculator;
        items = new ArrayList<>();
    }

    public double totalAmount() {
        double total = 0;

        for (Item item: items){
            total += pricingCalculator.calculatePrice(item);
        }

        return total;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
