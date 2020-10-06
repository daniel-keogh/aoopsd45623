package ie.gmit.sw;

import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.TreeSet;

public class Runner {
	
//	private List<Student> students = new ArrayList<>();
	
	// Lambda
//	private Collection<Student> students = new TreeSet<>((c, n) -> {
//		return Long.compare(c.getDob().getTime(), n.getDob().getTime());
//	});
	
	// Method Reference
	private Collection<Student> students = new TreeSet<>(Comparator.comparing(Student::getStudentID));
	
	public void go() throws CloneNotSupportedException {
//		Student key = new Student("G7", new Date(System.nanoTime())); // Prototypical search key
//		Student key = (Student) students.get(6).clone(); // Cloning
//		boolean found = students.contains(key);

//		System.out.println(found);

//		key.clear();
//		System.out.println(key.count());
	}
	
	public void init() {
		for (int i = 0; i < 10; i++) {
			Student s = new Student("G" + i, new Date(System.nanoTime()));
			students.add(s);
			
			for (int j = 0; j < 20; j++) {
				s.add(new Book(i + j, "Book " + i));
				
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) throws CloneNotSupportedException {
//		Book s = new Book(123, "Harry Potter and the...");
//		Book t = new Book(123, "Harry Potter and the...");
//		
//		System.out.println(s);
//		System.out.println(t);
//		System.out.println(s == t);
//		System.out.println(s.equals(t));
//		System.out.println(s.hashCode() == t.hashCode());
//		System.out.println(s.hashCode() + " == " + t.hashCode());
//		System.out.println(System.identityHashCode(s) + " != " + System.identityHashCode(t));
		
		Runner r = new Runner();
		r.init();
		r.go();
	}
}
