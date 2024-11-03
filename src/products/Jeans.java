package products;

public class Jeans extends ClothingItem {
    private String fit;

    public Jeans(String productId, String name, String color, String size, Float price, String fit) {
        super(productId, name, color, size, price);
        this.fit = fit;
        System.out.println("Jeans created succesfully !");
    }

    public String getFit() {
        return this.fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getType() {
        return "Jeans";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Jeans :\n")
            .append("- Color: ").append(this.getColor()).append("\n")
            .append("- Name: ").append(this.getName()).append("\n")
            .append("- Price: ").append(this.getPrice()).append("\n")
            .append("- Fit: ").append(this.fit);

        return sb.toString();
    }

}
