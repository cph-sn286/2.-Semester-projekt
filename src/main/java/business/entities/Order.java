package business.entities;

import java.util.Date;

public class Order {
    private int order_id;
    private int carport_id;
    private int user_id;
    private double pris;
    private String date;
    private int status;

    public Order(int order_id, int carport_id, int user_id, double pris, String date, int status) {
        this.order_id = order_id;
        this.carport_id = carport_id;
        this.user_id = user_id;
        this.pris = pris;
        this.date = date;
        this.status = status;
    }

    public Order(int carport_id, int user_id, double pris, String date, int status) {
        this.carport_id = carport_id;
        this.user_id = user_id;
        this.pris = pris;
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

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
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

