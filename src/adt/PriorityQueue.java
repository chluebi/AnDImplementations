package adt;

public interface PriorityQueue<T, P extends Comparable<P>> {
	public int size();
	public void add(T value, P priority);
	public T extractMin();
	public void lowerKey(T value, P priority);
}
