package coffeeshopapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class ProcessClass {
	public HashMap<String,Item> itemlist = new HashMap<String,Item>();
	public HashMap<String,Report> reportlist = new HashMap<String,Report>();
	public LinkedList<Order> orderlist = new LinkedList<Order>();
	
	//This method will return the LinkedList of Orders
	public LinkedList<Order> getOrderList(){
		return orderlist;
	}
	 
	//This method will return HashMap of Report
	public HashMap<String,Report> getReportList(){
		return reportlist;
	}
	
	//This method will return HashMap of Items
	public HashMap<String,Item> getItemList(){
		return itemlist;
	}
	
	/* The readItems() method will read the items from Items.csv and add them to the hashmap ItemList */
	public void readItems(){
		Scanner scan;
		String itemfile = "Items.csv";
		File file =new File(itemfile);
		String text;
		try {
			scan = new Scanner(file);
			while(scan.hasNextLine()) {
				text = scan.nextLine();
				try {
					//splitting each line using , as delimiter
					String[] parts = text.split(",");
					String name = parts[0];
					String desc = parts[1];
					double price = Double.parseDouble(parts[2]);
					String category = parts[3];
					String id = parts[4];
					
					String pattern = "BIT|HOT|SHK|CCD\\d{3}";
					Pattern pat = Pattern.compile(pattern);
					Matcher m = pat.matcher(id);
					if(!m.find()){
						throw new PatternException("Incorrect Id: " + id +" in Items.csv. The item Id should have the following pattern:<BIT/HOT/SHK/CCD><3-digit number> eg:BIT123, HOT123, SHK123, CCD123");
					}
					Item item = new Item(name,desc,price,category,id);
					itemlist.put(id, item);
					
					Report rpt = new Report(id,name,0,0.0);
					reportlist.put(id,rpt);
					}
					catch(PatternException pe) {
						JOptionPane.showMessageDialog(null, pe.getMessage());
					}
					//catches exception in parsing string to integers
					catch(NumberFormatException e) {
						e.printStackTrace();
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
					finally {
						continue;
					}
				}
			scan.close();
		}
		catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Method to read items from Order.csv and insert them to LinkedList
	
	public void readOrder(){
		Scanner scan;
		String orderfile = "Order.csv";
		File file =new File(orderfile);
		String text;
		try {
			scan = new Scanner(file);
			while(scan.hasNextLine()) {
				text=scan.nextLine();
				try {
					//splitting each line of the file to store in different variables
					String[] parts = text.split(",");
					String time = parts[0];
					SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY hh:mm");
					Date date = format.parse(time);
					Timestamp ts = new Timestamp(date.getTime());
					String id = parts[1];
					
					//checking pattern of Customer Id
					String pattern = "CUST\\d{3}";
					Pattern pat = Pattern.compile(pattern);
					Matcher m = pat.matcher(id);
					if(!m.find()) {
						throw new PatternException("The item Id should have the following pattern: CUST<a 3-digit number> eg.CUST123");
					}
					
					String itemid = parts[2];
					int quantity = Integer.parseInt(parts[3]);
					double amount = Double.parseDouble(parts[4]);
					Order order = new Order(ts,id,itemid,quantity,amount);
					orderlist.add(order);
				}
				catch(PatternException pe) {
					JOptionPane.showMessageDialog(null, pe.getMessage());
				}
				catch(NumberFormatException e) {
					e.printStackTrace();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				finally {
					continue;
				}
			}
			scan.close();
		}
		catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//This method appends new orders with existing orders
	public void addOrder(LinkedList<Order> list) {
		orderlist.addAll(list);
	}
	
	
	//Reference-http://resources.mpi-inf.mpg.de/d5/teaching/ss05/is05/javadoc/java/util/HashMap.Entry.html
	// Get the list of items in a particular Category
	public List<String> getItemsByCategory(String category) {
		List<String> items = new ArrayList<String>();
		for(Map.Entry<String, Item> entry: itemlist.entrySet()) {
			if(category.equals(entry.getValue().getCategory())) {
				items.add(entry.getValue().getItemName());
			}
		}
		return items;
	}
	
	//Get the unit price of an item based on the name
	public double getUnitPriceByItemName(String itemName) {
		double unitPrice=0.0;
		for(Map.Entry<String, Item> entry: itemlist.entrySet()){
			if(itemName.equals(entry.getValue().getItemName())) {
				unitPrice = entry.getValue().getPrice();
			}
		}
		return unitPrice;
	}

}
