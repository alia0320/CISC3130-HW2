package cisc3130HW2;

import java.util.ArrayList;

public class GenericQueue<T> {
	
	private ArrayList<T> list;
	
	public GenericQueue() {
		this.list = new ArrayList<>();
	}
	
	public void enqueue(T item) {
		list.add(0, item);
	}
	
	public T dequeue() {
		T element = list.get(list.size()-1);
		list.remove(list.size()-1);
		return element;
	}
	
	public T peek() {
		return list.get(list.size()-1);
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public int size() {
		return list.size();
	}

}
