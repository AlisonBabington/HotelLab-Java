import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    Bedroom bedroom;
    Booking booking;

    @Before
    public void before() {
        bedroom = new Bedroom("Double", 1, 2, 100, "Empty");
        booking = new Booking(2, bedroom);
    }

    @Test
    public void bookingHasRoom (){
        assertEquals(bedroom, booking.getRoom());
    }
}
