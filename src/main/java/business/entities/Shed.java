package business.entities;

public class Shed {
    private int shed_id;
    private double length;
    private double width;

    public Shed(int shed_id, double length, double width) {
        this.shed_id = shed_id;
        this.length = length;
        this.width = width;
    }

    public Shed(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public int getShed_id() {
        return shed_id;
    }

    public void setShed_id(int shed_id) {
        this.shed_id = shed_id;
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
