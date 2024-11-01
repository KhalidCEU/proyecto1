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

    public void saveProducts(ArrayList<ClothingItem> products) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(Filename));
            outputStream.writeObject(products);
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Got an error while saving products: " + e.getMessage());
        }
    }

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
            return fileProducts;
        } catch (Exception e) {
            System.out.println("Got an error while reading products: " + e);
        }

        return new ArrayList<>();
    }

}
