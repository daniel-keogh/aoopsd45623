package ie.gmit.sw.hamming;

import ie.gmit.character.Measurable;

public class HammingImpl implements Measurable{	
	
	public float getDistance(CharSequence s, CharSequence t) throws Exception {
		if (s.length() != t.length()) return -1.00f; //Similar length strings only
		float counter = 0.0f;
		
		for (int i = 0; i < s.length(); ++i){
			if (s.charAt(i) != t.charAt(i)) counter++;
		}
		return counter;
	}	
}
