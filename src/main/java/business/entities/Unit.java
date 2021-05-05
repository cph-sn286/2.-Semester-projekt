package business.entities;

public class Unit {
    private int unit_id;
    private String unit;

    public Unit(int unit_id, String unit) {
        this.unit_id = unit_id;
        this.unit = unit;
    }

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
