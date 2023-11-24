package com.thoughtworks.furniturerental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental each : rentals) {
            //show figures for this rental
            result += "\t" + each.getFurniture().getTitle() + "\t" +
                    each.getPrice() + "\n";
        }

        //add footer lines result
        result += "Amount owed is " + getTotalAmount() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints()
                + " frequent renter points";
        return result;
    }

    private double getTotalAmount() {
        double totalAmount = 0;
        for (Rental each : rentals) {
            totalAmount += each.getPrice();
        }
        return totalAmount;
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental each : rentals) {
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }
}

