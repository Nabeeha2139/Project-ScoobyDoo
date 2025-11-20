public class InventoryManager {

    private Product[] products;
    private int productCount;
    private static final int MAX_PRODUCTS = 50;

    public InventoryManager() {
        products = new Product[MAX_PRODUCTS];
        productCount = 0;
    }

    public void addProduct(Product product) {
        if (productCount < MAX_PRODUCTS) {
            products[productCount] = product;
            productCount++;
            System.out.println("Product added.");
        } else {
            System.out.println("Inventory is full."); 
            System.out.println("Cannot add more products.");
        }
    }

    public void viewProducts() {
        if (productCount == 0) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("===== All Products In Inventory =====");
        for (int i = 0; i < productCount; i++) {
            products[i].displayInfo();
            System.out.println();
        }
    }

    public void updateProduct(String productId, double newPrice, int newQuantity) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getId().equals(productId)) {
                products[i].setPrice(newPrice);
                products[i].setQuantity(newQuantity);
                System.out.println("Product updated.");
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found.");
    }

    public void deleteProduct(String productId) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getId().equals(productId)) {
                // Shift elements to remove the product
                for (int j = i; j < productCount - 1; j++) {
                    products[j] = products[j + 1];
                }
                products[productCount - 1] = null;
                productCount--;
                System.out.println("Product deleted.");
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found.");
    }

    public void searchProduct(String productId) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].getId().equals(productId)) {
                System.out.println("Product found:");
                products[i].displayInfo();
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found.");
    }

    public int getProductCount() {
        return productCount;
    }
}