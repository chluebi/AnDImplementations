package graphsTest;

import static org.junit.Assert.*;
import org.junit.Test;

import graphs.DFS;
import graphs.Graph;

import java.util.List;
import java.util.ArrayList;



public class DFSTest {
	
	public static List<Integer> ArrayToList(int[] array) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}

	@Test
	public void testTopoSort1() {
		Graph g0 = sampleGraphs.graph0();
		List<Integer> result = DFS.topologicalSort(g0, 0);
		List<Integer> expected = ArrayToList(new int[] {2, 1, 0});
		assertEquals(expected, result);
		
		Graph g1 = sampleGraphs.graph1();
		boolean thrown = false;
		try {
			result = DFS.topologicalSort(g1, 0);
		}
		catch (IllegalArgumentException e) {
			thrown = true;
		}
		assertTrue(thrown);
		
		Graph g2 = sampleGraphs.graph2();
		thrown = false;
		try {
			result = DFS.topologicalSort(g2, 0);
		}
		catch (IllegalArgumentException e) {
			thrown = true;
		}
		assertTrue(thrown);
		
		Graph g3 = sampleGraphs.graph3();
		result = DFS.topologicalSort(g3, 0);
		expected = ArrayToList(new int[] {3, 2, 1, 0});
		assertEquals(expected, result);
	}
	
	
	@Test
	public void isCyclic() {
		assertTrue(!DFS.isCyclic(sampleGraphs.graph0()));
		assertTrue(DFS.isCyclic(sampleGraphs.graph1()));
		assertTrue(DFS.isCyclic(sampleGraphs.graph2()));
		assertTrue(!DFS.isCyclic(sampleGraphs.graph3()));
	}

}