import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class ProcessClass {
	public HashMap<String,Item> itemlist = new HashMap<String,Item>();
	public LinkedList<Order> orderlist = new LinkedList<Order>();
	
	public void readItems() {
		Scanner scan;
		String itemfile = "Item.csv";
		File file =new File(itemfile);
		String text;
		try {
			scan = new Scanner(file);
			while(scan.hasNextLine()) {
				text = scan.nextLine();
				String[] parts = text.split(",");
				String name = parts[0];
				String desc = parts[1];
				Double price = Double.parseDouble(parts[2]);
				String category = parts[3];
				String id = parts[4];
				Item item = new Item(name,desc,price,category,id);
				itemlist.put(id, item);
				
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			System.out.println("");
		}
	}
	public void readOrder() {
		Scanner scan;
		String orderfile = "Order.csv";
		File file =new File(orderfile);
		try {
			scan = new Scanner(file);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			System.out.println("");
		}
	}
			

}
