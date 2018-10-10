import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conference;
    Guest guest;

    @Before
    public void before() {
        conference = new ConferenceRoom(1, 5, 50);
        guest = new Guest("Bob", 2000);
    }

    @Test
    public void addGuest() {
        conference.addGuest(guest);
        assertEquals(1, conference.guestCount());
    }

    @Test
    public void conferenceRoomIsFull(){
        conference.addGuest(guest);
        conference.addGuest(guest);
        conference.addGuest(guest);
        conference.addGuest(guest);
        conference.addGuest(guest);
        assertEquals(5, conference.guestCount());
        conference.addGuest(guest);
        conference.addGuest(guest);
        assertEquals(5, conference.guestCount());
    }

    @Test
    public void removeByGuest() {
        conference.addGuest(guest);
        conference.addGuest(guest);
        conference.addGuest(guest);
        assertEquals(3, conference.guestCount());
        conference.removeGuest(guest);
        assertEquals(2, conference.guestCount());
    }

    @Test
    public void removeAllGuests() {
        conference.addGuest(guest);
        conference.addGuest(guest);
        conference.addGuest(guest);
        conference.addGuest(guest);
        conference.removeAllGuest();
        assertEquals(0, conference.guestCount());
    }

}
