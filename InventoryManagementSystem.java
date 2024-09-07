import java.util.*;

public class InventoryManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Inventory inventory = new Inventory();
    private static UserManager userManager = new UserManager();

    public static void main(String[] args) {
        userManager.registerUser("admin", "admin123", "admin"); // Default admin user

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            User user = userManager.authenticateUser(username, password);
            if (user != null) {
                if (user.getRole().equalsIgnoreCase("admin")) {
                    adminMenu();
                } else if (user.getRole().equalsIgnoreCase("staff")) {
                    staffMenu();
                }
            } else {
                System.out.println("Invalid credentials. Please try again.");
            }
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Inventory");
            System.out.println("5. Generate Report");
            System.out.println("6. Add User");
            System.out.println("7. Logout");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    inventory.viewInventory();
                    break;
                case 5:
                    inventory.generateReport();
                    break;
                case 6:
                    addUser();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void staffMenu() {
        while (true) {
            System.out.println("\nStaff Menu:");
            System.out.println("1. View Inventory");
            System.out.println("2. Logout");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    inventory.viewInventory();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter product price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Product product = new Product(name, quantity, price);
        inventory.addProduct(product);
        System.out.println("Product added successfully!");
    }

    private static void updateProduct() {
        System.out.print("Enter product name to update: ");
        String name = scanner.nextLine();
        Product product = inventory.getProduct(name);

        if (product != null) {
            System.out.print("Enter new quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new price: ");
            double price = Double.parseDouble(scanner.nextLine());

            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void deleteProduct() {
        System.out.print("Enter product name to delete: ");
        String name = scanner.nextLine();
        boolean success = inventory.deleteProduct(name);

        if (success) {
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    private static void addUser() {
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();
        System.out.print("Enter new password: ");
        String password = scanner.nextLine();
        System.out.print("Enter role (admin/staff): ");
        String role = scanner.nextLine();

        boolean success = userManager.registerUser(username, password, role);

        if (success) {
            System.out.println("User added successfully!");
        } else {
            System.out.println("User already exists!");
        }
    }
}
