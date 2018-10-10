import java.util.ArrayList;

public class Bedroom {

    private String type;
    private int roomNumber;
    private int capacity;
    private int nightRate;
    private String status;
    private ArrayList<Guest> currentGuests;

    public Bedroom(String type, int roomNumber, int capacity, int nightRate, String status) {
        this.type = type;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.nightRate = nightRate;
        this.currentGuests = new ArrayList<>();
        this.status = status;
    }

    public int guestCount() {
        return currentGuests.size();
    }

    public void addGuest(Guest guest) {

        if ( status == "Empty") {
            currentGuests.add(guest);
            status = "Full";
        }
    }

    public void removeGuests() {
        currentGuests.clear();
    }

    public int getNightRate() {
        return nightRate;
    }

    public String getStatus() {
        return status;
    }

    public void addManyGuests(Guest guest, Guest guest2) {
        if (capacity > guestCount() && status == "Empty") {
            currentGuests.add(guest);
            currentGuests.add(guest2);
            status = "Full";
        }
    }
}
