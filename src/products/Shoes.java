package products;

public class Shoes extends ClothingItem {

    public Shoes(String productId, String name, String color, String size, Float price) {
        super(productId, name, color, size, price);
        System.out.println("Shoes created succesfully !");
    }

    public String getType() {
        return "Shoes";
    }

}
