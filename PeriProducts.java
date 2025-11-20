public class PeriProducts extends Product {

    private String expiryDate;
    
    public PeriProducts(String id, String name, double price, int quantity, String expiryDate) {
        super(id, name, price, quantity);
        this.expiryDate = expiryDate;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("  Expiry Date: " + expiryDate);
        System.out.println("  Type: Perishable Product");
    }
    
    public String getExpiryDate() {
        return expiryDate;
    }
    
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}

