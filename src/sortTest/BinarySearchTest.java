package sortTest;

import static org.junit.Assert.*;
import org.junit.Test;

import sort.BinarySearch;

public class BinarySearchTest {
	
	@Test
	public void binarySearchTest1() {
		Integer[] array;
		for (int i = 1; i < 100; i++) {
			array = new Integer[i];
			for (int j = 0; j < i; j++) {
				array[j] = j;
			}
			for (int j = 0; j < i; j++) {
				assertEquals(j, BinarySearch.find(array, j));
			}
		}
	}

}
