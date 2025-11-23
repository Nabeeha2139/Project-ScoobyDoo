//This class contains the Product Information
public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    //This is the parameterized constructor
    public Product(String id, String name, double price, int quantity) throws Invalididexception {
        validateId(id);
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    //This methord checkes to see if the Product ID is valid
    private void validateId(String id) throws Invalididexception {
        if (id == null || id.trim().isEmpty()) {
            throw new Invalididexception("Error: Product ID cannot be null or empty");
        }
        if (!id.matches("[A-Za-z0-9-]+")) {
            throw new Invalididexception("Error: Product ID can only contain letters, numbers, and hyphens");
        }
    }

    //These are the setters and getters for the private attributes
    public String getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public double getPrice(){
        return this.price;
    }
    public int getQuantity(){
        return this.quantity;
    }

    public void setId(String id) throws Invalididexception {
        validateId(id);
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    //This methord displays the information
    public void displayInfo(){
        System.out.println("===== Product Information =====");
        System.out.println("  Product ID: " + id);
        System.out.println("  Product Name: " + name);
        System.out.println("  Price: " + price);
        System.out.println("  Quantity: " + quantity);
    }
}
