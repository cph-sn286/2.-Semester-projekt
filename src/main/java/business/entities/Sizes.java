package business.entities;

public class Sizes {
    private int sizes_id;
    private double heigth;
    private double length;
    private double width;

    public Sizes(int sizes_id, double heigth, double length, double width) {
        this.sizes_id = sizes_id;
        this.heigth = heigth;
        this.length = length;
        this.width = width;
    }

    public int getSizes_id() {
        return sizes_id;
    }

    public void setSizes_id(int sizes_id) {
        this.sizes_id = sizes_id;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
