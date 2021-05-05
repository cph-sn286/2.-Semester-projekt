package business.entities;

public class Materials {
    private int materials_id;
    private String name;
    private int sizes_id;
    private String description;
    private double price;

    public Materials(int materials_id, String name, int sizes_id, String description, double price) {
        this.materials_id = materials_id;
        this.name = name;
        this.sizes_id = sizes_id;
        this.description = description;
        this.price = price;
    }

    public int getMaterials_id() {
        return materials_id;
    }

    public void setMaterials_id(int materials_id) {
        this.materials_id = materials_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSizes_id() {
        return sizes_id;
    }

    public void setSizes_id(int sizes_id) {
        this.sizes_id = sizes_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
