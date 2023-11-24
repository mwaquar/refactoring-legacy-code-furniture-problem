package com.thoughtworks.furniturerental;

public class Rental {

    private int daysRented;
    private Furniture furniture;

    public Rental(Furniture furniture, int daysRented) {
        this.furniture = furniture;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public double getPrice() {
        return furniture.getPrice(daysRented);
    }

    public int getFrequentRenterPoints() {
        // add bonus for a two days new launch rental
        return furniture.getFrequentRenterPoints(daysRented);
    }
}