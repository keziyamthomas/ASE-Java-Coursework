package coffeeshopapp;
import java.sql.Timestamp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Order {
	private Timestamp time;
	private String custId;
	private String itemId;
	private int quantity;
	private double amount;
	
	
	public Order(Timestamp time, String custId, String item, int quantity, double amount)throws PatternException {
		
		if(!match(custId)) {
			throw new PatternException("The item Id should have the following pattern: CUST<a 3-digit number> eg.CUST123");
		}
		else
		{
		//Initialize ItemName and amount in addition to the rest of the variables 
		this.time = time;
		this.custId = custId;
		this.itemId=item;
		this.quantity = quantity;
        this.amount = amount;
		}
	}
	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
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
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount(){
        return amount;
    }
	
	//Matching the pattern of Customer Id
	public boolean match(String custId){
		String pattern = "CUST\\d{3}";
		Pattern pat = Pattern.compile(pattern);
		Matcher m = pat.matcher(custId);
		return m.find();
	}

}
