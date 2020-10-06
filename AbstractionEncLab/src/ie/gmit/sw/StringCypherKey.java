package ie.gmit.sw;

public class StringCypherKey implements CypherKey {

	private String key;

	public StringCypherKey(String key) {
		super();
		this.key = key;
	}
	
	@Override
	public void setPattern(String key) throws CypherException {
		// CaesarCypher.this.key // Refers to the containers instance variable
		this.key = key; // Refers to the inner class instance variable
	}

	@Override
	public String getPattern() {
		return "" + key;
	}
}