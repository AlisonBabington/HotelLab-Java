import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    Bedroom bedroom;
    Booking booking;
    Guest guest;
    Date date;

    @Before
    public void before() {
        date = new Date();
        guest = new Guest("Bob", 2000);
        bedroom = new Bedroom("Double", 1, 2, 100, "Empty");
        booking = new Booking(2, bedroom, guest, date);
    }

    @Test
    public void bookingHasRoom (){
        assertEquals(bedroom, booking.getRoom());
    }
}
