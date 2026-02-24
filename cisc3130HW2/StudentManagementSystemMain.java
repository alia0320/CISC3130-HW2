package cisc3130HW2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementSystemMain {

	public static void main(String[] args) {
		StudentManager sm = new StudentManager();
		CourseManager cm = new CourseManager();
		EnrollmentManager em = new EnrollmentManager();
		Scanner in = new Scanner(System.in);
		boolean exitcondition = false;
		while (!exitcondition) {
			System.out.println("--------Main Menu--------\n"
					+ "1. Add Student\n"
					+ "2. Remove Student\n"
					+ "3. Find Student\n"
					+ "4. List All Students\n"
					+ "5. Add Course\n"
					+ "6. Enroll Student in Course\n"
					+ "7. Drop Student from Course\n"
					+ "8. Assign Grade\n"
					+ "9. Calculate Student GPA\n"
					+ "10. Generate Reports\n"
					+ "11. Exit\n"
					+ "-------------------------");
			int choice = processInt(in);
			switch (choice) {
			case 1:
				in.nextLine();
				addStudent(sm, in);
				break;
			case 2:
				in.nextLine();
				removeStudent(sm, in);
				break;
			case 3:
				in.nextLine();
				findStudent(sm, in);
				break;
			case 4:
				in.nextLine();
				listAllStudents(sm);
				break;
			case 5:
				in.nextLine();
				addCourse(cm, in);
				break;
			case 6:
				in.nextLine();
				enrollStudent(em, cm, in);
				break;
			case 7:
				in.nextLine();
				dropEnrollment(em, in);
				break;
			case 8:
				in.nextLine();
				assignGrade(em, in);
				break;
			case 9:
				in.nextLine();
				calculateGPA(em, in, sm);
				break;
			case 10:
				in.nextLine();
				generateReports(sm, em, cm, in);
				break;
			default:
				exitcondition = true;
				break;
			}
		}
		
	}
	
	/*
	 * asks the user to input information about the data fields of Student.java. while loops are there to check whether the gpa
	 * is between 0 and 4.0 and to prevent the user from entering a year less than 1. it however does not prevent the user to enter
	 * in a year that is greater than 4.
	 */
	
	public static void addStudent(StudentManager sm, Scanner in) {
		System.out.print("Enter Student ID: ");
		String studentId = in.nextLine();
		System.out.print("Enter Student's First Name: ");
		String firstName = in.nextLine();
		System.out.print("Enter Student's Last Name: ");
		String lastName = in.nextLine();
		System.out.print("Enter Student's Email: ");
		String email = in.nextLine();
		System.out.print("Enter Student's GPA: ");
		double gpa = processDouble(in);
		while (gpa > 4.0 || gpa < 0) {
			System.out.println("Student's GPA must be between 0.0 to 4.0");
			System.out.print("Enter Student's GPA: ");
			gpa = processDouble(in);
		}
		in.nextLine();
		System.out.print("Enter Student's Major: ");
		String major = in.nextLine();
		System.out.print("Enter Student's Year: ");
		int year = processInt(in);
		while (year < 1) {
			System.out.println("Year cannot be <1!");
			System.out.print("Enter Student's Year: ");
			year = processInt(in);
		}
		in.nextLine();
		
		sm.addStudent(new Student(studentId, firstName, lastName, email, gpa, major, year));
		System.out.println();
	}
	
	/*
	 * calls the removeStudent method in the if statement: if the student is found, it is removed, and the system tells the user
	 * that the student has been removed, otherwise nothing has been done
	 */
	
	public static void removeStudent(StudentManager sm, Scanner in) {
		System.out.print("Enter ID of Student to be Removed: ");
		String studentId = in.nextLine();
		if (sm.removeStudent(studentId)) {
			System.out.println("Student with specified ID has been removed.");
		} else {
			System.out.println("Could not find student with specified ID. No changes made to Student Manager.");
		}
		System.out.println();
	}
	
	/*
	 * calls the findStudent method in StudentManager after it asks the user to input the StudentId. The if statement checks for
	 * null, which is basically when the program cannot find the studentId
	 */
	
	public static void findStudent(StudentManager sm, Scanner in) {
		System.out.print("Enter ID of Student to be Found: ");
		String studentId = in.nextLine();
		if (sm.findStudent(studentId) != null) {
			System.out.println("Found Student: " + sm.findStudent(studentId));
		} else {
			System.out.println("Student with specified ID could not be found.");
		}
		System.out.println();
	}
	
	public static void listAllStudents(StudentManager sm) {
		sm.printAllStudents();
		System.out.println();
	}
	
	/*
	 * asking the user to satisfy all fields of the Course class. if statements check for invalid number inputs such as
	 * too many credits or too little of an enrollment cap
	 * 
	 * it also asks for the prerequisites, and will call the findCourse method of CourseManager to add courses to the courseCode
	 * that the user first inputted
	 */
	
	public static void addCourse(CourseManager cm, Scanner in) {
		System.out.print("Enter Course Code: ");
		String courseCode = in.nextLine();
		System.out.print("Enter Course Name: ");
		String courseName = in.nextLine();
		System.out.print("Enter Course Credits: ");
		int credits = processInt(in);
		while (credits < 3 || credits > 4) {
			System.out.println("Credits must be 3 or 4!");
			System.out.print("Enter Course Credits: ");
			credits = processInt(in);
		}
		in.nextLine();
		System.out.print("Enter Instructor's Name: ");
		String instructor = in.nextLine();
		System.out.print("Enter Max Enrollment: ");
		int maxEnrollment = processInt(in);
		while (maxEnrollment < 1) {
			System.out.println("Max enrollment cannot be < 1!");
			System.out.print("Enter Max Enrollment: ");
			maxEnrollment = processInt(in);
		}
		cm.addCourse(new Course(courseCode, courseName, credits, instructor, maxEnrollment));
		System.out.print("How many prerequisites does this course have? ");
		int num_of_prerequisites = processInt(in);
		while (num_of_prerequisites < 0) {
			System.out.println("Number of prerequisites cannot be < 0!");
			System.out.print("How many prerequisites does this course have? ");
			num_of_prerequisites = processInt(in);
		}
		in.nextLine();
		int index = 0;
		while (num_of_prerequisites > index) {
			System.out.print("Enter code of prerequisite #" + (index+1) + ": ");
			String prereq_name = in.nextLine();
			while(prereq_name.equals(courseCode)) {
				System.out.println("Prerequisite cannot have the same code as the course!");
				System.out.print("Enter code of prerequisite #" + (index+1) + ": ");
				prereq_name = in.nextLine();
			}
			cm.findCourse(courseCode).addPrerequisite(prereq_name);
			index++;
		}
		System.out.println();
	}
	
	/*
	 * asks user to satisfy parameter fields of enrollStudent in EnrollmentManager. if the fields do not trigger a duplicate,
	 * then an enrollment is made and a print statement will specify the enrollmentId of the enrollment the user just
	 * created
	 */
	
	public static void enrollStudent(EnrollmentManager em, CourseManager cm, Scanner in) {
		System.out.print("Enter ID of Student to be Enrolled: ");
		String studentId = in.nextLine();
		System.out.print("Enter Course Code: ");
		String courseCode = in.nextLine();
		System.out.print("Enter Semester of Enrollment: ");
		String semester = in.nextLine();
		em.enrollStudent(studentId, courseCode, semester, cm);
		System.out.println();
	}
	
	/*
	 * not mentioned in the assignment, but something ill just add on since the method won't be used anywhere else
	 */
	
	public static void dropEnrollment(EnrollmentManager em, Scanner in) {
		System.out.print("Enter ID of Enrollment to Drop: ");
		String enrollmentId = in.nextLine();
		if (em.dropEnrollment(enrollmentId)) {
			System.out.println("Enrollment of Specified ID Has Been Dropped.");
		} else {
			System.out.println("Could Not Find Enrollment With Specified ID. No Changes Made to Enrollment Manager.");
		}
		System.out.println();
	}
	
	public static void assignGrade(EnrollmentManager em, Scanner in) {
		System.out.print("Enter Enrollment ID: ");
		String enrollmentId = in.nextLine();
		System.out.print("Enter Grade to be Assigned: ");
		String grade = in.next();
		em.assignGrade(enrollmentId, grade);
		System.out.println();
	}
	
	public static void calculateGPA(EnrollmentManager em, Scanner in, StudentManager sm) {
		System.out.print("Enter Student ID: ");
		String studentId = in.nextLine();
		sm.findStudent(studentId).setGPA(em.calculateStudentGpa(studentId));
		System.out.printf("Student's GPA: %.1f%n%n" , em.calculateStudentGpa(studentId));
	}
	
	/*
	 * making a second menu since it will be confused to navigate through the reports generator without it
	 */
	
	public static void generateReports(StudentManager sm, EnrollmentManager em, CourseManager cm, Scanner in) {
		ReportGenerator reports = new ReportGenerator();
		boolean exitcondition = false;
		while (!exitcondition) {
			System.out.println("Reports Menu: \n"
					+ "1. Generate Student Report\n"
					+ "2. Generate Course Report\n"
					+ "3. Generate Major Report\n"
					+ "4. Generate Honor Roll Report\n"
					+ "5. Generate Available Courses for Student\n"
					+ "6. Show Courses by Instructor\n"
					+ "7. Exit\n");
			int choice = processInt(in);
			switch (choice) {
			case 1:
				in.nextLine();
				System.out.print("Enter ID of Student: ");
				String studentId = in.nextLine();
				reports.generateStudentReport(studentId, sm, em);
				System.out.println();
				break;
			case 2:
				in.nextLine();
				System.out.print("Enter Course Code: ");
				String courseCode = in.nextLine();
				reports.generateCourseReport(courseCode, cm, em);
				System.out.println();
				break;
			case 3:
				in.nextLine();
				System.out.print("Enter Major: ");
				String major = in.nextLine();
				reports.generateMajorReport(major, sm);
				System.out.println();
				break;
			case 4:
				in.nextLine();
				System.out.print("Enter Minimum GPA for Honor Roll Qualification: ");
				double minGPA = processDouble(in);
				reports.generateHonorRollReport(sm, minGPA);
				System.out.println();
				break;
			case 5:
				in.nextLine();
				System.out.print("Enter Student ID: ");
				String studentIdCourses = in.nextLine();
				reports.generateAvailableCourses(studentIdCourses, sm, em, cm);
				System.out.println();
				break;
			case 6:
				in.nextLine();
				System.out.print("Enter Instructor Name: ");
				String instructor = in.nextLine();
				reports.generateCoursesByInstructor(cm, instructor);
				System.out.println();
				break;
			default:
				exitcondition = true;
				System.out.println();
				break;
			}
		}
			

	}
	
	/*
	 * prevent exceptions triggered by user attempting to enter something that is not a double type
	 */
	
	public static double processDouble(Scanner in) {
		double number = 0;
		try {
			number = in.nextDouble();
		} catch (InputMismatchException ex) {
			System.out.print("Please enter a valid number: ");
			in.nextLine();
			number = processDouble(in);
		}
		return number;
	}
	
	/*
	 * same scenario as processDouble(), this time the exception is only triggered when the user does not enter a whole number
	 */
	
	public static int processInt(Scanner in) {
		int number = 0;
		try {
			number = in.nextInt();
		} catch (InputMismatchException ex) {
			System.out.print("Please enter a valid whole number: ");
			in.nextLine();
			number = processInt(in);
		}
		return number;
	}

}
