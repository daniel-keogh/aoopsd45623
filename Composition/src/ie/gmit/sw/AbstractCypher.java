package ie.gmit.sw;

import java.security.Key;

import javax.crypto.Cipher;

public abstract class AbstractCypher implements Cypherable {

	private Cipher cypher;

	public AbstractCypher() {
		super();
	}

	public abstract byte[] encrypt(byte[] plainText) throws Throwable;
	
	public byte[] encrypt(byte[] plainText, Key key) throws Throwable {
		getCypher().init(Cipher.ENCRYPT_MODE, key);
		return getCypher().doFinal(plainText);
	}

	public abstract byte[] decrypt(byte[] cypherText) throws Throwable;
	
	public byte[] decrypt(byte[] cypherText, Key key) throws Throwable {
		getCypher().init(Cipher.DECRYPT_MODE, key);
		return getCypher().doFinal(cypherText);
	}

	protected Cipher getCypher() {
		return cypher;
	}

	protected void setCypher(Cipher cypher) {
		this.cypher = cypher;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
	}
}