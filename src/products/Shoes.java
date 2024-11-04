package products;

import java.util.Scanner;

public class Shoes extends ClothingItem {

    public Shoes(String productId, String name, String color, String size, Float price) {
        super(productId, name, color, size, price);
    }

    @Override
    public String getType() {
        return "Shoes";
    }

    @Override
    public void setCustomAttribute(Scanner sc) {}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Shoes :\n")
            .append("- ID: ").append(this.getProductId()).append("\n")
            .append("- Color: ").append(this.getColor()).append("\n")
            .append("- Name: ").append(this.getName()).append("\n")
            .append("- Price: ").append(this.getPrice());

        return sb.toString();
    }

}
