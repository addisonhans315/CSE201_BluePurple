public class App {
	// attributes
	private int price;
	private String developer;
	private String name;
	private String type;
	private String logo; // path to img file

	public App(int price, String developer, String name, String type, String logo) {
		this.price = price;
		this.developer = developer;
		this.name = name;
		this.type = type;
		this.logo = logo;
	}

	// Getters + Setters
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
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

}
