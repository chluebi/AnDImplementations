package adt;

import java.util.ArrayList;
import java.util.HashMap;

public class MinHeap<T, P extends Comparable<P>> implements PriorityQueue<T, P> {
	
	public ArrayList<Pair<T, P>> data;
	private HashMap<T, Integer> indexMap;
	
	public static void main(String[] args) {
		Integer[] priorities = {3, 6, 5, 1, 2, 4, 8, 7};
		for (int i = 0; i < priorities.length; i++) {
			priorities[i] = -priorities[i];
		}
		MinHeap<Integer, Integer> heap = new MinHeap<Integer, Integer>(priorities, priorities);
		System.out.println(heap.data);
	}
	
	public MinHeap() {
		this.data = new ArrayList<Pair<T, P>>();
		this.indexMap = new HashMap<T, Integer>();
	}
	
	public MinHeap(T[] values, P[] priorities) {
		this();
		for (int i = 0; i < values.length; i++) {
			this.data.add(new Pair<T, P>(values[i], priorities[i]));
			this.indexMap.put(values[i], this.size()-1);
		}
		balanceSubHeap(0);
	}
	
	private void swap(int i, int j) {
		Pair<T, P> temp = data.get(i);
		data.set(i, data.get(j));
		data.set(j, temp);
		indexMap.put(data.get(i).key, i);
		indexMap.put(data.get(j).key, j);
	}
	
	private int leftChild(int i) {
		return 2 * i + 1;
	}
	
	private int parent(int i) {
		return (i - 1)/2;
	}
	
	private int descendLevel(int i) {
		Pair<T, P> node = data.get(i);
		int leftChildIndex = leftChild(i);
		if (leftChildIndex >= this.size()) {
			return i;
		}
		Pair<T, P> leftChild = data.get(leftChildIndex);
		
		int rightChildIndex = leftChildIndex + 1;
		if (rightChildIndex >= this.size()) {
			if (leftChild.compareTo(node) < 0) {
				swap(i, leftChildIndex);
				return leftChildIndex;
			} else {
				return i;
			}
		}
		Pair<T, P> rightChild = data.get(rightChildIndex);
		
		if (leftChild.compareTo(node) < 0 && rightChild.compareTo(node) <  0) {
			if (leftChild.compareTo(rightChild) <= 0) {
				swap(i, leftChildIndex);
				return leftChildIndex;
			} else {
				swap(i, rightChildIndex);
				return rightChildIndex;
			}
		} else if (leftChild.compareTo(node) < 0) {
			swap(i, leftChildIndex);
			return leftChildIndex;
		} else if (rightChild.compareTo(node) < 0) {
			swap(i, rightChildIndex);
			return rightChildIndex;
		}
		return i;
	}
	
	private void descend(int i) {
		int oldIndex = -1;
		int newIndex = i;
		while (oldIndex != newIndex) {
			oldIndex = newIndex;
			newIndex = descendLevel(newIndex);
		}
	}
	
	private int ascendLevel(int i) {
		Pair<T, P> node = data.get(i);
		int parentIndex = parent(i);
		Pair<T, P> parent = data.get(parentIndex);
		
		if (node.compareTo(parent) < 0) {
			swap(i, parentIndex);
			return parentIndex;
		} else {
			return i;
		}
	}
	
	private void ascend(int i) {
		int oldIndex = -1;
		int newIndex = i;
		while (oldIndex != newIndex) {
			oldIndex = newIndex;
			newIndex = ascendLevel(newIndex);
		}
	}
	
	private void balanceSubHeap(int i) {
		if (leftChild(i) >= this.size()) {
			return;
		}
		balanceSubHeap(leftChild(i));
		balanceSubHeap(leftChild(i)+1);
		descend(i);
	}

	@Override
	public int size() {
		return this.data.size();
	}
	@Override
	public void add(T value, P priority) {
		data.add(new Pair<T, P>(value, priority));
		indexMap.put(value, this.size()-1);
		
		if (this.size() == 1) {
			return;
		}
		
		ascend(this.size()-1);
	}

	@Override
	public T extractMin() {
		Pair<T, P> node = data.get(0);
		
		swap(0, this.size()-1);
		data.remove(this.size()-1);
		
		if (this.size() > 0) {
			descend(0);
		}
		
		return node.key;
	}

	@Override
	public void lowerKey(T value, P priority) {
		int i = indexMap.get(value);
		data.get(i).value = priority;
		ascend(i);
	}

}
