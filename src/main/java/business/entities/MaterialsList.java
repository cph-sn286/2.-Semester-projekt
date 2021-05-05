package business.entities;

public class MaterialsList {
    private int materialList_id;
    private int carport_id;
    private int materials_id;
    private double amount;
    private int unit_id;

    public MaterialsList(int materialList_id, int carport_id, int materials_id, double amount, int unit_id) {
        this.materialList_id = materialList_id;
        this.carport_id = carport_id;
        this.materials_id = materials_id;
        this.amount = amount;
        this.unit_id = unit_id;
    }

    public int getMaterialList_id() {
        return materialList_id;
    }

    public void setMaterialList_id(int materialList_id) {
        this.materialList_id = materialList_id;
    }

    public int getCarport_id() {
        return carport_id;
    }

    public void setCarport_id(int carport_id) {
        this.carport_id = carport_id;
    }

    public int getMaterials_id() {
        return materials_id;
    }

    public void setMaterials_id(int materials_id) {
        this.materials_id = materials_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(int unit_id) {
        this.unit_id = unit_id;
    }
}
