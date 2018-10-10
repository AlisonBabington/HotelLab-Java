import java.util.ArrayList;

public class ConferenceRoom {

    private int number;
    private int capacity;
    private int hourlyRate;
    private ArrayList<Guest> currentGuests;

    public ConferenceRoom(int number, int capacity, int hourlyRate){
        this.number = number;
        this.capacity = capacity;
        this.hourlyRate = hourlyRate;
        this.currentGuests = new ArrayList<>();
    }

    public int guestCount() {
        return currentGuests.size();
    }

    public void addGuest(Guest guest) {
        if (capacity > guestCount()) currentGuests.add(guest);
    }

    public Guest removeGuest(Guest guest) {
        return currentGuests.remove(0);
    }

    public void removeAllGuest() {
        currentGuests.clear();
    }
}
