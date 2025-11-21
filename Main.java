import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static InventoryManager inventory = new InventoryManager();

    public static void main(String[] args) {
        System.out.println("Welcome to Inventory Management System!");
        
        int choice;
        do {
            System.out.println();
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    deleteProduct();
                    break;
                case 5:
                    searchProduct();
                    break;
                case 6:
                    System.out.println("Thank you for using Inventory Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
        
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println();
        System.out.println("====== Inventory Management System ======");
        System.out.println("1. Add Product");
        System.out.println("2. View All Products");
        System.out.println("3. Update Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Search Product by ID");
        System.out.println("6. Exit");
        System.out.println();
    }

    private static void addProduct() {
        System.out.println();
        System.out.println("----- Add New Product -----");
        
        System.out.print("Enter Product ID: ");
        String productId = scanner.nextLine();
        
        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();
        
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Is this a perishable product? (y/n): ");
        String isPerishable = scanner.nextLine();
        
        if (isPerishable.equalsIgnoreCase("y")) {
            System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
            String expiryDate = scanner.nextLine();
            
            PeriProducts perishableProduct = new PeriProducts(productId, productName, price, quantity, expiryDate);
            inventory.addProduct(perishableProduct);
        } else {
            Product product = new Product(productId, productName, price, quantity);
            inventory.addProduct(product);
        }
    }

    private static void viewAllProducts() {
        System.out.println();
        System.out.println("----- View All Products -----");
        inventory.viewProducts();
    }

    private static void updateProduct() {
        System.out.println();
        System.out.println("----- Update Product -----");
        
        System.out.print("Enter Product ID to update: ");
        String productId = scanner.nextLine();
        
        System.out.print("Enter new Price: ");
        double newPrice = scanner.nextDouble();
        
        System.out.print("Enter new Quantity: ");
        int newQuantity = scanner.nextInt();
        scanner.nextLine(); 
        
        inventory.updateProduct(productId, newPrice, newQuantity);
    }

    private static void deleteProduct() {
        System.out.println();
        System.out.println("----- Delete Product -----");
        
        System.out.print("Enter Product ID to delete: ");
        String productId = scanner.nextLine();
        
        inventory.deleteProduct(productId);
    }

    private static void searchProduct() {
        System.out.println();
        System.out.println("----- Search Product -----");
        
        System.out.print("Enter Product ID to search: ");
        String productId = scanner.nextLine();
        
        inventory.searchProduct(productId);
    }
}
