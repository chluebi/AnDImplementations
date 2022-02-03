package sort;

import java.util.ArrayList;
import adt.MinHeap;

public class SortableArrayList<T extends Comparable<T>> extends ArrayList<T> implements SortableList<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void heapSort() {
		MinHeap<T, T> heap = new MinHeap<T, T>();
		while (this.size() > 0) {
			T element = this.get(0);
			heap.add(element, element);
			this.remove(0);
		}
		while (heap.size() > 0) {
			T element = heap.extractMin();
			this.add(element);
		}
	}

}
