package crud;
import products.ClothingItem;
import products.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Crud {
    private Map<String, Supplier<ClothingItem>> itemTypesMap = new HashMap<>();

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

        return item;
    }

    public void readProduct(String productId) {

    }

    public void updateProduct() {

    }

    public void deleteProduct() {

    }

}
