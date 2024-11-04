package products;

import java.util.Scanner;

public class Jeans extends ClothingItem {
    private String fit;

    public Jeans(String productId, String name, String color, String size, Float price, String fit) {
        super(productId, name, color, size, price);
        this.fit = fit;
    }

    public String getFit() {
        return this.fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    @Override
    public String getType() {
        return "Jeans";
    }

    @Override
    public void setCustomAttribute(Scanner sc) {
        System.out.println("Enter the fit for this jeans:");
        this.fit = sc.nextLine();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Jeans :\n")
            .append("- ID: ").append(this.getProductId()).append("\n")
            .append("- Name: ").append(this.getName()).append("\n")
            .append("- Color: ").append(this.getColor()).append("\n")
            .append("- Size: ").append(this.getSize()).append("\n")
            .append("- Fit: ").append(this.fit).append("\n")
            .append("- Price: ").append(this.getPrice());

        return sb.toString();
    }

}
