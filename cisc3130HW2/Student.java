package cisc3130HW2;


public class Student implements Comparable<Student> {
	
	private String studentId;
	private String firstName;
	private String lastName;
	private String email;
	private double gpa;
	private String major;
	private int year;
	
	
	public Student(String stuId, String first, String last, String email, double gpa, String major, int year) {
		this.studentId = stuId;
		this.firstName = first;
		this.lastName = last;
		this.email = email;
		this.gpa = gpa;
		this.major = major;
		this.year = year;
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String first) {
		this.firstName = first;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String last) {
		this.lastName = last;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getGPA() {
		return this.gpa;
	}
	
	public void setGPA(double gpa) {
		this.gpa = gpa;
	}
	
	public String getMajor() {
		return this.major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	@Override
	public String toString() {
		return "Student ID: " + this.studentId + "\tFirst Name: " + this.firstName + "\tLast Name: " + this.lastName + "\tEmail: " + 
				this.email + "\tGPA: " + this.gpa + "\tMajor: " + this.major + "\tYear: " + this.year;
	}
	
	/*
	 * first checks whether the other object is actually a student object. if not, then return false immediately. you do not
	 * want to run into a situation where you cannot compare two objects because one is of Student and the other is of Object
	 */
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Student)) {
			return false;
		}
		Student obj = (Student) other;
		if (this.studentId.equals(obj.getStudentId())) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * prevent two objects from sharing the same hashCode by multiplying the super.hashCode() by the int casted gpa and year of the
	 * student
	 */
	
	@Override
	public int hashCode() {
		return (studentId != null) ? studentId.hashCode() : 0;
	}
	
	/*
	 * use a space to avoid concatenation of two Strings where their names are not separated
	 */
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public int compareTo(Student other) {
		return this.lastName.compareTo(other.getLastName());
	}
}
