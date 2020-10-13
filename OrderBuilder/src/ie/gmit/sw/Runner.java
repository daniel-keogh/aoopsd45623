package ie.gmit.sw;

public class Runner {
	public static void main(String[] args) {
		OrderBuilderFactory factory = OrderBuilderFactory.getInstance();
		Order order = factory.newOrderBuilder("A1-123")
				.with("978-1447269045", "Seek the Fair Land", 2, 22.99f)
				.with("978-0330303286", "The Silent People", 1, 22.99f)
				.with("978-0330303262", "The Scorching Wind", 1, 55.85f)
				.with("978-0330397872", "Flight of the Doves", 4, 26.47f)
				.with("978-1447269205", "Rain on the Wind", 4, 22.99f)
				.with(new Address("Walter Macken Road", "Mervue", County.Galway, "AAA1915"))
				.build();

		Item[] items = order.items();
		for (Item item : items) {
			System.out.println("Part number: " + item.number());
			System.out.println("Part description: " + item.description());
			System.out.println("Quantity: " + item.quantity());
			System.out.println("Price: " + item.price());
			System.out.println();
		}
	}
}