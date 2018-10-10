import java.util.ArrayList;

public class Hotel {

    private String name;
    private int till;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private DiningRoom diningRoom;

    public Hotel(String name, int till) {
        this.name = name;
        this.till = till;
        this.bedrooms = new ArrayList<>();
        this.conferenceRooms = new ArrayList<>();
        this.diningRoom = new DiningRoom(5);
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
}
