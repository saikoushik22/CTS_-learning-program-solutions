import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Product[] products = {
                new Product(301, "Notebook", "Stationery"),
                new Product(215, "T-Shirt", "Apparel"),
                new Product(102, "Mouse", "Electronics")
        };

        System.out.println("🔍 Linear Search:");
        int linearResult = ProductSearch.linearSearch(products, 215);
        if (linearResult != -1) {
            System.out.println("Product found: " + products[linearResult].getProductName());
        } else {
            System.out.println("Product not found.");
        }

        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        System.out.println("\n🔍 Binary Search:");
        int binaryResult = ProductSearch.binarySearch(products, 215);
        if (binaryResult != -1) {
            System.out.println("Product found: " + products[binaryResult].getProductName());
        } else {
            System.out.println("Product not found.");
        }
    }
}
