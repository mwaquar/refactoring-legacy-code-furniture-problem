package com.thoughtworks.furniturerental;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    public void testStatement(){
        String expected = "Rental Record for John\n" +
                "\tSofa\t350.0\n" +
                "\tChair\t600.0\n" +
                "Amount owed is 950.0\n" +
                "You earned 3 frequent renter points";

        Customer customer = new Customer("John");
        Rental rental1 = new Rental(new Furniture("Sofa", Furniture.REGULAR), 3);
        Rental rental2 = new Rental(new Furniture("Chair", Furniture.NEW_LAUNCH), 2);

        customer.addRental(rental1);
        customer.addRental(rental2);

        assertEquals(expected, customer.statement());
    }
}