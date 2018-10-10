import java.util.ArrayList;
import java.util.HashMap;

public class DiningRoom {

    private int capacity;
    private ArrayList<Guest> currentDiners;
    private HashMap<String, Integer> menu;

    public DiningRoom(int capacity){
        this.capacity = capacity;
        this.currentDiners = new ArrayList<>();
        this.menu = new HashMap<>();
    }

    public int guestCount() {
        return currentDiners.size();
    }

    public void addGuest(Guest guest) {
        if (capacity > guestCount()) currentDiners.add(guest);
    }

    public Guest removeDiner() {
        return currentDiners.remove(0);
    }
}
