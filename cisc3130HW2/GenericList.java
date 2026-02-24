package cisc3130HW2;

import java.util.ArrayList;

public class GenericList<T> {
	
	private ArrayList<T> items;
	
	public GenericList() {
		this.items = new ArrayList<>();
	}
	
	public void add(T item) {
		items.add(item);
	}
	
	public T get(int index) {
		return items.get(index);
	}
	
	public boolean remove(T item) {
		return items.remove(item);
	}
	
	public int size() {
		return items.size();
	}
	
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	public void clear() {
		items.clear();
	}
	
	public boolean contains(T item) {
		return items.contains(item);
	}
	
	public ArrayList<T> getAll() {
		return items;
	}
	
	public void addAll(ArrayList<T> other) {
		items.addAll(other);
	}
	
	public <U extends T> void addAllFrom(GenericList<U> other) {
		for (int i = 0; i < other.size(); i++) {
			items.add(other.get(i));
		}
	}
}
