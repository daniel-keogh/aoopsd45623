package ie.gmit.sw;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class SymmetricCypher extends AbstractCypher {

	private Key key;

	// "AES", 128, "AES/ECB/PKCS5Padding"
	public SymmetricCypher(String algorithm, int keySize, String padding) throws Throwable {
		KeyGenerator keyGen = KeyGenerator.getInstance(algorithm);
		keyGen.init(keySize);
		this.setKey(keyGen.generateKey());
		super.setCypher(Cipher.getInstance(padding));
	}

	@Override
	public byte[] encrypt(byte[] plainText) throws Throwable {
		return this.encrypt(plainText, getKey());
	}

	@Override
	public byte[] decrypt(byte[] cypherText) throws Throwable {
		return this.decrypt(cypherText, getKey());
	}

	protected Key getKey() {
		return key;
	}

	protected void setKey(Key key) {
		this.key = key;
	}

}