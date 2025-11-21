public class InventoryManager {

    private Product[] products;
    private int productCount;
    private static final int MAX_PRODUCTS = 50;

    //This methord keeps the number of products in the inventory in check (Max number of product is 50)
    public InventoryManager() {
        products = new Product[MAX_PRODUCTS];
        productCount = 0;
    }

    //This methord adds a new product and checks if the inventory is full
    public void addProduct(Product product) {
        System.out.println();
        if (productCount < MAX_PRODUCTS) {
            products[productCount] = product;
            productCount++;
            System.out.println("Product added.");
        } else {
            System.out.println("Inventory is full."); 
            System.out.println("Cannot add more products.");
        }
    }

    //This methord views products and if the inventory is empty
    public void viewProducts() {
        System.out.println();
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

    //This methord updates the products (its ID, Price and Quantity)
    public void updateProduct(String productId, double newPrice, int newQuantity) {
        System.out.println();
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

    //This methord deletes the product
    public void deleteProduct(String productId) {
        System.out.println();
        for (int i = 0; i < productCount; i++) {
            if (products[i].getId().equals(productId)) {
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

    //This methord searches individual products
    public void searchProduct(String productId) {
        System.out.println();
        for (int i = 0; i < productCount; i++) {
            if (products[i].getId().equals(productId)) {
                System.out.println("Product found:");
                products[i].displayInfo();
                return;
            }
        }
        System.out.println("Product with ID " + productId + " not found.");
    }

    //This methord gets the product count
    public int getProductCount() {
        return productCount;
    }
}
