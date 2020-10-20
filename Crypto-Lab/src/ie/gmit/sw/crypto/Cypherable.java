package ie.gmit.sw.crypto;

public interface Cypherable {
	public byte[] encrypt(byte[] plainText) throws Throwable;
	public byte[] decrypt(byte[] cypherText) throws Throwable;
}