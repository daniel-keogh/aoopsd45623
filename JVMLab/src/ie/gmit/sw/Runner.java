/**
 * Lab 1: Garbage Collection and JVM Heap Analysis
 */

package ie.gmit.sw;

import java.util.*;

public class Runner {
	Collection<Person> col = new ArrayList<>();
	
	public void go() {		
		for (int i = 0; i < 1_000_000_000; i++) {
			var p = new Person(i);
			
			if (i % 100 == 0) {
				col.add(p);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Running...");
		// Block until number entered
		int i = System.in.read();
		
		new Runner().go();
	}
}
