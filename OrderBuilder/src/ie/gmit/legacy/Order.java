package ie.gmit.legacy;

import java.util.*;
public class Order {
	private static final int MAX_LINEITEMS = 100;
	private Item[] items;
	private String orderNumber = null;
	private Date orderDate = new Date();
	private Address address;

	//Null constructor
	public Order(){
		items = new Item[Order.MAX_LINEITEMS];
	}

	//Overloaded constructor
	public Order(String orderNumber){
		this(); //Call null constructor
		this.orderNumber = orderNumber;
	}

	//Find a blank position in the items array
	private int getInsertPosition(){
		for (int i = 0; i < Order.MAX_LINEITEMS; i++){
			if (items[i] == null){
				return i;
			}
		}

		return -1;
	}

  	//Return the number of line items in items array
  	public short count(){
		short counter = 0;
		for (short i = 0; i < Order.MAX_LINEITEMS; i++){
			if (items[i] != null){
				counter++;
			}
		}
		return counter;
	}

  	//Simplified interface for clients to add a line item
  	public void addItem(String part, String description, int qty, float price) throws OrderException{
  			Item item = new Item();
			item.partNumber(part);
			item.partDescription(description);
			item.quantity(qty);
			item.price(price);
			add(item);
	}

  	//More complex interface for clients to add an item.
  	public void add(Item item) throws OrderException{
		System.out.println("\t" + item.partNumber() + " added");
		if (getInsertPosition() == -1){
			throw new OrderException("This order has reached its line item quota.");
		}else{
			items[getInsertPosition()] = item;
		}

	}

  	//Remove line item from the items array
  	public void remove (Item item) throws OrderException{
		for (int i = 0; i < Order.MAX_LINEITEMS; i++){
			if (items[i] != null){
				Item currentItem = items[i];
				if (currentItem.partNumber().equals(item.partNumber())){
					System.out.println("\n\t" + item.partNumber() + " removed.");
					items[i] = null;
					return;
				}
			}
		}

		throw new OrderException("Cannot find specified line item..");
	}

  	//Return the line item at the specified position in the items array
  	public Item get (int index) throws OrderException{
		if (items[index] == null){
			throw new OrderException("Incorrect ordinal reference specified.");
		}else{
			return items[index];
		}
	}

	//returns the items array
	public Item[] items (){
		return items;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}