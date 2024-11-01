package CLI;
import java.util.Scanner;
import crud.Crud;
import products.ClothingItem;

public class Commands {
    private Scanner sc;
    private boolean running = true;
    private Crud crud;

    public Commands(Scanner sc) {
        this.sc = sc;
        crud = new Crud();
        crud.loadProducts();
    }

    public void createProduct() {
        System.out.println("Enter the type of product you want to create: ");
        String type = sc.nextLine().toLowerCase();

        if (!ClothingItem.isValidItemType(type)) {
            System.out.println("Wrong or non exissting product type. Valid types are : "
                + ClothingItem.VALID_ITEM_TYPES);
            return;
        }

        System.out.println("Enter a name for this product: ");
        String name = sc.nextLine();
        System.out.println("Enter a color for this product: ");
        String color = sc.nextLine();
        System.out.println("Enter a size for this product: ");
        String size = sc.nextLine().toLowerCase();

        if (!ClothingItem.isValidSize(size)) {
            System.out.println("Wrong or non existing product size. Valid sizes are : " + ClothingItem.VALID_SIZES);
            return;
        }

        System.out.println("Enter a price for this product: ");
        float price = Float.parseFloat(sc.nextLine());

        crud.createProduct(type, "1 (test)", name, color, size, price);
    }

    public void list() {
        crud.readProducts();
    }

    public void exit() {
        crud.saveProducts();
        System.out.println("See you!");
        running = false;
    }

    public void print() {
        System.out.println("Print function.");
    }

    public boolean isRunning() {
        return running;
    }

}
