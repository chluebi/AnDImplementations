package sort;

public class MergeSort {
	
	public static Integer[] sort(Integer [] array) {
		int[] sorted = partition(array, 0, array.length);
		for (int i = 0; i < sorted.length; i++) {
			array[i] = sorted[i];
		}
		return array;
	}
	
	static int[] partition(Integer[] array, int l, int r) {
		System.out.println(l + " / " + r);
		if (l + 1 == r) {
			System.out.println("one element");
			return new int[] {array[l]};
		} else if (l + 1 > r) {
			System.out.println("no element");
			return new int[] {};
		}
		
		int mid = (r-l)/2;
		int[] left = partition(array, l, mid);
		int[] right = partition(array, mid, r);
		
		int[] merge = new int[r-l];
		
		int i = 0;
		int j = 0;
		
		while (i+j < r-l) {
			if (j >= right.length || (i < left.length && left[i] <= right[j])) {
				merge[i+j] = left[i];
				i++;
			} else {
				merge[i+j] = right[j];
				j++;
			}
		}
		return merge;
	}
}
