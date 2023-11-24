package com.thoughtworks.furniturerental;

public class Furniture {
    public static final int REGULAR = 0;
    public static final int NEW_LAUNCH = 1;
    public static final int CHILDREN = 2;

    private String title;
    private int priceCode;

    public Furniture(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int arg) {
        priceCode = arg;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice(int daysRented) {
        double thisAmount = 0;
        switch (getPriceCode()) {
            case Furniture.REGULAR:
                thisAmount += 200;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 150;
                break;
            case Furniture.NEW_LAUNCH:
                thisAmount += daysRented * 300;
                break;
            case Furniture.CHILDREN:
                thisAmount += 150;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 150;
                break;
        }
        return thisAmount;
    }

    public int getFrequentRenterPoints(int daysRented) {
        // add bonus for a two days new launch rental
        if (getPriceCode() == Furniture.NEW_LAUNCH && daysRented > 1)
            return 2;
        return 1;
    }

}