package ie.gmit.legacy;

public class Item {
	private String partNumber = null;
	private String partDescription = null;
	private int quantity = 0;
	private float price = 0.00f;

	public Item(){};

	public Item(String part, String description, int qty, float price){
		this.partNumber = part;
		this.partDescription = description;
		this.quantity = qty;
		this.price = price;
	}

	public String partNumber (){
		return this.partNumber;
	}

	public void partNumber (String newPartNumber){
		this.partNumber = newPartNumber;
	}

	public String partDescription (){
		return this.partDescription;
	}

	public void partDescription (String newPartDescription){
		this.partDescription = newPartDescription;
	}

	public int quantity (){
		return this.quantity;
	}

	public void quantity (int newQuantity){
		this.quantity = newQuantity;
	}

	public float price (){
		return this.price;
	}

	public void price (float newPrice){
		this.price = newPrice;
	}
}
