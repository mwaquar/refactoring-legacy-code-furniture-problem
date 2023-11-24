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
        double thisAmount = 0;
        switch (getFurniture().getPriceCode()) {
            case Furniture.REGULAR:
                thisAmount += 200;
                if (getDaysRented() > 2)
                    thisAmount += (getDaysRented() - 2) * 150;
                break;
            case Furniture.NEW_LAUNCH:
                thisAmount += getDaysRented() * 300;
                break;
            case Furniture.CHILDREN:
                thisAmount += 150;
                if (getDaysRented() > 3)
                    thisAmount += (getDaysRented() - 3) * 150;
                break;
        }
        return thisAmount;
    }
}