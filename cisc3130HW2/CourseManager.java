package cisc3130HW2;

import java.util.ArrayList;

public class CourseManager {
	
	private ArrayList<Course> courses;
	
	public CourseManager() {
		this.courses = new ArrayList<>();
	}
	
	public void addCourse(Course course) {
		if (!courses.contains(course)) {
			courses.add(course);
		} else {
			System.out.println("This course already exists!");
		}
	}
	
	public Course findCourse(String courseCode) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getCourseCode().equals(courseCode)) {
				return courses.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Course> getCoursesByInstructor(String instructor) {
		ArrayList<Course> coursesByInstructor = new ArrayList<>();
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getInstructor().equals(instructor)) {
				coursesByInstructor.add(courses.get(i));
			}
		}
		if (coursesByInstructor.size() != 0) {
			return coursesByInstructor;
		} else {
			return null;
		}
	}
	
	/*
	 * i do not understand why StudentManager is in the parameter here. are we supposed to check whether  the studentId can be
	 * found inside of StudentManager? It has occurred me that EnrollmentManager is not related to studentManager, so it can
	 * hold student IDs that are not in the StudentManager. I find no use for studentManager since none of the fields of Student
	 * holds information about what courses they have taken.
	 */
	
	public ArrayList<Course> getAvailableCourses(String studentId, StudentManager studentManager, EnrollmentManager enrollmentManager) {
		ArrayList<Course> availableCourses = new ArrayList<>(); // the arraylist that the method returns if criteria is satisfied
		// first, get the enrollments by the listed studentId
		ArrayList<Enrollment> studentEnrollments = enrollmentManager.getEnrollmentsByStudent(studentId);
		if (studentManager.findStudent(studentId) == null) {
			System.out.println("This student is not in student manager!");
			return null;
		}
		if (studentEnrollments == null) {
			System.out.println("This student does not have any enrollments!");
			return null;
		}
		/* filter courses by ones that the student passed (this list will be used 
		to remove courses that the student should not be available) */
		ArrayList<String> coursesTaken = new ArrayList<>();
		for (int i = 0; i < studentEnrollments.size(); i++) {
			if (studentEnrollments.get(i).isPassing()) {
				coursesTaken.add(studentEnrollments.get(i).getCourseCode());
			}
		}
		// now loop through the courses arraylist and check whether it does not contain course codes in the coursesTaken
		// arraylist
		for (int i = 0; i < courses.size(); i++) {
			boolean taken = false;
			for (int j = 0; j < coursesTaken.size(); j++) {
				if (courses.get(i).getCourseCode().equals(coursesTaken.get(j))) {
					taken = true; // if the code finds a course that the student has taken, that course becomes unavailable
				}
			}
			if (!taken && coursesTaken.containsAll(courses.get(i).getPrerequisites())) {
				availableCourses.add(courses.get(i));
			}
		}
		return availableCourses;
	}
	
	public void printAllCourses() {
		if (courses.size() != 0) {
			System.out.println("-----------Showing All Courses------------");
			for (int i = 0; i < courses.size(); i++) {
				System.out.println(courses.get(i));
			}
			System.out.println("-------------------------------------------");
		} else {
			System.out.println("There are no courses to display");
		}
	}
	
	public int getTotalCourses() {
		return courses.size();
	}
	
}
