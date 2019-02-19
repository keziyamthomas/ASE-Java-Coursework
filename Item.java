package coffeeshopapp;
public class Item {
	private String itemName;
	private String description;
	private double price;
	private String category;
	private String id;
	
	public Item(String itemName, String description, double price, String category, String id) {
		super();
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.category = category;
		this.id = id;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


}
