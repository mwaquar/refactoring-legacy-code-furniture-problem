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

    public String textStatement() {
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

    public String htmlStatement() {
        String result = "<h1>Rental Record for <b>" + getName() + "</b><h1>\n";
        for (Rental each : rentals) {
            //show figures for this rental
            result += "\t<p>" + each.getFurniture().getTitle() + "\t" +
                    each.getPrice() + "</p><br>\n";
        }

        //add footer lines result
        result += "<p>Amount owed is <b>" + getTotalAmount() + "</b></p><br>\n";
        result += "<p>You earned <b>" + getTotalFrequentRenterPoints()
                + "</b> frequent renter points</p>";
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

