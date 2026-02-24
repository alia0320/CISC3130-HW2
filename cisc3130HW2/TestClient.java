package cisc3130HW2;

import java.util.ArrayList;

public class TestClient {

	public static void main(String[] args) {
		
		/*StudentManager studentManager = new StudentManager();
		studentManager.addStudent(new Student("S001", "Tony", "Stark", "tonystark@gmail.com", 4.0, "CS", 1));
		
		CourseManager courseManager = new CourseManager();
		courseManager.addCourse(new Course("CISC3130", "Data Structures", 4, "Dr. Smith", 30));
		courseManager.addCourse(new Course("CISC3115", "Modern Programming Techniques", 4, "Dr. Smith", 30));
		courseManager.addCourse(new Course("CISC1115", "Intro to Java", 4, "Dr. Smith", 30));
		courseManager.findCourse("CISC3130").addPrerequisite("CISC3115");
		courseManager.findCourse("CISC3130").addPrerequisite("CISC1115");
		courseManager.addCourse(new Course("MATH101", "Calculus I", 4, "Dr. Johnson", 25));

		EnrollmentManager enrollmentManager = new EnrollmentManager();
		enrollmentManager.enrollStudent("S001", "CISC3115", "Spring 2024");
		enrollmentManager.enrollStudent("S001", "CISC1115", "Fall 2023");
		enrollmentManager.enrollStudent("S002", "CISC3115", "Fall 2023");
		enrollmentManager.assignGrade("E001", "A");
		enrollmentManager.assignGrade("E002", "A");
		enrollmentManager.assignGrade("E003", "A");
		System.out.println("Student GPA: " + enrollmentManager.calculateStudentGpa("S001"));
		if (courseManager.getAvailableCourses("S002", studentManager, enrollmentManager) != null) {
			System.out.println(courseManager.getAvailableCourses("S002", studentManager, enrollmentManager));
		} else {
			System.out.println("Can't do nothing!");
		}
	*/
	
	GenericList<String> strings = new GenericList<>();
	strings.add("Hello");
	System.out.println(strings.getAll());
	
	GenericList<Integer> numbers = new GenericList<>();
	numbers.add(42);
	numbers.add(13);
	numbers.add(54);
	System.out.println(numbers.getAll());

	GenericList<Student> students = new GenericList<>();
	students.add(new Student("S001", "Tony", "Stark", "tonystark@gmail.com", 4.0, "CS", 1));
	System.out.println(students.getAll());
	
	GenericList<Number> numbered = new GenericList<>();
	numbered.add((43.32));
	numbered.add((3.4145f));
	numbered.addAllFrom(numbers);
	System.out.println(numbered.getAll());
	
	ArrayList<Integer> ints = new ArrayList<>();
	ints.add(10);
	ints.add(20);
	ints.add(30);
	System.out.println("Sum: " + ArrayListUtils.sum(ints));
	System.out.println("Average: " + ArrayListUtils.average(ints));
	System.out.println("Above 10: " + ArrayListUtils.filterAbove(ints, 10));
	System.out.println(ArrayListUtils.filter(ints, integer -> (integer > 10))); // test whether the integer is greater than 10
	
	GenericStack<String> stack = new GenericStack<>();
	stack.push("First");
	stack.push("Second");
	System.out.println(stack.pop());  // Second

	GenericQueue<Integer> queue = new GenericQueue<>();
	queue.enqueue(10);
	queue.enqueue(20);
	System.out.println(queue.dequeue());  // 10
	
	ArrayList<Pair<String, Double>> strfp = new ArrayList<>();
	strfp.add(new Pair("Stupid", 21.19));
	strfp.add(new Pair("Unfunny number", 67.67));
	strfp.add(new Pair("Funny number", 69.69));
	System.out.println(strfp);


	}
}
