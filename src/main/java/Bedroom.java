import java.util.ArrayList;

public class Bedroom {

    private String type;
    private int roomNumber;
    private int capacity;
    private int nightRate;
    private ArrayList<Guest> currentGuests;

    public Bedroom(String type, int roomNumber, int capacity, int nightRate) {
        this.type = type;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.nightRate = nightRate;
        this.currentGuests = new ArrayList<>();
    }

    public int guestCount() {
        return currentGuests.size();
    }

    public void addGuest(Guest guest) {
        if (capacity > guestCount()) currentGuests.add(guest);
    }

    public void removeGuests() {
        currentGuests.clear();
    }
}
