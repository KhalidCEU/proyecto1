package crud;
import products.ClothingItem;
import products.*;
import data.*;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

import java.util.function.Supplier;

public class Crud {
    private Map<String, Supplier<ClothingItem>> itemTypesMap = new HashMap<>();
    private ArrayList<ClothingItem> products = new ArrayList<>();
    private StorageManager storageManager = new StorageManager();

    public Crud() {
        itemTypesMap.put("jacket", () -> new Jacket(null, null, null, null, null, null));
        itemTypesMap.put("jeans", () -> new Jeans(null, null, null, null, null, null));
        itemTypesMap.put("shoes", () -> new Shoes(null, null, null, null, null));
    }

    public ClothingItem createProduct(String productType, String productId, String name, String color, String size, float price) {
        Supplier<ClothingItem> itemSupplier = itemTypesMap.get(productType);

        if (itemSupplier == null) {
            System.out.println("Invalid product type: " + productType);
            return null;
        }

        ClothingItem item = itemSupplier.get();
        item.setProductId(productId);
        item.setName(name);
        item.setColor(color);
        item.setSize(size);
        item.setPrice(price);
        products.add(item);

        return item;
    }

    public void readProducts() {
        System.out.print("\n");
        System.out.println("Productos:");
        System.out.print("\n");

        for (ClothingItem p : products) {
            System.out.println("" + p.toString());
            System.out.print("\n");
        }
    }


    public void updateProduct() {

    }

    public void deleteProduct() {

    }

    public void loadProducts() {
        try {
            products = storageManager.loadProducts();
            System.out.println("Products loaded successfully");
        }  catch (Exception e) {
            System.out.println("Failed to load products" + e.getMessage());
        }
    }

    public void saveProducts() {
        try {
            storageManager.saveProducts(products);
            System.out.println("Products saved successfully");
        }  catch (Exception e) {
            System.out.println("Failed to save products" + e.getMessage());
        }
    }

}
