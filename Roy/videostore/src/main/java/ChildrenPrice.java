/**
 * Created by royho on 25-9-2016.
 */
public class ChildrenPrice extends Price {
    int getPriceCode() {
        return Movie.CHILDREN;
    }

    @Override
    public double getCharge(int daysRented) {
        if(daysRented > 3)
            return 1.5 + (daysRented - 3) * 1.5;
        return 1.5;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
