package coffeeshopapp;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class processClassTest {
	static ProcessClass processClass;
	static String item1="Falooda";
	static String item2="Pasta";
	static String item3="Coffee";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		processClass=new ProcessClass();
		
	}

	
	@Test()
	public final void test() {
		double out=25.0;
		processClass.readItems();
		Assert. assertEquals(out,processClass.getUnitPriceByItemName(item1));
		
		
	}
	@Test
	public final void test2() {
		double out=30.0;
		processClass.readItems();
		Assert.assertEquals(out,processClass.getUnitPriceByItemName(item2));
				
	}
	@Test
	public final void test3() {
		double out=20.0;
		processClass.readItems();
		Assert.assertEquals(out,processClass.getUnitPriceByItemName(item3));
				
	}
	
	


	

}
