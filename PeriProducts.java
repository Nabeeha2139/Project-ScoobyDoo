import java.time.LocalDate;  // Shows date without a time-of-day and without a time zone
import java.time.format.DateTimeFormatter;  // Formats and parses the date-time objects to and from strings
import java.time.format.DateTimeParseException; // It is a specific type of exception for parsing 

//The class PeriProducts is the sub-class of the parent class Product
public class PeriProducts extends Product {

    
    private LocalDate expiryDate;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    //This is the parameterized constructor( uses the keyword super to connect the attributes from product )
    public PeriProducts(String id, String name, double price, int quantity, String expiryDate) 
            throws Invalididexception, incorrectDateException {
        super(id, name, price, quantity);
        setExpiryDate(expiryDate);

    }
    
    //This Methord overrides the displays the information in products
    @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("  Expiry Date: " + expiryDate.format(DATE_FORMATTER));
        System.out.println("  Type: Perishable Product");
        System.out.println("  Days until expiry: " + getDaysUntilExpiry());
    }
    

    //These are the setters and getters for the private attributes
    public String getExpiryDate() {
        return expiryDate.format(DATE_FORMATTER);
    }
    public void setExpiryDate(String expiryDate) throws incorrectDateException {
        try {
            LocalDate parsedDate = LocalDate.parse(expiryDate, DATE_FORMATTER);
            LocalDate today = LocalDate.now();
            
            if (parsedDate.isBefore(today)) {
                throw new incorrectDateException("Error: Expiry date cannot be in the past: " + expiryDate);
            }
            
            this.expiryDate = parsedDate;
        } catch (DateTimeParseException e) {
            throw new incorrectDateException("Error: Invalid date format (Please use YYYY-MM-DD format): " + expiryDate);
        }
    } 

    //This Methord gets the days until expiry
    public int getDaysUntilExpiry() {
        return (int) java.time.temporal.ChronoUnit.DAYS.between(LocalDate.now(), expiryDate);
    }
    
    //This Methord checks if the product is expired
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
