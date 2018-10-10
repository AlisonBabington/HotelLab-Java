public class Booking {

    private int nights;
    private Bedroom bedroom;

    public Booking(int nights, Bedroom bedroom) {
        this.nights = nights;
        this.bedroom = bedroom;
    }

    public Bedroom getRoom() {
        return this.bedroom;
    }

    public int getNights() {
        return this.nights;
    }
}
