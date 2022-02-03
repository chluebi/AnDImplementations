package adt;

public interface Stack<T> {
	public int size();
	public void add(T i);
	public T peek();
	public T remove();
}
