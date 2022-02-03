package adt;

public interface UnionFind<T> {
	int size();
	T find(T obj);
	boolean connected(T obj1, T obj2);
	void Union(T obj1, T obj2);
}
