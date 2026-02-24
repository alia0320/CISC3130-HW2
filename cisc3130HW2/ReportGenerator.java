package cisc3130HW2;

import java.util.ArrayList;

public class ReportGenerator {
	
	public ReportGenerator() {}
	
	public void generateStudentReport(String studentId, StudentManager sm, EnrollmentManager em) {
		if (sm.findStudent(studentId) != null) {
			Student student = sm.findStudent(studentId);
			System.out.println("Student's Full Name: " + student.getFullName());
			System.out.println("Student's Email: " + student.getEmail());
			System.out.println("Student's Major: " + student.getMajor());
			System.out.printf("Student's GPA: %.1f%n", student.getGPA());
			System.out.println("Student's Year: " + student.getYear());
			System.out.println();
			System.out.println("-----Student's Courses----");
			ArrayList<String> courses = em.getStudentCourses(studentId);
			ArrayListUtils.printList(courses); // i do not understand why putting em.getStudentCourses() does not work but making a variable does
			System.out.println("--------------------------");
		} else {
			System.out.println("Cannot print stats for this student.");
		}
	}
	
	public void generateCourseReport(String courseCode, CourseManager cm, EnrollmentManager em) {
		if (cm.findCourse(courseCode) != null) {
			Course course  = cm.findCourse(courseCode);
			System.out.println("Course Name: " + course.getCourseName());
			System.out.println("Course Credits: " + course.getCredits());
			System.out.println("Course Instructor: " + course.getInstructor());
			ArrayList<String> prerequisites = course.getPrerequisites();
			System.out.println("Course prerequisites: " + prerequisites);
			ArrayList<Enrollment> enrollmentsByCourse = em.getEnrollmentsByCourse(courseCode);
			if (enrollmentsByCourse != null) {
				double total = 0;
				for (int i = 0; i < enrollmentsByCourse.size(); i++) {
					total += enrollmentsByCourse.get(i).getGradePoints();
				}
				double average = total/enrollmentsByCourse.size();
				System.out.printf("Course Average: %.1f%n", average);
			} else {
				System.out.println("Course Average: N/A");
			}
			System.out.println();
			System.out.println("----Students Enrolled In Course----");
			ArrayList<String> studentIds = em.getStudentsInCourse(courseCode);
			ArrayListUtils.printList(studentIds);
			
		}
	}
	
	public void generateMajorReport(String major, StudentManager sm) {
		if (sm.getStudentsByMajor(major) != null) {
			ArrayList<Student> studentsMajor = sm.getStudentsByMajor(major);
			System.out.println("---Showing All Students in Major----");
			ArrayListUtils.printList(studentsMajor);
			System.out.println("-------------------------------------");
			System.out.printf("Average of all students in specified major: %.1f%n", sm.getAverageGpaByMajor(major));
		} else {
			System.out.println("There are no students in that major");
		}
	}
	
	public void generateHonorRollReport(StudentManager sm, double minGpa) {
		ArrayList<Student> honorableStudents = sm.getHonorStudents(minGpa);
		if (honorableStudents != null) {
			System.out.println("---Showing Honor Students----");
			ArrayListUtils.printList(honorableStudents);
			System.out.println("------------------------------");
		} else {
			System.out.println("There are no honor students to display.");
		}
	}
	
	public void generateAvailableCourses(String studentId, StudentManager sm, EnrollmentManager em, CourseManager cm) {
		if (cm.getAvailableCourses(studentId, sm, em) != null) {
			System.out.println("----Showing Available Courses For Specified Student----");
			ArrayListUtils.printList(cm.getAvailableCourses(studentId, sm, em));
			System.out.println("-------------------------------------------------------");
		}
	}
	
	public void generateCoursesByInstructor(CourseManager cm, String instructor) {
		if (cm.getCoursesByInstructor(instructor) != null) {
			ArrayList<Course> courses = cm.getCoursesByInstructor(instructor);
			System.out.println("The instructor teaches a total of " + courses.size() + " course(s).");
			System.out.println("-----Showing Courses By Instructor-----");
			ArrayListUtils.printList(courses);
			System.out.println("----------------------------------------");
		} else {
			System.out.println("There are no courses with that instructor");
		}
	}

}
