package sort;

import adt.MinHeap;

public class HeapSort {
	
	public static Integer[] sort(Integer[] array) {
		MinHeap<Integer, Integer> heap = new MinHeap<Integer, Integer>(array, array);
		
		for (int i = 0; i < array.length; i++) {
			array[i] = heap.extractMin();
		}
		
		return array;
	}
}
