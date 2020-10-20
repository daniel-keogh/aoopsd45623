package ie.gmit.sw.symmetric;

import java.security.Key;

import ie.gmit.sw.crypto.AbstractCypher;
import ie.gmit.classic.vigenere.*;

/*
 * Blaise de Vigenere, a  French diplomat, is incorrectly accredited with inventing this encryption mechanism in the 1570s,
 * as the technique is mentioned in a book by the aristocratic Giovani Battista Bellaso that was piublished in 1553. In 1863,
 * the first crypto-analytic technique for breaking was reported by Friedrich Kasiski, an officer in the Prussian army.  
 */
public class VigenereCypher extends AbstractCypher {
	private Vigenere v = new Vigenere();

	@Override
	protected void setKey(Key useKey) {
		v.setKey(new String(useKey.getEncoded()));
		super.setKey(v.getKey());
	}

	public void setKey(String key) {
		v.setKey(key);
	}
}