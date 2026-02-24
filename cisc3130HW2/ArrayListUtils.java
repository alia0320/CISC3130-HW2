package cisc3130HW2;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ArrayListUtils {
	
	public static <T> void swap(ArrayList<T> list, int index1, int index2) {
		T temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
	}
	
	public static <T extends Comparable<T>> T findMax(ArrayList<T> list) {
		T maxelement = list.get(0);
		for (int i = 0; i < list.size(); i++) {
			if (maxelement.compareTo(list.get(i)) < 0) {
				maxelement = list.get(i);
			}
		}
		return maxelement;
	}
	
	public static <T> ArrayList<T> filter(ArrayList<T> list, Predicate<T> condition) {
		ArrayList<T> filtered = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (condition.test(list.get(i))) {
				filtered.add(list.get(i));
			}
		}
		return filtered;
	}
	
	public static <T> void reverse(ArrayList<T> list) {
		list = (ArrayList<T>) list.reversed();
	}
	
	public static <T> ArrayList<T> merge(ArrayList<T> list1, ArrayList<T> list2) {
		ArrayList<T> merged = new ArrayList<>();
		merged.addAll(list1);
		merged.addAll(list2);
		return merged;
	}
	
	public static <T extends Number> double sum(ArrayList<T> numbers) {
		double total = 0;
		for (int i = 0; i < numbers.size(); i++) {
			total += numbers.get(i).doubleValue();
		}
		return total;
	}
	
	public static <T extends Number> double average(ArrayList<T> numbers) {
		double sum = sum(numbers);
		if (numbers.size() != 0) {
			return sum/numbers.size();
		} else {
			return 0;
		}
	}
	
	public static <T extends Number & Comparable<T>> ArrayList<T> filterAbove(ArrayList<T> numbers, T threshold) {
		ArrayList<T> filtered = new ArrayList<>();
		for (T number : numbers) {
			if (number.compareTo(threshold) > 0) {
				filtered.add(number);
			}
		}
		return filtered;
	}
	
	/*
	 * Upper-Bounded wildcards restrict the user to work with the subtypes of the Number type
	 */
	
	public static double sumNumbers(ArrayList<? extends Number> numbers) { // note that ? is the Generic identifier for wildcard, it is best used with lists
		double total = 0;
		for (int i = 0; i < numbers.size(); i++) {
			total += numbers.get(i).doubleValue();
		}
		return total;
	}
	
	/*
	 * not necessarily sure what is meant by the ability for this method to add numbers
	 * lower-bounded wildcards according to the documentation allows the user to add subtypes of the Integer
	 * type.
	 */
	
	public static void addNumbers(ArrayList<? super Integer> list) {
		list.add(100);
		list.add(200);
	}
	
	/*
	 * unbounded-generics are only used for when you are working with any type, though you are not able to add or remove elements
	 * from the arraylist as the compiler does not know which type it is working with. its general purpose is usually to print
	 * out elements of the list, which is what it is doing here.
	 */
	
	public static void printList(ArrayList<?> list) {
		if (list.size() == 0) {
			System.out.println("There is nothing in the list.");
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}
}
