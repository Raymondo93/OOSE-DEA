/**
 * Created by royho on 25-9-2016.
 */
abstract class Price {
    abstract int getPriceCode();

    public abstract double getCharge(int daysRented);

    public abstract int getFrequentRenterPoints(int daysRented);
}
