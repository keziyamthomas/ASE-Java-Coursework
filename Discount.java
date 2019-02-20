package coffeeshopapp;

public class Discount {
	private double discount = 0.0;
	//Reference - http://www.java67.com/2016/12/how-to-get-current-day-month-year-from-date-in-java8.html
	
	//Method to calculate discount
	public double calculateDiscount(double cost,List<Order> list) {
		//taking current day to decide on the type of discount
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		int day = c.get(Calendar.DAY_OF_WEEK);
		if(day == 6 && day == 7 )
			discount = WeekendDiscount(cost,list);
		else 
			discount = WeekdayDiscount(cost);
		return discount;
	}
	
	//Method to calculate discount if its a weekday
	public double WeekdayDiscount(double cost){
		if(cost > 100 && cost <= 199) {
			discount = 0.01 * cost;
		}
		else if(cost > 200 && cost <= 299) {
			discount = 0.02 * cost;
		}
		else if(cost >= 300) {
			discount = 0.03 * cost;
		}
		return discount;
	}
	//Method to calculate discount if it is weekend
	public double WeekendDiscount(double cost,List<Order> list) {
		/*if(cost > 150 ) 
		{
			discount=0.03*cost;
		}
		else if (cost>200) {
			discount=0.05*cost;	
		}*/
		return discount;
	}
}
