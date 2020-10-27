package ie.gmit.sw.builder;

import java.util.ServiceLoader;
import ie.gmit.character.*;
import ie.gmit.sw.hamming.*;

public class CharacterDirector implements FuzzyMeasurable, NormalizedMeasurable {
	private Measurable measurable; // Compose
	private CharArrayBuilder builder = new CharArrayBuilder();

	public CharacterDirector() {
		loadSPI();
	}

	public CharacterDirector(Measurable m) { // Dependency injection
		this.measurable = m;
	}

	private void loadSPI() { // Dependency injection
		ServiceLoader<Measurable> services = ServiceLoader.load(Measurable.class);

		for (Measurable me : services) {
			System.out.println(me.getClass().getName());
		}

		Measurable m = services.iterator().next();
		if (m != null)
			this.measurable = m;
	}

	public void append(char c) throws Exception {
		builder.append(c);
	}

	public CharSequence getCharSequence() { // The product is a CharSequence
		return new String(builder.getSequence()).trim().intern();
	}

	@Override
	public float getDistance(CharSequence s, CharSequence t) throws Exception {
		return measurable.getDistance(s, t); // Delegate
	}

	@Override
	public float compare(CharSequence s, CharSequence t) throws Exception {
		return FuzzyMeasurable.super.compare(s, t);
		// return NormalizedMeasurable.super.compare(s, t);
	}
}
