package data;

import java.util.ArrayList;
import products.ClothingItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StorageManager {
    private static String Filename = "data.dat";


    /**
     * Saves the products to a file using an ObjectOutputStream.
     *
     * @param products The ArrayList of products to save.
     *
     */
    public void saveProducts(ArrayList<ClothingItem> products) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(Filename));
            outputStream.writeObject(products);
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Got an error while saving products: " + e.getMessage());
        }
    }

    /**
     * Loads the products from a file using an ObjectInputStream.
     *
     * @return An ArrayList of products read by the ObjectInputStream or an empty list
     * if the file doesn't exist.
     *
     */
    public ArrayList<ClothingItem> loadProducts() {
        File file = new File(Filename);

        if (!file.exists()) {
            System.out.println("No saved products found, creating an empty list.");
            return new ArrayList<>();
        }

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            ArrayList<ClothingItem> fileProducts = (ArrayList<ClothingItem>) inputStream.readObject();
            inputStream.close();
            System.out.println("Products loaded successfully");
            return fileProducts;
        } catch (Exception e) {
            System.out.println("Got an error while reading products: " + e);
        }

        return new ArrayList<>();
    }

}
