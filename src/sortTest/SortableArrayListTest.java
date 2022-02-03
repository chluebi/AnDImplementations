package sortTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import sort.SortableArrayList;
import sort.SortableList;

public class SortableArrayListTest {
	
	@Test
	public void heapSortTest1() {
		SortableList<Integer> list;
		SortableList<Integer> expected;
		
		list = new SortableArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(2);
		
		expected = new SortableArrayList<Integer>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		
		list.heapSort();
		
		assertEquals(expected, list);
	}
}
