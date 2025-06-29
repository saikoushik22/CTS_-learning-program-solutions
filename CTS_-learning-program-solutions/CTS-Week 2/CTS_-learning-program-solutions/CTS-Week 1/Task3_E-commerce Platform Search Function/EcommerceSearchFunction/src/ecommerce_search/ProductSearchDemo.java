package ecommerce_search;

import java.util.Arrays;
import java.util.Comparator;

public class ProductSearchDemo {

    public static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.productId == id) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int id) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productId == id) return products[mid];
            if (products[mid].productId < id) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Laptop", "Electronics"),
            new Product(101, "Shoes", "Footwear"),
            new Product(102, "Shirt", "Apparel"),
            new Product(103, "Phone", "Electronics")
        };

        System.out.println("Linear Search Result: " + linearSearch(products, 103));

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        System.out.println("Binary Search Result: " + binarySearch(products, 103));
    }
}