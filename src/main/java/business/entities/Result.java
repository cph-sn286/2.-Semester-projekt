package business.entities;

public class Result {

    double length;
    int amount;
    double price;


    public Result(double length, int amount, double price) {
        this.length = length;
        this.amount = amount;
        this.price = price;




    }

    public Result(double length, int amount) {
        this.length = length;
        this.amount = amount;
    }

    public Result() {
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
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

    public void setPrice(double price) {
        this.price = price;
    }
}
