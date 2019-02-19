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
	
	public LinkedList<Order> getOrderList(){
		return orderlist;
	}
	 
	public HashMap<String,Report> getReportList(){
		return reportlist;
	}
	
	public HashMap<String,Item> getItemList(){
		return itemlist;
	}
	
	public void addOrder(Order order) {
		orderlist.add(order);
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
				String[] parts = text.split(",");
				String name = parts[0];
				String desc = parts[1];
				double price = Double.parseDouble(parts[2]);
				String category = parts[3];
				String id = parts[4];
				
				//Adding all menu items into itemList Hash Map
				Item item = new Item(name,desc,price,category,id);
				itemlist.put(id, item);
				
				//Adding all menu items into reportList Hash Map with initial quantity and income as 0
				Report rpt = new Report(id,name,0,0.0);
				reportlist.put(id,rpt);
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
	
	public List<String> getItemsByCategory(String category) {
		List<String> items = new ArrayList<String>();
		for(Map.Entry<String, Item> entry: itemlist.entrySet()) {
			if(category.equals(entry.getValue().getItemName())) {
				items.add(entry.getValue().getItemName());
			}
		}
		return items;
	}

}
