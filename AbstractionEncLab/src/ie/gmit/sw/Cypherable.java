package ie.gmit.sw;

public interface Cypherable {

	public abstract CypherKey getCypherKey();
	public abstract void setCypherKey(CypherKey key);
	
	public abstract byte[] encrypt(byte[] plainText) throws CypherException;
	public abstract byte[] decrypt(byte[] cypherText) throws CypherException;
	
	public default String encrypt(String plainText) throws CypherException {
		return new String(encrypt(plainText.getBytes()));
	}
	
	public default String decrypt(String cypherText) throws CypherException {
		return new String(decrypt(cypherText.getBytes()));
	}
}