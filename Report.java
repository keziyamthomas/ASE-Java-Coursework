
public class Report {

	private String id;
	private String itemName;
	private int quantity;
	private double income;
	
	
	public Report(String id, String itemName, int quantity, double income) {
		
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.income = income;
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



	public double getIncome() {
		return income;
	}



	public void setIncome(double income) {
		this.income = income;
	}
	
}

