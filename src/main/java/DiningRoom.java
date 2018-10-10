import java.util.ArrayList;
import java.util.HashMap;

public class DiningRoom {

    private int capacity;
    private ArrayList<Guest> currentDiners;
    private HashMap<String, Integer> menu;
    private int till;

    public DiningRoom(int capacity){
        this.capacity = capacity;
        this.currentDiners = new ArrayList<>();
        this.menu = new HashMap<>();
        this.till = 0;
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

    public int menuCount() {
        return menu.size();
    }

    public void addDish(String dish, int price) {
        menu.put(dish, price);
    }

    public int getPrice(String dish) {
        return menu.get(dish);
    }

    public void guestMeal(String dish, Guest guest) {
        int price = getPrice(dish);
        guest.getMeal(price);
        till += price;
    }

    public int getBalance() {
        return till;
    }
}
