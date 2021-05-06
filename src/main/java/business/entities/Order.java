package business.entities;

import java.util.Date;

public class Order {
    private int order_id;
    private int user_id;
    private int carport_id;
    private double price;
    private String date;
    private int status;

    public Order(int order_id, int user_id, int carport_id, double price, String date, int status) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.carport_id = carport_id;
        this.price = price;
        this.date = date;
        this.status = status;
    }

    public Order( int user_id, int carport_id, double price, String date, int status) {
        this.user_id = user_id;
        this.carport_id = carport_id;
        this.price = price;
        this.date = date;
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getCarport_id() {
        return carport_id;
    }

    public void setCarport_id(int carport_id) {
        this.carport_id = carport_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double pris) {
        this.price = pris;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

