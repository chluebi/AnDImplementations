package sort;

public class BinarySearch {

	public static void main(String[] args) {
		Integer[] array = new Integer[]{1, 2, 3, 4, 5};
		System.out.print(find(array, 4));
	}
	
	public static int find(Comparable[] array, Comparable o) {
		return find(array, o, 0, array.length-1);
	}
	
	private static int find(Comparable[] array, Comparable o, int l, int r) {
		int pivot = (l + r)/2;
		
		if (array[pivot].equals(o)) {
			return pivot;
		} else if (o.compareTo(array[pivot]) > 0) {
			return find(array, o, pivot+1, r);
		} else {
			return find(array, o, l, pivot-1);
		}
	}

}
