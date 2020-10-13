package ie.gmit.legacy;


public class Runner {

	public static void main(String[] args) throws OrderException{
		Order order = new Order("AA-123");

		order.addItem("978-1447269045", "Seek the Fair Land", 2, 22.99f);
		order.addItem("978-0330303286", "The Silent People", 1, 22.99f);
		order.addItem("978-0330303262", "The Scorching Wind", 1, 55.85f);
		order.addItem("978-0330397872", "Flight of the Doves", 4, 26.47f);
		order.addItem("978-1447269205", "Rain on the Wind", 4, 22.99f);
		
		Address address = new Address("Walter Macken Road", "Mervue", County.Galway, "AAA1915");
		order.setAddress(address);

		Item[] items = order.items();
		for (Item item : items) {
			if (item == null) break;
			System.out.println("Part number: " + item.partNumber());
			System.out.println("Part description: " + item.partDescription());
			System.out.println("Quantity: " + item.quantity());
			System.out.println("Price: " + item.price());
			System.out.println();
		}
	}
}
