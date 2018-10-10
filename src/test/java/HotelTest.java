import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    Hotel hotel;
    Bedroom bedroom;
    Bedroom bedroom2;
    Bedroom bedroom3;
    ConferenceRoom conference;
    DiningRoom diningRoom;
    Guest guest;
    Booking booking;

    @Before
    public void before(){
        hotel = new Hotel("CC Towers", 100);
        bedroom = new Bedroom("Double", 1044, 2, 100, "Empty");
        bedroom2 = new Bedroom("Double", 1045, 2, 100, "Empty");
        bedroom3 = new Bedroom("Double", 1046, 2, 100, "Empty");
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

    @Test
    public void bookRoom() {
        hotel.addBedroom(bedroom);
        hotel.bookRoom(2, bedroom);
        assertEquals(1, hotel.bookingCount());
    }

    @Test
    public void bookingBillTotal() {
        hotel.addBedroom(bedroom);
        assertEquals(200, hotel.bookRoom(2, bedroom));
    }

    @Test
    public void emptyBedrooms() {
        hotel.addBedroom(bedroom);
        hotel.addBedroom(bedroom2);
        hotel.addBedroom(bedroom3);
        hotel.checkInGuestToBedroom(guest, bedroom);
        assertEquals(2, hotel.emptyBedroomsCount());
    }

}
