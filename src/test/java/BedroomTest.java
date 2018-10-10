import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    Guest guest;

    @Before
    public void before () {
        bedroom = new Bedroom("Double", 1044, 2, 100);
        guest = new Guest("Bob", 2000);
    }

    @Test
    public void canAddGuest() {
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.guestCount());
    }

    @Test
    public void roomFull() {
        bedroom.addGuest(guest);
        bedroom.addGuest(guest);
        assertEquals(2, bedroom.guestCount());
        bedroom.addGuest(guest);
        assertEquals(2, bedroom.guestCount());
    }

    @Test
    public void canRemoveGuest(){
        bedroom.addGuest(guest);
        bedroom.addGuest(guest);
        assertEquals(2, bedroom.guestCount());
        bedroom.removeGuests();
        assertEquals(0, bedroom.guestCount());
    }
}
