package business.entities;

public class CarportItems {

    String name;
    double length;
    int amount;
    double price;

    public CarportItems(String name, Double length, int amount, double price) {
        this.name = name;
        this.length = length;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarportItems{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", amount=" + amount +
                '}';
    }
}
