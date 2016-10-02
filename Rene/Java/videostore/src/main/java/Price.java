abstract class Price {
    public static final int CHILDREN = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    abstract int getPriceCode();

    abstract public double getCharge(int daysRented);

    abstract public int getFrequentRenterPoints(int daysRented);

    public static Price newPriceCode(int priceCode) {
        switch (priceCode) {
            case REGULAR:
                return new RegularPrice();
            case CHILDREN:
                return new ChildrenPrice();
            case NEW_RELEASE:
                return new NewReleasePrice();
            default:
                throw new IllegalArgumentException
                        ("Incorrect Price Code");
        }
    }
}
