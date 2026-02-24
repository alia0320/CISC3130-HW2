package cisc3130HW2;

public class Pair<K, V> {
	
	private K first;
	private V second;
	
	public Pair(K first, V second) {
		this.first = first;
		this.second = second;
	}
	
	public K getFirst() {
		return this.first;
	}
	
	public void setFirst(K value) {
		this.first = value;
	}
	
	public V getSecond() {
		return this.second;
	}
	
	public void setSecond(V value) {
		this.second = value;
	}
	
	@Override
	public String toString() {
		return this.first.toString() + " " + this.second.toString();
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Pair)) {
			return false;
		}
		Pair<K, V> obj = (Pair<K, V>) other;
		if (this.first.equals(obj.getFirst()) && this.second.equals(obj.getSecond())) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return ((this.first != null) && (this.second != null)) ? (this.first.hashCode() % this.second.hashCode()) : 0;
	}

}
