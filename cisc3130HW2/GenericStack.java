package cisc3130HW2;

import java.util.ArrayList;

public class GenericStack<T> {
	
	private ArrayList<T> list;
	
	public GenericStack() {
		this.list = new ArrayList<T>();
	}
	
	public void push(T item) {
		list.add(list.size(), item);
	}

	public T pop() {
		T element = list.get(list.size()-1);
		list.remove(list.size()-1);
		return element;
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int size() {
		return list.size();
	}
	
	public void clear() {
		list.clear();
	}
}
