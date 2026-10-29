package domain;

public class ChickenBatch {
    String ID;
    int quantity;
    int quantityAvailable;
    double price;
    double weight;
    boolean isAvailable;

    public ChickenBatch(String ID, int quantity, double price, double weight) {
        this.ID = ID;
        this.quantity = quantity;
        this.quantityAvailable = quantity;
        this.price = price;
        this.weight = weight;
        this.isAvailable = true;
    }

    public double getTotalPrice() {
        return price * quantity;
    }
}
