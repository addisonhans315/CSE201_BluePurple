public class App {
    private String name;
    private String imagePath;
    private String type;
    private String price;
    private String details;
    private String developer;

    public App(String name, String imagePath, String type, String price, String details, String developer) {
        this.name = name;
        this.imagePath = imagePath;
        this.type = type;
        this.price = price;
        this.details = details;
        this.developer = developer;
    }

    // Getters
    public String getName() { 
    	return name; 
    }
    
    public String getImagePath() { 
    	return imagePath; 
    }
    
    public String getType() { 
    	return type; 	
    }
    
    public String getPrice() { 
    	return price; 
    }
    
    public String getDetails() { 
    	return details; 
    }
    
    public String getDeveloper() { 
    	return developer; 
    }

    @Override
    public String toString() {
        if (price.equals("0.0")) return name + " Free";
    	return name + price;
    }
}
