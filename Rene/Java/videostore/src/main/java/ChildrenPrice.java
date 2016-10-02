/**
 * Created by Rene on 28-9-2016.
 */
class ChildrenPrice extends Price {

    @Override
    int getPriceCode() {
        return Price.CHILDREN;
    }

    @Override
    public double getCharge(int daysRented){
        if (daysRented > 3)
            return (daysRented - 1.5) * 1.5;
        else
            return 1.5;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented){
        return 1;
    }
}
