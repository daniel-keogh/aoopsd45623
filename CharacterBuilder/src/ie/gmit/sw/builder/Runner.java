package ie.gmit.sw.builder;

public class Runner {
	public static void main(String[] args) throws Exception {
		var cd = new CharacterDirector();
		
		for (int i = 0; i < 1000; i++) {
			cd.append((char) i);
		}
		
		System.out.println(cd.getCharSequence());
	}
}
