import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    DiningRoom diningRoom;
    Guest guest;

    @Before
    public void before() {
        diningRoom = new DiningRoom(5);
        guest = new Guest("Bob", 2000);
    }

    @Test
    public void addDiner(){
        diningRoom.addGuest(guest);
        assertEquals(1, diningRoom.guestCount());
    }

    @Test
    public void removeDiner() {
        diningRoom.addGuest(guest);
        diningRoom.addGuest(guest);
        diningRoom.addGuest(guest);
        diningRoom.removeDiner();
        assertEquals(2, diningRoom.guestCount());
    }

    @Test
    public void canAddToMenu() {
        diningRoom.addDish("Burger", 5);
        assertEquals(1, diningRoom.menuCount());
    }

    @Test
    public void getPriceByKey(){
        diningRoom.addDish("Burger", 5);
        assertEquals(5, diningRoom.getPrice("Burger"));
    }

    @Test
    public void giveMealToGuest() {
        diningRoom.addDish("Burger", 5);
        diningRoom.guestMeal("Burger", guest);
        assertEquals(1995, guest.getMoney());
    }
}
