package adt;

public class Pair<K, V extends Comparable<V>> implements Comparable<Pair<K, V>> {
	
	public K key;
	public V value;
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@Override
	public boolean equals(Object otherObject) {
		if (otherObject instanceof Pair) {
			@SuppressWarnings("unchecked")
			Pair<K, V> other = (Pair<K, V>) otherObject;
			return this.key.equals(other.key) && this.value.equals(other.value);
		} else {
			return false;
		}
	}
	
	public String toString() {
		return "(" + this.key + ": " + this.value + ")";
	}

	@Override
	public int compareTo(Pair<K, V> o) {
		return value.compareTo(o.value);
	}
}
