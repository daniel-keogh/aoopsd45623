package ie.gmit.sw;

import java.security.Key;

public interface Cypherable {

	byte[] encrypt(byte[] plainText) throws Throwable;

	byte[] encrypt(byte[] plainText, Key key) throws Throwable;

	byte[] decrypt(byte[] cypherText) throws Throwable;

	byte[] decrypt(byte[] cypherText, Key key) throws Throwable;

}