package cisc3130HW2;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class ArrayListOperationsDemo {
	public static void main(String[] args) {
		// task 1:
		Student[] studentsarr = {new Student("S001", "Tony", "Stark", "tonystark@gmail.com", 4.0, "CS", 1),
				new Student("S002", "Tony", "Stank", "tonystank@gmail.com", 3.0, "CE", 2),
				new Student("S003", "Clark", "Kent", "not.superman@gmail.com", 2.0, "CS", 2),
				new Student("S004", "Bruce", "Wayne", "bruce.wayne@gmail.com", 4.0, "Mechanical Engineering", 4)};
		ArrayList<Student> studentsarrl = new ArrayList<>(Arrays.asList(studentsarr));
		System.out.println(studentsarrl);
		studentsarrl.add(new Student("S005", "Steve", "Rogers", "steve.rogers@gmail.com", 4.0, "Physical Education", 1));
		System.out.println(studentsarrl);
		studentsarrl.remove(new Student("S005", "Steve", "Rogers", "steve.rogers@gmail.com", 4.0, "Physical Education", 1));
		System.out.println(studentsarrl);
		System.out.println();
		
		// task 2:
		Student[] arrayListToArray = studentsarrl.toArray(new Student[studentsarrl.size()]); // looked on google for this, since
		// toArray returns an Object array, and I needed to cast it to Student. I do not know why I have to specify it inside the
		// parameter of the toArray() method, but at least I see its use now. 
		System.out.println("This is printing the regular array after converting the arrayList to array");
		for (int i = 0; i < arrayListToArray.length; i++) {
			System.out.print(arrayListToArray[i] + ((i < arrayListToArray.length-1) ? ", " : ""));
		}
		System.out.println();
		
		// task 3:
		ArrayList<Student> studentAL = new ArrayList<>();
		studentAL.add(new Student("S001", "Ali", "Ahmed", "alia0320@github.com", 4.0, "CS", 2));
		studentAL.add(new Student("S002", "John", "Doe", "john.doe@github.com", 3.0, "Chemical Engineering", 3));
		studentAL.add(new Student("S003", "Jane", "Doe", "john.doe@github.com", 4.0, "Nuclear Engineering", 3));
		studentAL.add(new Student("S004", "Morgan", "Rodgers", "morgan.rodgers@aston-villa.com", 3.5, "Physical Education", 3));
		studentAL.add(new Student("S005", "Ollie", "Watkins", "ollie.watkins@aston-villa.com", 2.9, "Physical Education", 4));
		System.out.println(studentAL.subList(1, 3)); // prints a shorter list that prints the first specified index to the last specified index exclusive
		System.out.println(studentAL); // prints full list
		System.out.println();

		
		// task 4:
		Collections.sort(studentAL, Comparator.comparingDouble(Student::getGPA).reversed()); // more info from documentations, use the lambda syntax
		// with the comparator to sort by GPA. reversed allows for the sort to be in descending order
		System.out.println(studentAL);
		Collections.sort(studentAL, Comparator.comparing(Student::getFirstName, String.CASE_INSENSITIVE_ORDER)); // use static method
		// to prioritize order and ignore cases. in this case it is not relevant since the names are all capitalized.
		System.out.println(studentAL);
		System.out.println();
		
		// task 5:
		System.out.println(studentAL.indexOf(new Student("S005", "Ollie", "Watkins", "ollie.watkins@aston-villa.com", 2.9, "Physical Education", 4)));
		// should print 4 since it is the last element of the arrayList
		System.out.println(studentAL.contains(new Student("S001", "Ali", "Ahmed", "alia0320@github.com", 4.0, "CS", 2))); // true
		System.out.println(studentAL.contains(new Student("S006", "Bli", "Bhmed", "blib0320@github.com", 4.0, "bS", 2))); // false
		// Collections.binarySearch will npt work if Student class does not have compareTo. it has to sort the objects by natural order, and part of that requires the compareTo method to exist
		System.out.println(Collections.binarySearch(studentAL, new Student("S004", "Morgan", "Rodgers", "morgan.rodgers@aston-villa.com", 3.5, "Physical Education", 3)));

	}
}
