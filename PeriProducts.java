//The PeriProduct class is an extention of the product that takes separate information for products that are perishiable
public class PeriProducts extends Product {

    private String expiryDate;
    
    public PeriProducts(String id, String name, double price, int quantity, String expiryDate) {
        super(id, name, price, quantity);
        this.expiryDate = expiryDate;
    }
    
    //This method overrides the displayInfo method in the product class (it adds the expiration date to the product)
    @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("  Expiry Date: " + expiryDate);
        System.out.println("  Type: Perishable Product");
    }
    
    //These are the getters and the setters (for the private attributes)
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}

