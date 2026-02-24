package cisc3130HW2;

import java.util.ArrayList;

public class EnrollmentManager {
	
	private ArrayList<Enrollment> enrollments;
	
	public EnrollmentManager() {
		this.enrollments = new ArrayList<>();
	}
	
	/*
	 * enrollStudent is lengthy since it is possible for the user to accidentally add two students that share the exact same field
	 * data as each other. I am not sure whether my code for the enrollmentId is doing the right thing, though it has later
	 * come to my attention that because the student has a studentId, it not is synonymous with their enrollmentId. that is because
	 * the student with that id will enroll in another course, should that enrollmentId be the same as their studentId? I realized
	 * that this will create a situation where there the student with that Id ends up generating two enrollments with the same Ids.
	 * 
	 * UPDATE: I will have to add CourseManager into this since the only way to check whether a course is full is through
	 * the manager itself
	 */
	
	public void enrollStudent(String studentId, String courseCode, String semester, CourseManager cm) {
		Enrollment student = new Enrollment(studentId, courseCode, semester);
		boolean dupe_in_course = false; // boolean that checks whether there exists that exact student is already enrolled in specified class for specified semester
		for (int i = 0; i < enrollments.size(); i++) {
			if (enrollments.get(i).getCourseCode().equals(courseCode) && enrollments.get(i).getStudentId().equals(studentId) && enrollments.get(i).getSemester().equals(semester)) {
				dupe_in_course = true;
			}
		}
		boolean metrequirements = false; // will be used
		boolean courseExists = true; //check whether the course exists in course manager
		if (cm.findCourse(courseCode) == null) {
			courseExists = false;
		}
		// check whether the student has met the prerequisites for the course
		if (courseExists && getStudentCourses(studentId).containsAll(cm.findCourse(courseCode).getPrerequisites())) {
			metrequirements = true;
		}
		// check whether the course is full
		boolean courseFull = true;
		if (courseExists && getEnrollmentCount(courseCode) <= cm.findCourse(courseCode).getMaxEnrollment()) {
			courseFull = false;
		}
		if (metrequirements && courseExists && !courseFull && !dupe_in_course) {
			enrollments.add(student);
		} else {
			System.out.println("\nCannot enroll student: for the following reasons: \n"
					+ "1. The course does not exist. " + !courseExists + "\n"
					+ "2. The course is full (automatically full if course does not exist). " + courseFull + "\n"
					+ "3. The student is already enrolled in that course for the semester. " + dupe_in_course + "\n"
					+ "4. The student does not meet the course prerequisites (automatically set to true if course does not exist). " + !metrequirements);
			Enrollment.enrollmentCount--;
			System.out.println("Enrollment ID has been discarded.");
		}
	}
	
	public Enrollment findEnrollment(String enrollmentId) {
		for (int i = 0; i < enrollments.size(); i++) {
			if (enrollments.get(i).getEnrollmentId().equals(enrollmentId)) {
				return enrollments.get(i);
			}
		}
		return null;
	}
	
	public boolean dropEnrollment(String enrollmentId) {
		for (int i = 0; i < enrollments.size(); i++) {
			if (enrollments.get(i).getEnrollmentId().equals(enrollmentId)) {
				enrollments.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Enrollment> getEnrollmentsByStudent(String studentId) {
		ArrayList<Enrollment> studentenrollment = new ArrayList<>();
		for (int i = 0; i < enrollments.size(); i++) {
			if (enrollments.get(i).getStudentId().equals(studentId)) {
				studentenrollment.add(enrollments.get(i));
			}
		}
		if (studentenrollment.size() > 0) {
			return studentenrollment;
		} else {
			return null;
		}
	}
	
	public ArrayList<String> getStudentCourses(String id) {
		ArrayList<String> courses = new ArrayList<>();
		ArrayList<Enrollment> enrollmentsByStudent = getEnrollmentsByStudent(id);
		if (enrollmentsByStudent == null) {
			return courses; // we will have to cope with an empty list, since the program will run into an exception
			// when it has to check whether the student has must the prerequisites for the course
		}
		for (int i = 0; i < enrollmentsByStudent.size(); i++) {
			courses.add(enrollmentsByStudent.get(i).getCourseCode());
		}
		return courses;
	}
	
	public ArrayList<Enrollment> getEnrollmentsByCourse(String courseCode) {
		ArrayList<Enrollment> courseEnrollments = new ArrayList<>();
		for (int i = 0; i < enrollments.size(); i++) {
			if (enrollments.get(i).getCourseCode().equals(courseCode)) {
				courseEnrollments.add(enrollments.get(i));
			}
		}
		if (courseEnrollments.size() > 0) {
			return courseEnrollments;
		} else {
			return null;
		}
	}
	
	public void assignGrade(String enrollmentId, String grade) {
		boolean found = false;
		for (int i = 0; i < enrollments.size(); i++) {
			if (enrollments.get(i).getEnrollmentId().equals(enrollmentId)) {
				enrollments.get(i).setGrade(grade);
				found = true;
			}
		}
		if (found) {
			System.out.println("Grade updated!");
		} else {
			System.out.println("Could not find student with specified Enrollment ID.");
		}
	}
	
	/*
	 * assume that it wants GPA in points
	 */
	
	public double calculateStudentGpa(String studentId) {
		double total = 0;
		int enrollmentsCount = 0;
		for (int i = 0; i < enrollments.size(); i++) {
			if (enrollments.get(i).getStudentId().equals(studentId)) {
				total += enrollments.get(i).getGradePoints();
				enrollmentsCount++;
			}
		}
		if (enrollmentsCount == 0) {
			return 0;
		} else {
			return total/enrollmentsCount;
		}
	}
	
	
	public ArrayList<String> getStudentsInCourse(String courseCode) {
		ArrayList<String> studentsInCourse = new ArrayList<>();
		for (int i = 0; i < enrollments.size(); i++) {
			if (enrollments.get(i).getCourseCode().equals(courseCode)) {
				studentsInCourse.add(enrollments.get(i).getStudentId()); // return student IDs
			}
		}
		if (studentsInCourse.size() > 0) {
			return studentsInCourse;
		} else {
			return null;
		}
	}
	
	public int getEnrollmentCount(String courseCode) {
		int total = 0;
		for (int i = 0; i < enrollments.size(); i++) {
			if (enrollments.get(i).getCourseCode().equals(courseCode)) {
				total++;// return student ID
			}
		}
		return total;
	}
	
	public void printAllEnrollments() {
		if (enrollments.size() == 0) {
			System.out.println("There are no enrollments to display.");
		} else {
			System.out.println("-----------------Showing All Enrollments------------------");
			for (int i = 0; i < enrollments.size(); i++) {
				System.out.println(enrollments.get(i));
			}
			System.out.println("----------------------------------------------------------");
		}
	}

}
