public class Inventory {

    private String name;
    private double price;
    private int quantity;
    private String type;


    public Inventory(String name, double price, int quantity, String type) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getType() {
        return type;
    }


    public void addQuantity(int amount) {
        this.quantity += amount;
    }


    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }


    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }
}
