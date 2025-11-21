public class Product {

    //These are the attributes of the product class
    private String id;
    private String name;
    private double price;
    private int quantity;

    //This is the Parameterized Constructor for Product class
    public Product(String id, String name, double price, int quantity){

        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

    }

    //These are the getters and the setters (for the private attributes)
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

    public void setId(String id){
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

    //This is the method that displays the product information
    public void displayInfo(){
        System.out.println("===== Product Information =====");
        System.out.println("  Product ID: " + id);
        System.out.println("  Product Name: " + name);
        System.out.println("  Price: " + price);
        System.out.println("  Quantity: " + quantity);
    }
}

