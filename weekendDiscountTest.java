package coffeeshopapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekendDiscountTest {

	@Test
	void test() {
		Discount discount=new Discount();
		ProcessClass prc=new ProcessClass();
		prc.readOrder();
	    double output=discount.WeekendDiscount(prc.orderlist);
	    assertEquals(20,output);
	}

}
