package sortTest;

import static org.junit.Assert.*;
import org.junit.Test;

import sort.MergeSort;

public class MergeSortTest {
	
	@Test
	public void mergeSortTest1() {
		Integer[] array = new Integer[] {3, 2, 1};
		Integer[] result = MergeSort.sort(array);
		Integer[] expected = new Integer[] {1, 2, 3};
		assertArrayEquals(expected, result);
		
		array = new Integer[] {1, 100, 99};
		result = MergeSort.sort(array);
		expected = new Integer[] {1, 99, 100};
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void mergeSortTest2() {
		int N = 1000 * 1000;
		
		Integer[] array = new Integer[N];
		Integer[] expected = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			array[N-1-i] = i;
			expected[i] = i;
		}
		
		Integer[] result = MergeSort.sort(array);
		assertArrayEquals(expected, result);
		
	}

}
