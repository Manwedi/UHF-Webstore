/**
 * MANWEDI CLAUDE
 * URBAN HATCH FARMS ONLINE STORE
 */

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

    public String getID() {
        return ID;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public boolean isAvailable() {
        return isAvailable;
    }       
}
