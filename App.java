package appStore;

import java.util.ArrayList;

public class App {
	// attributes
	private int price;
	private String developer;
	private String name;
	private String type;
	private String logo;  // path to img file
	private ArrayList<Review> reviews;
	
	public App(int price, String developer, String name, String type, String logo, ArrayList<Review> reviews) throws Exception{
		this.price = price;
		if (price < 0) {
			throw new Exception("Invalid price");
		}
		this.developer = developer;
		this.name = name;
		this.type = type;
		this.logo = logo;
		this.reviews = reviews;
		}
	
	// Getters + Setters
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) throws Exception{
		if (price < 0) {
			throw new Exception("Invalid price");
		}
		this.price = price;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public ArrayList<Review> getReviews() {
		return reviews;
	}
	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}
	
	public void addReview(Review review) {
		reviews.add(review);
	}
	
}
