package ie.gmit.sw;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;

public class RSACypher extends AbstractCypher {
	private KeyPair keyRing;

	public RSACypher() throws Throwable {
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		keyGen.initialize(2048);
		keyRing = keyGen.generateKeyPair();
		super.setCypher(Cipher.getInstance("RSA/ECB/PKCS1Padding"));
	}

	@Override
	public byte[] encrypt(byte[] plainText) throws Throwable {
		return super.encrypt(plainText, keyRing.getPublic());
	}

	@Override
	public byte[] decrypt(byte[] cypherText) throws Throwable {
		return super.decrypt(cypherText, keyRing.getPrivate());
	}
}
