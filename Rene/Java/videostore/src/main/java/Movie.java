public class Movie {
    private String _title;
    private Price _price;

    public Movie(String title, int priceCode) {
        _title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return _price.getPriceCode();
    }

    public void setPriceCode(int arg) {
        switch (arg) {
            case Price.REGULAR:
                _price = new RegularPrice();
                break;
            case Price.CHILDREN:
                _price = new ChildrenPrice();
                break;
            case Price.NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException
                        ("Incorrect Price Code");
        }
    }

    public String getTitle() {
        return _title;
    }

    public double getCharge(int daysRented) {
        return _price.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return _price.getFrequentRenterPoints(daysRented);
    }
}

abstract class Price {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    abstract int getPriceCode();

    abstract public double getCharge(int daysRented);

    abstract public int getFrequentRenterPoints(int daysRented);
}

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

class NewReleasePrice extends Price {

    @Override
    int getPriceCode() {
        return Price.NEW_RELEASE;
    }

    @Override
    public double getCharge(int daysRented){
        return daysRented * 3;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        if (daysRented > 1)
            return 2;
        else
            return 1;
    }
}

class RegularPrice extends Price {

    @Override
    int getPriceCode() {
        return Price.REGULAR;
    }

    @Override
    public double getCharge(int daysRented){
        if (daysRented > 2)
            return (daysRented) * 1.5;
        else
            return 2;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
