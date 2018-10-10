import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Hotel {

    private String name;
    private int till;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private DiningRoom diningRoom;
    private ArrayList<Booking> bookings;

    public Hotel(String name, int till) {
        this.name = name;
        this.till = till;
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.diningRoom = new DiningRoom(5);
        this.bookings = new ArrayList<>();
    }

    public int bedroomsCount() {
        return bedrooms.size();
    }

    public void addBedroom(Bedroom bedroom) {
        bedrooms.add(bedroom);
    }

    public int conferenceRoomCount() {
        return conferenceRooms.size();
    }

    public void addConferenceRoom(ConferenceRoom conference) {
        conferenceRooms.add(conference);
    }


    public void checkInGuestToBedroom(Guest guest, Bedroom bedroom) {
        int bedroomIndex = bedrooms.indexOf(bedroom);
        Bedroom thisBedroom = bedrooms.get(bedroomIndex);
        thisBedroom.addGuest(guest);
    }

    public void checkInGuestToConference(Guest guest, ConferenceRoom conference) {
        int conferenceIndex = conferenceRooms.indexOf(conference);
        ConferenceRoom thisConferenceRoom = conferenceRooms.get(conferenceIndex);
        thisConferenceRoom.addGuest(guest);
    }

    public void checkInGuestToDiningRoom(Guest guest) {
        diningRoom.addGuest(guest);
    }

    public int getDiningRoomCount() {
        return diningRoom.guestCount();
    }

    public void checkOutGuestBedroom(Bedroom bedroom) {
        int bedroomIndex = bedrooms.indexOf(bedroom);
        Bedroom thisBedroom = bedrooms.get(bedroomIndex);
        thisBedroom.removeGuests();
    }

    public Guest checkOutGuestConferenceRoom(Guest guest, ConferenceRoom conference) {
        int conferenceIndex = conferenceRooms.indexOf(conference);
        ConferenceRoom thisConferenceRoom = conferenceRooms.get(conferenceIndex);
        return thisConferenceRoom.removeGuest(guest);
    }

    public Guest checkOutGuestDiningRoom() {
        return diningRoom.removeDiner();
    }

    public int bookingCount() {
        return bookings.size();
    }

    public int bookRoom(int nights, Bedroom bedroom, Guest guest) {
        int bedroomIndex = bedrooms.indexOf(bedroom);
        Bedroom thisBedroom = bedrooms.get(bedroomIndex);
        Date thisDate = new Date();
        System.out.println(thisDate);
        Booking thisBooking = new Booking(nights, thisBedroom, guest, thisDate);
        bookings.add(thisBooking);
        return chargeRoom(thisBooking);
    }

    private int chargeRoom(Booking thisBooking) {
        Bedroom bedroom = thisBooking.getRoom();
        int nights = thisBooking.getNights();
        return bedroom.getNightRate() * nights;
    }

    public int emptyBedroomsCount() {
        ArrayList<Bedroom> emptyBedrooms = new ArrayList<>();
        bedrooms.forEach(bedroom -> { if (bedroom.getStatus() == "Empty") emptyBedrooms.add(bedroom);});
        return emptyBedrooms.size();
    }
}
