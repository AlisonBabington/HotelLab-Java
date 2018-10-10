import java.util.Date;

public class Booking {

    private int nights;
    private Bedroom bedroom;
    private Guest guest;
    private Date date;

    public Booking(int nights, Bedroom bedroom, Guest guest, Date date) {
        this.nights = nights;
        this.bedroom = bedroom;
        this.guest = guest;
        this.date = date;
    }

    public Bedroom getRoom() {
        return this.bedroom;
    }

    public int getNights() {
        return this.nights;
    }

    public Guest getGuest() {
        return this.guest;
    }
}
