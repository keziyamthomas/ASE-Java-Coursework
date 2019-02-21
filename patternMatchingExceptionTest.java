package coffeeshopapp;


import coffeeshopapp.PatternException;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;
class patternMatchingExceptionTest {

	@Test(expected=PatternException.class)
	void testException() throws PatternException
	{
		Date date=new Date();
		Timestamp ts = new Timestamp(date.getTime());
		Order order=new Order(ts,"EMP001", "BIT001", 2, 25.00);
	}

}
