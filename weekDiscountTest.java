package coffeeshopapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class weekDiscountTest {

	@Test
	void test() {

       Discount discount=new Discount();
       double output=discount.WeekdayDiscount(400);
       assertEquals(120,output);
	}

}
