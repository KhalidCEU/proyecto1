package crud;
import products.ClothingItem;
import products.*;
import data.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.function.Supplier;

public class Crud {
    private Map<String, Supplier<ClothingItem>> itemTypesMap = new HashMap<>();
    private ArrayList<ClothingItem> products;
    private StorageManager storageManager = new StorageManager();

    public Crud() {
        itemTypesMap.put("jacket", () -> new Jacket(null, null, null, null, null, null));
        itemTypesMap.put("jeans", () -> new Jeans(null, null, null, null, null, null));
        itemTypesMap.put("shoes", () -> new Shoes(null, null, null, null, null));
    }

    /**
     * Creates a ClothingItem object.
     *
     * This method creates a ClothingItem item based on its type
     * by using a {@link Supplier<ClothingItem>} from the itemTypesMap.
     * Once it gets the right supplier, it sets the parameters to the
     * item's attributes and adds the product to the products ArrayList.
     *
     * @param productType The type of the clothing item.
     * @param name The name of the clothing item.
     * @param color The color of the clothing item.
     * @param size The size of the clothing item.
     * @param price The price of the clothing item.
     * @return The created ClothingItem object added to the products list.
     */
    public ClothingItem createProduct(String productType, String name,
        String color, String size, float price) {

        Supplier<ClothingItem> itemSupplier = itemTypesMap.get(productType);

        if (itemSupplier == null) {
            System.out.println("Invalid product type: " + productType);
            return null;
        }

        String productId = Integer.toString(products.size() + 1);

        ClothingItem item = itemSupplier.get();
        item.setProductId(productId);
        item.setName(name);
        item.setColor(color);
        item.setSize(size);
        item.setCustomAttribute(new Scanner(System.in));
        item.setPrice(price);
        products.add(item);

        System.out.println(item.getType() + " created succesfully !");
        return item;
    }

    /**
     * Prints all the items in the products list.
     * If the list is empty, it displays a message indicating that
     * no products are available.
     *
     * This method is used by the {@link CLI.Commands#list()} method.
     */
    public void readProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available");
            return;
        }

        System.out.println("\nProducts:\n");

        for (ClothingItem p : products) {
            System.out.println(p.toString());
            System.out.print("\n");
        }
    }


    public void updateProduct() {

    }

    public void deleteProduct(String productId) {
        Iterator<ClothingItem> iterator = products.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            ClothingItem item = iterator.next();

            if (item.getProductId().equals(productId)) {
                System.out.println("Found item : \n\n" + item.toString() + "\n");
                iterator.remove();
                found = true;
                System.out.println("Item " + productId + " removed succesfully" );
                return;
            }
        }

        if (!found) {
            System.out.println("Product with ID " + productId + " not found");
        }
    }


    /**
     * Loads the products from the input object stream by calling
     * the {@link StorageManager#loadProducts()} method, and assigns
     * them to the "products" variable.
     *
     * Displays a message of success if the loading is successful
     * or an error message along with the exception message if it fails.
     */
    public void loadProducts() {
        try {
            products = storageManager.loadProducts();
        }  catch (Exception e) {
            System.out.println("Failed to load products" + e.getMessage());
        }
    }

    /**
     * Saves the products to the the output object stream by calling
     * the {@link StorageManager#saveProducts(ArrayList)} method.
     *
     * Displays a message of success if the saving is successful
     * or an error message along with the exception message if it fails.
     */
    public void saveProducts() {
        try {
            storageManager.saveProducts(products);
            System.out.println("Products saved successfully");
        }  catch (Exception e) {
            System.out.println("Failed to save products" + e.getMessage());
        }
    }

}
