package graphsTest;

import static org.junit.Assert.*;
import org.junit.Test;

import graphs.BFS;
import graphs.Graph;


public class BFSTest {
	
	@Test
	public void testDistances() {
		Graph g0 = sampleGraphs.graph0();
		int[] result = BFS.distances(g0, 0);
		int[] expected = new int[] {0, 1, 1};
		assertArrayEquals(expected, result);
		
		Graph g1 = sampleGraphs.graph1();
		result = BFS.distances(g1, 0);
		expected = new int[] {0, 1, -1};
		assertArrayEquals(expected, result);
		result = BFS.distances(g1, 1);
		expected = new int[] {1, 0, -1};
		assertArrayEquals(expected, result);
		result = BFS.distances(g1, 2);
		expected = new int[] {-1, -1, 0};
		assertArrayEquals(expected, result);
		
		Graph g2 = sampleGraphs.graph2();
		result = BFS.distances(g2, 0);
		expected = new int[] {0, 1, 2, 3};
		assertArrayEquals(expected, result);
		
		Graph g3 = sampleGraphs.graph3();
		result = BFS.distances(g3, 0);
		expected = new int[] {0, 1, 1, 1};
		assertArrayEquals(expected, result);
	}
	

}