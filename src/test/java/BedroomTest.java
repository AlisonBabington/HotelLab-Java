import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    Guest guest;
    Guest guest2;

    @Before
    public void before () {
        bedroom = new Bedroom("Double", 1044, 2, 100, "Empty");
        guest = new Guest("Bob", 2000);
        guest2 = new Guest("Alice", 2000);
    }

    @Test
    public void canAddGuest() {
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.guestCount());
    }

    @Test
    public void roomFull() {
        bedroom.addManyGuests(guest, guest2);
        assertEquals(2, bedroom.guestCount());
        bedroom.addGuest(guest);
        assertEquals(2, bedroom.guestCount());
    }

    @Test
    public void canRemoveGuest(){
        bedroom.addManyGuests(guest, guest2);
        assertEquals(2, bedroom.guestCount());
        bedroom.removeGuests();
        assertEquals(0, bedroom.guestCount());
    }

    @Test
    public void onlyBookEmptyRooms() {
        bedroom.addGuest(guest);
        assertEquals(1,bedroom.guestCount());
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.guestCount());
    }
}
