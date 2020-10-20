package ie.gmit.sw.crypto;

import ie.gmit.sw.asymmetric.RSACypher;
import ie.gmit.sw.symmetric.AESCypher;
import ie.gmit.sw.symmetric.DESCypher;
import ie.gmit.sw.symmetric.VigenereCypher;

public class CypherFactory { // A singleton factory....
	//The static class field can see the private constructor
	private static CypherFactory fact = new CypherFactory();
	
	//Make the constructor private
	private CypherFactory(){		
	}
	
	//Use a static method to get a handle on the single instance of the class
	public static CypherFactory getInstance(){
		return fact;
	}
	
	//This is the factory method
	public Cypherable getCypherable(Algorithm algo) throws Throwable{
		/* All of this logic should be replaced by a command object, as there are an
		 * unbounded number of possible cryptographic algorithms to use. The intent of a command
		 * object is to "encapsulate a method invocation", which is exactly what we want 
		 * to do here... More on this later!
		 */
		if (algo == Algorithm.AES){
			return new AESCypher();
		}else if (algo == Algorithm.DES){
			return new DESCypher();
		}else if (algo == Algorithm.VIGENERE){
			VigenereCypher vc =  new VigenereCypher();
			vc.setKey("OBJECT ORIENTED SOFTWARE DEVELOPMENT");
			return vc;
		}else{
			return new RSACypher();
		}
	}
}
