/**
 * Created by royho on 25-9-2016.
 */
public class RegularPrice extends Price {
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge(int daysRented) {
        if(daysRented > 2)
            return 2 + (daysRented - 2) * 1.5;
        return 2;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
