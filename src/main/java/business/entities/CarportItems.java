package business.entities;

public class CarportItems {

    String name;
    Double length;
    int amount;

    public CarportItems(String name, Double length, int amount) {
        this.name = name;
        this.length = length;
        this.amount = amount;
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
}
