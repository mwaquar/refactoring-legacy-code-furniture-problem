package com.thoughtworks.furniturerental;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @Test
    public void testTextStatement(){
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

        assertEquals(expected, customer.textStatement());
    }
    @Test
    public void testHtmlStatement(){
        String expected = "<h1>Rental Record for <b>John</b><h1>\n" +
                "\t<p>Sofa\t350.0</p><br>\n" +
                "\t<p>Chair\t600.0</p><br>\n" +
                "<p>Amount owed is <b>950.0</b></p><br>\n" +
                "<p>You earned <b>3</b> frequent renter points</p>";

        Customer customer = new Customer("John");
        Rental rental1 = new Rental(new Furniture("Sofa", Furniture.REGULAR), 3);
        Rental rental2 = new Rental(new Furniture("Chair", Furniture.NEW_LAUNCH), 2);

        customer.addRental(rental1);
        customer.addRental(rental2);

        assertEquals(expected, customer.htmlStatement());
    }
}