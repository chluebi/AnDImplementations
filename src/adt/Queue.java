package adt;

public interface Queue<T> {
	public int size();
	public void enqueue(T i);
	public T dequeue();
}
