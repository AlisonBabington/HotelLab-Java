public class Guest {

    private String name;
    private int wallet;

    public Guest(String name, int wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return wallet;
    }

    public void getMeal(int price) {
        wallet -= price;
    }
}
