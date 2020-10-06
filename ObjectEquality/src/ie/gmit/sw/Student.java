package ie.gmit.sw;

import java.util.*;

public class Student implements Cloneable {
	private String studentID;
	private Date dob;
	private List<Book> books = new ArrayList<>();
	
	public Student(String studentID, Date dob) {
		super();
		this.studentID = studentID;
		this.dob = dob;
	}
	
	public String getStudentID() {
		return studentID;
	}
	
	public Date getDob() {
		return dob;
	}

	public boolean add(Book b) {
		return books.add(b);
	}
	
	public Book[] books() {
		return books.toArray(Book[]::new);
	}
	
	public boolean hasBook(Book b) {
		return books.contains(b);
	}
	
	public int count() {
		return books.size();
	}

	public void clear() {
		books.clear();
	}

	private void addAll(List<Book> list) {
		this.books = list;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// Deep copy
		Student s = (Student) super.clone();
		List<Book> copy = new ArrayList<>(books);
		s.addAll(copy);
		
		return s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentID == null) ? 0 : studentID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentID == null) {
			if (other.studentID != null)
				return false;
		} else if (!studentID.equals(other.studentID))
			return false;
		return true;
	}
}
