import java.util.*;

public class Inventory {
    private Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public boolean deleteProduct(String name) {
        return products.remove(name) != null;
    }

    public void viewInventory() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }

        System.out.println("\nInventory:");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    public void generateReport() {
        System.out.println("\nInventory Report:");
        for (Product product : products.values()) {
            System.out.println(product);
        }
        // You can extend this method to generate more detailed reports
    }
}
