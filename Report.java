package coffeeshopapp;

//Class for items in the final report
public class Report {

	private String id;
	private String itemName;
	private int quantity;
	private double total;
	
	
	public Report(String id, String itemName, int quantity, double income) {
		
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.total = income;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double income) {
		this.total = income;
	}
	
}

