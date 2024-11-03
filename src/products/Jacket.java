package products;

import java.util.Scanner;

public class Jacket extends ClothingItem {
    private String material;

    public Jacket(String productId, String name, String color, String size, Float price, String material) {
        super(productId, name, color, size, price);
        this.material = material;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String getType() {
        return "Jacket";
    }

    @Override
    public void setCustomAttribute(Scanner sc) {
        System.out.println("Enter the material for this jacket:");
        this.material = sc.nextLine();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Jacket :\n")
            .append("- Name: ").append(this.getName()).append("\n")
            .append("- Color: ").append(this.getColor()).append("\n")
            .append("- Size: ").append(this.getSize()).append("\n")
            .append("- Material: ").append(this.material).append("\n")
            .append("- Price: ").append(this.getPrice());

        return sb.toString();
    }
}
