package ie.gmit.sw.symmetric;

import javax.crypto.*;

import ie.gmit.sw.crypto.AbstractCypher;

public class AESCypher extends AbstractCypher{
	public AESCypher() throws Throwable{
		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128);
		super.setKey(keyGen.generateKey());
		super.setCypher(Cipher.getInstance("AES/ECB/PKCS5Padding"));
	}
}
