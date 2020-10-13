package ie.gmit.sw;

import java.time.LocalDate;

interface Order {

	int count();

	Item[] items();

	boolean add(Item i);

	boolean remove(Item i);

	Address getShipTo();

	void setShipTo(Address shipTo);

	String getNumber();

	LocalDate getDate();

}