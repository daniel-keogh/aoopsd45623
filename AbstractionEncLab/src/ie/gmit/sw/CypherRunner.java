package ie.gmit.sw;

public class CypherRunner {

	public static void main(String[] args) throws CypherException {
		Cypherable cc = new CaesarCypher();
		CypherKey ck = new StringCypherKey("7");
		cc.setCypherKey(ck);
		
		String s = "Happy Days!";
		String t = cc.encrypt(s);
		
		System.out.println(t);
		System.out.println(cc.decrypt(t));
	}
}
