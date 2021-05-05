package business.entities;

public class Carport {
    private int carport_id;
    private double length;
    private double width;
    private String rooftype;
    private int shed_id;
    private double sum;

    public Carport(double length, double width, String rooftype, int shed_id, double sum) {
        this.length = length;
        this.width = width;
        this.rooftype = rooftype;
        this.shed_id = shed_id;
        this.sum = sum;
    }

    public Carport(int carport_id, double length, double width, String rooftype, int shed_id, double sum) {
        this.carport_id = carport_id;
        this.length = length;
        this.width = width;
        this.rooftype = rooftype;
        this.shed_id = shed_id;
        this.sum = sum;
    }

    public int getCarport_id() {
        return carport_id;
    }

    public void setCarport_id(int carport_id) {
        this.carport_id = carport_id;
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

    public String getRooftype() {
        return rooftype;
    }

    public void setRooftype(String rooftype) {
        this.rooftype = rooftype;
    }

    public int getShed_id() {
        return shed_id;
    }

    public void setShed_id(int shed_id) {
        this.shed_id = shed_id;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
