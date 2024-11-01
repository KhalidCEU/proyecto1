package products;

import java.io.Serializable;
import java.util.List;

public abstract class ClothingItem implements Serializable {
    private String productId;
    private String name;
    private String color;
    private String size;
    private Float price;

    public static List<String> VALID_SIZES = List.of("xs", "s", "m", "l", "xl");
    public static List<String> VALID_ITEM_TYPES = List.of("jacket", "jeans", "shoes");


    public ClothingItem(String productId, String name, String color, String size, Float price) {
        this.productId = productId;
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public static boolean isValidSize(String size){
        return VALID_SIZES.contains(size);
    }

    public static boolean isValidItemType(String itemType){
        return VALID_ITEM_TYPES.contains(itemType);
    }

    public String getProductId() {
        return this.productId;
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public String getSize() {
        return this.size;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

}
