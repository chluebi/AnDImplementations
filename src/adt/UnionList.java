package adt;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class UnionList<T> implements UnionFind<T> {
	
	HashMap<T, T> data;
	
	public UnionList(T[] input) {
		data = new HashMap<T, T>();
		for (int i = 0; i < input.length; i++) {
			data.put(input[i], input[i]);
		}
	}
	
	public UnionList(Collection<T> input) {
		data = new HashMap<T, T>();
		Iterator<T> iterator = input.iterator();
		while (iterator.hasNext()) {
			T next = iterator.next();
			data.put(next, next);
		}
	}

	@Override
	public int size() {
		HashSet<T> set = new HashSet<T>();
		set.addAll(this.data.values());
		return set.size();
	}

	@Override
	public T find(T obj) {
		if (data.get(obj).equals(obj)) {
			return obj;
		}
		T par = find(data.get(obj));
		data.put(obj, par);
		return par;
	}

	@Override
	public boolean connected(T obj1, T obj2) {
		return find(obj1).equals(find(obj2));
	}

	@Override
	public void Union(T obj1, T obj2) {
		data.put(find(obj2), data.get(obj1));
	}

}
