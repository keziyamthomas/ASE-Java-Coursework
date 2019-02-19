import java.sql.Timestamp;

public class Order {
	private Timestamp time;
	private String custId;
	private Item item;
	private int quantity;
	
	public Order(Timestamp time, String custId, Item item, int quantity) {
		
		this.time = time;
		this.custId = custId;
		this.item = item;
		this.quantity = quantity;
		
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

}
