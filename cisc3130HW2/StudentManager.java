package cisc3130HW2;

import java.util.ArrayList;

public class StudentManager {
	
	private ArrayList<Student> students;
	
	public StudentManager() {
		this.students = new ArrayList<>();
	}
	
	public void addStudent(Student student) {
		if (!students.contains(student)) {
			students.add(student);
		} else {
			System.out.println("This student already exists! (Entered the same ID)");
		}
	}
	
	public boolean removeStudent(String studentId) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getStudentId().equals(studentId)) {
				students.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Student findStudent(String studentId) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getStudentId().equals(studentId)) {
				return students.get(i);
			}
		} 
		return null;
	}
	
	public ArrayList<Student> getStudentsByMajor(String major) {
		ArrayList<Student> students_of_major = new ArrayList<>();
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getMajor().equals(major)) {
				students_of_major.add(students.get(i));
			}
		}
		return students_of_major;
	}
	
	public ArrayList<Student> getStudentsByYear(int year) {
		ArrayList<Student> students_of_year = new ArrayList<>();
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getYear() == year) {
				students_of_year.add(students.get(i));
			}
		}
		return students_of_year;
	}
	
	public ArrayList<Student> getHonorStudents(double minGpa) {
		ArrayList<Student> honor_students = new ArrayList<>();
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getGPA() >= minGpa) {
				honor_students.add(students.get(i));
			}
		}
		if (honor_students.size() != 0) {
			return honor_students;
		} else {
			return null;
		}
	}
	
	/*
	 * sum of all GPA is stored in total, and is then divided by the size if it is not 0. if there are no students in the ArrayList,
	 * then return 0
	 */
	
	public double getAverageGpa() {
		double total = 0;
		for (int i = 0; i < students.size(); i++) {
			total += students.get(i).getGPA();
		}
		if (students.size() != 0) {
			return total/students.size();
		} else {
			return 0;
		}
	}
	
	/*
	 * same case as getAverageGpa, this time it checks how many students are of that major and adds their Gpa to total.
	 */
	
	public double getAverageGpaByMajor(String major) {
		double total = 0;
		int student = 0;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getMajor().equals(major)) {
				total += students.get(i).getGPA();
				student++;
			}
		}
		if (student != 0) {
			return total/student;
		} else {
			return 0;
		}
	}
	
	/*
	 * checking whether the ArrayList is not empty, if it is then print that there are no students, if not, then list all the
	 * students
	 */
	
	public void printAllStudents() {
		if (students.size() != 0) {
			System.out.println("-----------------Showing All Students----------------");
			for (int i = 0; i < students.size(); i++) {
				System.out.println("Student #" + (i+1) + ": " + students.get(i));
			}
			System.out.println("----------------------------------------------------\n");
		} else {
			System.out.println("There are no students in the manager.\n");
		}
	}
	
	public int getTotalStudents() {
		return students.size();
	}
	
	/*
	 * checks for duplicates if there are students with the same major. if it scrolls to a student with a unique major that is not
	 * in the uniqueMajors arrayList, then add their major to the list. otherwise do not add their major to the arraylist if it 
	 * already has that major.
	 */
	
	public ArrayList<String> getAllMajors() {
		ArrayList<String> uniqueMajors = new ArrayList<>();
		for (int i = 0; i < students.size(); i++) {
			if (!uniqueMajors.contains(students.get(i).getMajor())) {
				uniqueMajors.add(students.get(i).getMajor());
			}
		}
		return uniqueMajors;
	}
}
