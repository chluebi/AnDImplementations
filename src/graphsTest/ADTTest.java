package graphsTest;

import static org.junit.Assert.*;
import org.junit.Test;

import adt.LinkedList;
import adt.Queue;
import adt.Stack;
import adt.UnionFind;
import adt.UnionList;


public class ADTTest {

	@Test
	public void testQueue1() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.enqueue(0);
		assertEquals(1, queue.size());
		assertEquals(0, queue.dequeue().intValue());
		assertEquals(0, queue.size());
		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals(3, queue.size());
		assertEquals(0, queue.dequeue().intValue());
		assertEquals(2, queue.size());
		assertEquals(1, queue.dequeue().intValue());
		assertEquals(2, queue.dequeue().intValue());
	}
	
	
	@Test
	public void testStack1() {
		Stack<Integer> stack = new LinkedList<Integer>();
		stack.add(0);
		assertEquals(1, stack.size());
		assertEquals(0, stack.peek().intValue());
		assertEquals(0, stack.remove().intValue());
		assertEquals(0, stack.size());
		
		stack.add(0);
		stack.add(1);
		stack.add(2);
		assertEquals(3, stack.size());
		assertEquals(2, stack.peek().intValue());
		assertEquals(2, stack.remove().intValue());
		assertEquals(1, stack.remove().intValue());
		assertEquals(0, stack.remove().intValue());
		assertEquals(0, stack.size());
	}
	
	@Test
	public void testUnionFind() {
		int N = 10;
		Integer[] values = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			values[i] = i;
		}
		
		UnionFind<Integer> unionFind = new UnionList<Integer>(values);
		assertEquals(N, unionFind.size());
		
		for (int i = 0; i < N; i++) {
			assertEquals(i, unionFind.find(i).intValue());
		}
		
		unionFind.Union(0, 1);
		assertEquals(9, unionFind.size());
		assertEquals(true, unionFind.connected(0, 1));
		assertEquals(true, unionFind.connected(1, 0));
		assertEquals(false, unionFind.connected(0, 2));
		
		unionFind.Union(1, 2);
		assertEquals(8, unionFind.size());
		assertEquals(true, unionFind.connected(0, 2));
		
		unionFind.Union(3, 4);
		assertEquals(7, unionFind.size());
		unionFind.Union(1, 4);
		System.out.println(unionFind.find(0));
		System.out.println(unionFind.find(1));
		System.out.println(unionFind.find(3));
		System.out.println(unionFind.find(4));
		assertEquals(true, unionFind.connected(0, 3));
	}

}