import java.util.Scanner; //Scanner import lets the user enter 
import java.util.InputMismatchException;  //This is a runtime exception error for scanner

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static InventoryManager inventory = new InventoryManager();

    public static void main(String[] args) {
        System.out.println("Welcome to Inventory Management");
        
        int choice;
        do {
            System.out.println();
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = getIntInput();
            
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
                    System.out.println("Thank you for using Inventory Management System");
                    break;
                default:
                    System.out.println("Error: Please enter a number between 1-6.");
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
        try {
            System.out.println();
            System.out.println("----- Add New Product -----");
            
            System.out.print("Enter Product ID: ");
            String productId = scanner.nextLine().trim();
            if (productId.isEmpty()) {
                System.out.println("Error: Product ID cannot be empty");
                return;
            }
            
            System.out.print("Enter Product Name: ");
            String productName = scanner.nextLine().trim();
            if (productName.isEmpty()) {
                System.out.println("Error: Product Name cannot be empty");
                return;
            }
            
            System.out.print("Enter Price: ");
            double price = getDoubleInput();
            if (price < 0) {
                System.out.println("Error: Price cannot be negative");
                return;
            }
            
            System.out.print("Enter Quantity: ");
            int quantity = getIntInput();
            if (quantity < 0) {
                System.out.println("Error: Quantity cannot be negative");
                return;
            }
            
            System.out.print("Is this a perishable product? (y/n): ");
            String isPerishable = scanner.nextLine().trim();
            
            if (isPerishable.equalsIgnoreCase("y")) {
                System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                String expiryDate = scanner.nextLine().trim();
                if (expiryDate.isEmpty()) {
                    System.out.println("Error: Expiry date cannot be empty for perishable products");
                    return;
                }
                
                try {
                    PeriProducts perishableProduct = new PeriProducts(productId, productName, price, quantity, expiryDate);
                    inventory.addProduct(perishableProduct);
                    System.out.println("Perishable product added.");
                } catch (incorrectDateException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Invalididexception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else if (isPerishable.equalsIgnoreCase("n")) {
                try {
                    Product product = new Product(productId, productName, price, quantity);
                    inventory.addProduct(product);
                    System.out.println("Product added.");
                } catch (Invalididexception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("Error: Please enter 'y' for yes or 'n' for no");
                return;
            }
            
        } catch (Exception e) {
            System.out.println("Unexpected error occurred while adding product: " + e.getMessage());
        }
    }
    
    private static void viewAllProducts() {
        try {
            System.out.println();
            System.out.println("----- View All Products -----");
            inventory.viewProducts();
        } catch (Exception e) {
            System.out.println("Error occurred while viewing products: " + e.getMessage());
        }
    }

    private static void updateProduct() {
        try {
            System.out.println();
            System.out.println("----- Update Product -----");
            
            System.out.print("Enter Product ID to update: ");
            String productId = scanner.nextLine().trim();
            if (productId.isEmpty()) {
                System.out.println("Error: Product ID cannot be empty");
                return;
            }
            
            System.out.print("Enter new Price: ");
            double newPrice = getDoubleInput();
            if (newPrice < 0) {
                System.out.println("Error: Price cannot be negative");
                return;
            }
            
            System.out.print("Enter new Quantity: ");
            int newQuantity = getIntInput();
            if (newQuantity < 0) {
                System.out.println("Error: Quantity cannot be negative");
                return;
            }
            
            inventory.updateProduct(productId, newPrice, newQuantity);
            
        } catch (Exception e) {
            System.out.println("Error occurred while updating product: " + e.getMessage());
        }
    }

    private static void deleteProduct() {
        try {
            System.out.println();
            System.out.println("----- Delete Product -----");
            
            System.out.print("Enter Product ID to delete: ");
            String productId = scanner.nextLine().trim();
            if (productId.isEmpty()) {
                System.out.println("Error: Product ID cannot be empty");
                return;
            }
            
            inventory.deleteProduct(productId);
            
        } catch (Exception e) {
            System.out.println("Error occurred while deleting product: " + e.getMessage());
        }
    }

    private static void searchProduct() {
        try {
            System.out.println();
            System.out.println("----- Search Product -----");
            
            System.out.print("Enter Product ID to search: ");
            String productId = scanner.nextLine().trim();
            if (productId.isEmpty()) {
                System.out.println("Error: Product ID cannot be empty");
                return;
            }
            
            inventory.searchProduct(productId);
            
        } catch (Exception e) {
            System.out.println("Error occurred while searching product: " + e.getMessage());
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine(); 
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Error: Invalid input (Please enter a valid integer): ");
                scanner.nextLine(); 
            }
        }
    }

    private static double getDoubleInput() {
        while (true) {
            try {
                double input = scanner.nextDouble();
                scanner.nextLine(); 
                return input;
            } catch (InputMismatchException e) {
                System.out.print("Error: Invalid input (Please enter a valid number): ");
                scanner.nextLine(); 
            }
        }
    }
}

