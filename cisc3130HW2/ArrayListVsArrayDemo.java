package cisc3130HW2;

import java.util.ArrayList;

public class ArrayListVsArrayDemo {

	public static void main(String[] args) {		
		showArrayStats();
		showArrayListStats();
		// using methods as the java garbage collector will avoid creating confusion in memory usage
	}
	
	public static void showArrayListStats() {
		ArrayList<Student> studentArrayList = new ArrayList<>();
		System.out.print("Time to add 10,000 elements to ArrayList: ");
		
		long startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			studentArrayList.add(new Student("S001", "Tony", "Stark", "tonystark@gmail.com", 4.0, "CS", 1));
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed + " nanoseconds");
		
		
		System.out.print("Time to access 1,000 random students in ArrayList: ");
		long startAccess = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			Student element = studentArrayList.get(i);
		}
		long endAccess = System.nanoTime();
		long totalAccessTime = endAccess - startAccess;
		System.out.println(totalAccessTime + " nanoseconds");
		
		
		Runtime runtime = Runtime.getRuntime();
		long freeMemory = runtime.freeMemory();
		long totalMemory = runtime.totalMemory();
		double usedMemory = (totalMemory - freeMemory) / (1024*1024);
		System.out.printf("Total Heap Usage (ArrayList): %.0fMB%n%n", usedMemory);
	}
	
	public static void showArrayStats() {
		Student[] studentArray = new Student[10000];
		System.out.print("Time to add 10,000 elements to Array: ");
		
		long startTime = System.nanoTime();
		for(int i = 0; i < studentArray.length; i++) {
			studentArray[i] = new Student("S001", "Tony", "Stark", "tonystark@gmail.com", 4.0, "CS", 1);
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println(timeElapsed + " nanoseconds");
		
		
		System.out.print("Time to access 1,000 random students in Array: ");
		long startAccess = System.nanoTime();
		for(int i = 0; i < 1000; i++) {
			Student element = studentArray[i];
		}
		long endAccess = System.nanoTime();
		long totalAccessTime = endAccess - startAccess;
		System.out.println(totalAccessTime + " nanoseconds");
		
		
		Runtime runtime = Runtime.getRuntime();
		long freeMemory = runtime.freeMemory();
		long totalMemory = runtime.totalMemory();
		double usedMemory = (totalMemory - freeMemory) / (1024*1024);
		System.out.printf("Total Heap Usage (Array): %.0fMB%n%n", usedMemory);
	}
	
	/*
	 * WHEN TO USE ARRAY VS ARRAYLIST:
	 * both structures are identical to each other with their own ups and downs. Arrays are preferred when you know how
	 * big the data set should be, since you are not able to adjust it after it is instantiated. The access time of an array is
	 * way faster than an arrayList as you are calling a whole method just to access one of the elements of the arrayList,
	 * while you would just have to use a regular statement for the array. Additionally, the ArrayList tends to use more memory
	 * as it is constantly resizing and has empty spaces in its capacity, though that is not to be confused with its size. Adding
	 * elements into the arrayList is also slower for this reason, as it would have to resize if it runs out of space, which involves
	 * making another array in the background with more capacity and then copying elements into the list.
	 */
}
