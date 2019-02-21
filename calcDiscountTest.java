package coffeeshopapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

//Test for calculateDiscount() Method in Discount class

class calcDiscountTest {

	@Test
	void test() {
		
		Discount discount=new Discount();
		ProcessClass prc=new ProcessClass();
		prc.readOrder();
	    double output=discount.calculateDiscount(300,prc.orderlist);
	    assertEquals(20,output);
		
	}

}
