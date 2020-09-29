package ie.gmit.sw;

@SuppressWarnings("preview")
public record Person(int id) {

	@Override
	protected void finalize() throws Throwable {
		System.out.println(this + " ==> " + this.id());
	}

}
