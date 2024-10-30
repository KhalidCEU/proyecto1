package products;

public class Jacket extends ClothingItem {
    private String material;

    public Jacket(String productId, String name, String color, String size, Float price, String material) {
        super(productId, name, color, size, price);
        this.material = material;
        System.out.println("Jacket created succesfully !");
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getType() {
        return "Jacket";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Jacket :\n")
            .append("- Color:").append(this.getColor()).append("\n")
            .append("- Name: ").append(this.getName()).append("\n")
            .append("- Price: ").append(this.getPrice()).append("\n")
            .append("- Material: ").append(this.material);

        return sb.toString();
    }
}
