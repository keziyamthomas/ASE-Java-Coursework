package coffeeshopapp;
import java.sql.Timestamp;

public class Order {
	private Timestamp time;
	private String custId;
	private Item item;
	private int quantity;
	private double amount;
	
	public Order(Timestamp time, String custId, Item item, int quantity) {
		
		this.time = time;
		this.custId = custId;
		this.item = item;
		this.quantity = quantity;
		
	}
	
	public Order(Timestamp time, String custId, String item, int quantity, double amount) {
		//Initialize ItemName and amount in addition to the rest of the variables 
		this.time = time;
		this.custId = custId;
		this.item.setItemName(item);
		this.quantity = quantity;
        this.amount = amount;
		
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount(){
        return amount;
    }

}
