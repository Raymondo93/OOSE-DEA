import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VideoStoreTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Fred");
    }

    @Test
    public void testSingleNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", Price.NEW_RELEASE), 3));
        assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\nAmount owed is 9.0\nYou earned 2 frequent renter points\n", customer.statement());
    }

    @Test
    public void testDualNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", Price.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("The Tigger Movie", Price.NEW_RELEASE), 3));

        assertEquals("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nAmount owed is 18.0\nYou earned 4 frequent renter points\n", customer.statement());
    }

    @Test
    public void testSingleChildrensStatement() {
        customer.addRental(new Rental(new Movie("The Tigger Movie", Price.CHILDREN), 3));
        assertEquals("Rental Record for Fred\n\tThe Tigger Movie\t1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points\n", customer.statement());

    }

    @Test
    public void testMultipleRegularStatement() {
        customer.addRental(new Rental(new Movie("Plan 9 from Outer Space", Price.NEW_RELEASE), 1));
        customer.addRental(new Rental(new Movie("8 1/2", Price.NEW_RELEASE), 2));
        customer.addRental(new Rental(new Movie("Eraserhead", Price.NEW_RELEASE), 3));

        assertEquals("Rental Record for Fred\n\tPlan 9 from Outer Space\t3.0\n\t8 1/2\t6.0\n\tEraserhead\t9.0\nAmount owed is 18.0\nYou earned 5 frequent renter points\n", customer.statement());

    }
}
