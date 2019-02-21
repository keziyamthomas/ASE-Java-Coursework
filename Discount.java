package coffeeshopapp;

import java.util.Date;
import java.util.Calendar;
import java.util.LinkedList;



public class Discount {
	private double discount = 0.0;
	//Reference - http://www.java67.com/2016/12/how-to-get-current-day-month-year-from-date-in-java8.html
	
	//Method to calculate discount
	public double calculateDiscount(double cost,LinkedList<Order> orderlist) {
		//taking current day to decide on the type of discount
		Date today = new Date( );
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		System.out.println(today);
		int day = c.get(Calendar.DAY_OF_WEEK);
		if(day == 6 || day == 7 )
			discount = WeekendDiscount(orderlist);
		else 
			discount = WeekdayDiscount(cost);
		return discount;
	}
	
	//Method to calculate discount if its a weekday
	public double WeekdayDiscount(double cost){
		if(cost > 100 && cost <= 199) {
			discount = 0.1 * cost;
		}
		else if(cost > 200 && cost <= 299) {
			discount = 0.2 * cost;
		}
		else if(cost >= 300) {
			discount = 0.3 * cost;
		}
		return discount;
	}
	//Method to calculate discount if it is weekend
	public double WeekendDiscount(LinkedList<Order> orderlist) {
		
		 int discount=0;
		 int bit=0;
		 int shk=0;
		 int ccd=0;
		 int hot=0;
		 
		 for(Order o:orderlist)
	        {
	        
	        	String code=o.getItemId().substring(0,3);
	        	
	        	switch(code)
	        	{
	        	case "BIT":
	        		bit=bit+o.getQuantity();
	        		break;
	        	case "SHK":	
	        		shk=shk+o.getQuantity();
	        		break;
	        	case "HOT":
	        		hot=hot+o.getQuantity();
	        		break;
	        	case "CCD":
	        		ccd=ccd+o.getQuantity();
	        		break;
	        	default:
	        		break;
	        	}
	            
	        }
		 
		 for(int i=ccd;i>=4;i=i-4)
		 {
			 discount=discount+10;
			 ccd=ccd-4;
		 }
		 for(int i=hot;i>=4;i=i-4)
		 {
			 discount=discount+10;
			 hot=hot-4;
		 }
		 for(int i=shk;i>=4;i=i-4)
		 {
			 discount=discount+10;
			 shk=shk-4;
		 }
		 for(int i=shk+hot+ccd,j=bit;i>=3&&j>=2;i=i-3,j=j-2)
		 {
		   discount=discount+10;
		   
		 }
		 
		return discount;
	}
}

