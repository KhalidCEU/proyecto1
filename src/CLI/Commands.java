package CLI;
import java.util.Scanner;
import crud.Crud;
import products.ClothingItem;

public class Commands {
    private Scanner sc;
    private boolean running = true;
    private Crud crud;

    /**
     * Constructs a new Commands object.
     *
     * This constructor initializes the Commands object by:
     * - Assigning the provided Scanner object for reading user input.
     * - Creating a new Crud object.
     * - Loading existing products using the Crud object's loadProducts method.
     *
     * @param sc The scanner object used for reading user input
     */
    public Commands(Scanner sc) {
        this.sc = sc;
        crud = new Crud();
        crud.loadProducts();
    }

    /**
     * Handles user input for creating a product.
     *
     * This method prompts the user's to enter the type of product
     * they want to create, collects them and passes them as parameters
     * to the {@link Crud#createProduct(String, String, String, String, float)} method
     *
     * This method is called when the "add product" command is entered in the CLI
     */
    public void createProduct() {
        System.out.println("Enter the type of product you want to create: "
            + ClothingItem.VALID_ITEM_TYPES);
        String type = sc.nextLine().toLowerCase();

        if (!ClothingItem.isValidItemType(type)) {
            System.out.println("Wrong or non existing product type. Valid types are : "
                + ClothingItem.VALID_ITEM_TYPES);
            return;
        }

        System.out.println("Enter a name for this product: ");
        String name = sc.nextLine();
        System.out.println("Enter a color for this product: ");
        String color = sc.nextLine();
        System.out.println("Enter a size for this product: " + ClothingItem.VALID_SIZES);
        String size = sc.nextLine().toLowerCase();

        if (!ClothingItem.isValidSize(size)) {
            System.out.println("Wrong or non existing product size. Valid sizes are : "
                + ClothingItem.VALID_SIZES);
            return;
        }

        System.out.println("Enter a price for this product: ");
        float price = Float.parseFloat(sc.nextLine());

        crud.createProduct(type, name, color, size, price);
    }

    /**
     * Lists all the existing products.
     *
     * This method displays all products by calling the
     * {@link Crud#readProducts()} method
     */
    public void list() {
        crud.readProducts();
    }

    /**
     * Exits the CLI.
     *
     * This method saves the changes made to products by using the
     * {@link Crud#saveProducts()} method and then sets the running
     * state to false, which will affect the behavior of the
     * {@link #isRunning()} method.
     */
    public void exit() {
        crud.saveProducts();
        System.out.println("See you!");
        running = false;
    }

    /**
     * Returns the current running state of the CLI.
     *
     * This method indicates if the CLI should continue running or stop
     *
     * @return the state of the {@link running} boolean.
     */
    public boolean isRunning() {
        return running;
    }

}
