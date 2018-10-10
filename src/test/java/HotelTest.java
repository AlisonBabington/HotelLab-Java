import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    Bedroom bedroom;
    ConferenceRoom conference;
    DiningRoom diningRoom;
    Guest guest;

    @Before
    public void before(){
        hotel = new Hotel("CC Towers", 100);
        bedroom = new Bedroom("Double", 1044, 2, 100);
        conference = new ConferenceRoom(1, 5, 50);
        guest = new Guest("Bob", 2000);
    }

    @Test
    public void addBedroom() {
        hotel.addBedroom(bedroom);
        assertEquals(1, hotel.bedroomsCount());
    }

    @Test
    public void addConferenceRoom() {
        hotel.addConferenceRoom(conference);
        assertEquals(1, hotel.conferenceRoomCount());
    }

    @Test
    public void checkGuestInBedroom() {
        hotel.addBedroom(bedroom);
        hotel.checkInGuestToBedroom(guest, bedroom);
        assertEquals(1, bedroom.guestCount());
    }

    @Test
    public void checkGuestinConference() {
        hotel.addConferenceRoom(conference);
        hotel.checkInGuestToConference(guest, conference);
        assertEquals(1, conference.guestCount());
    }

    @Test
    public void checkGuestInDiningRoom() {
        hotel.checkInGuestToDiningRoom(guest);
        assertEquals(1, hotel.getDiningRoomCount());
    }

    @Test
    public void checkOutGuestBedroom() {
        hotel.addBedroom(bedroom);
        hotel.checkInGuestToBedroom(guest, bedroom);
        hotel.checkInGuestToBedroom(guest, bedroom);
        hotel.checkOutGuestBedroom(bedroom);
        assertEquals(0, bedroom.guestCount());
    }

    @Test
    public void checkOutGuestConferenceRoom() {
        hotel.addConferenceRoom(conference);
        hotel.checkInGuestToConference(guest, conference);
        hotel.checkInGuestToConference(guest, conference);
        hotel.checkInGuestToConference(guest, conference);
        hotel.checkInGuestToConference(guest, conference);
        hotel.checkOutGuestConferenceRoom(guest, conference);
        assertEquals(3, conference.guestCount());
    }

    @Test
    public void checkOutGuestDiningRoom() {
        hotel.checkInGuestToDiningRoom(guest);
        hotel.checkInGuestToDiningRoom(guest);
        hotel.checkInGuestToDiningRoom(guest);
        hotel.checkOutGuestDiningRoom();
        assertEquals(2, hotel.getDiningRoomCount());
    }

}
