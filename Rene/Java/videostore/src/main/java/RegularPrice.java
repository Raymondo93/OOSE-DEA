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
