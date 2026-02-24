package cisc3130HW2;

import java.util.ArrayList;

public class Course {
	
	private String courseCode;
	private String courseName;
	private int credits;
	private String instructor;
	private int maxEnrollment;
	private ArrayList<String> prerequisites; // contains course codes
	
	public Course(String courseCode, String courseName, int credits, String instructor, int maxEnrollment) {
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.credits = credits;
		this.instructor = instructor;
		this.maxEnrollment = maxEnrollment;
		this.prerequisites = new ArrayList<>(); // initialize the ArrayList
	}
	
	public String getCourseCode() {
		return this.courseCode;
	}
	
	public void setCourseCode(String code) {
		this.courseCode = code;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public void setCourseName(String name) {
		this.courseName = name;
	}
	
	public int getCredits() {
		return this.credits;
	}
	
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
	public String getInstructor() {
		return this.instructor;
	}
	
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	public int getMaxEnrollment() {
		return this.maxEnrollment;
	}
	
	public void setMaxEnrollment(int max) {
		this.maxEnrollment = max;
	}
	
	/*
	 * checks whether there already exists a courseCode with specified parameter, if not, then add that prerequisite
	 */
	
	public void addPrerequisite(String courseCode) {
		if (!prerequisites.contains(courseCode)) {
			prerequisites.add(courseCode);
		}
	}
	
	/*
	 * checks whether the arraylist has specified courseCode using contains
	 */
	
	public boolean hasPrerequisite(String courseCode) {
		return prerequisites.contains(courseCode);
	}
	
	/*
	 * assuming that getter will just return address of prerequisites and not an actual copy of it
	 */
	
	public ArrayList<String> getPrerequisites() {
		return prerequisites;
	}
	
	@Override
	public String toString() {
		return "Course Code: " + this.courseCode + "\tCourse Name: " + this.courseName + "\tCourse Credits: " + this.credits +
				"\tInstructor: " + this.instructor + "\tMax Enrollments: " + this.maxEnrollment;
	}

}
