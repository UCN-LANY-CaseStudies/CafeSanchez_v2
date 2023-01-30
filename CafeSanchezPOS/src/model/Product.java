package model;

public class Product {
	
	private int id;
	private String name;
	private String description;
	private float price;

	public Product(int id, String name, String description, float price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public float getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return name + " - " + price;
	}
}
