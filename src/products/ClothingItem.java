package products;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public abstract class ClothingItem implements Serializable {
    private String productId;
    private String name;
    private String color;
    private String size;
    private Float price;

    /**
     * Sets a custom attribute for the subclass.
     *
     * This method should be implemented in subclasses to define how
     * the custom attribute is set based on user input from the provided Scanner.
     *
     * @param sc The Scanner used to read input for the custom attribute.
     */
    public abstract void setCustomAttribute(Scanner sc);

    /**
     * Gets the type of the subclass.
     *
     * @return A String repreesenting the type of the object;
     */
    public abstract String getType();

    /**
     * A list of valid sizes for clothing items.
     * Valid sizes include: xs, s, m, l, xl.
     */
    public static List<String> VALID_SIZES = List.of("xs", "s", "m", "l", "xl");

    /**
     * A list of valid item types for clothing.
     * Valid sizes include: jacket, jeans, shoes.
     */
    public static List<String> VALID_ITEM_TYPES = List.of("jacket", "jeans", "shoes");

    /**
     * Constructs a new ClothingItem object with the specified attributes.
     *
     * @param productId The product ID.
     * @param name The name of the product.
     * @param color The color of the product.
     * @param size The size of the product.
     * @param price The price of the product.
     */
    public ClothingItem(String productId, String name, String color, String size, Float price) {
        this.productId = productId;
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    /**
     * Verifies if the provided string is a valid size.
     * A valid size is one that's defined in the {@link VALID_SIZES} list.
     *
     * @param size The size to verify
     * @return true if the size is valid, false otherwise.
     */
    public static boolean isValidSize(String size){
        return VALID_SIZES.contains(size);
    }

    /**
     * Verifies if the provided string is a valid item type.
     * A valid item type is one that's defined in the {@link VALID_ITEM_TYPES} list.
     *
     * @param itemType The item type to verify
     * @return true if the item type is valid, false otherwise.
     */
    public static boolean isValidItemType(String itemType){
        return VALID_ITEM_TYPES.contains(itemType);
    }

    /**
     * Gets the ID of the product
     *
     * @return The product ID.
     */
    public String getProductId() {
        return this.productId;
    }

    /**
     * Gets the name of the product
     *
     * @return The product name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the color of the product
     *
     * @return The product color.
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Gets the size of the product
     *
     * @return The product size.
     */
    public String getSize() {
        return this.size;
    }

    /**
     * Gets the price of the product
     *
     * @return The product price.
     */
    public Float getPrice() {
        return this.price;
    }

    /**
     * Sets the ID of the product
     *
     * @param productId The ID of the product.
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * Sets the name of the product
     *
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the color of the product
     *
     * @param color The color of the product.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Sets the size of the product
     *
     * @param size The size of the product.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Sets the price of the product
     *
     * @param price The price of the product.
     */
    public void setPrice(Float price) {
        this.price = price;
    }

}
