package graphsTest;

import static org.junit.Assert.*;
import org.junit.Test;

import graphs.Dijkstra;
import graphs.WeightedGraph;


public class DijkstraTest {
	
	@Test
	public void testDijkstra1() {
		WeightedGraph g = sampleWeightedGraphs.graph0();
		int[] result = Dijkstra.distances(g, 0);
		int[] expected = new int[] {0, 1, 3};
		assertArrayEquals(expected, result);
		
		g = sampleWeightedGraphs.graph1();
		result = Dijkstra.distances(g, 0);
		expected = new int[] {0, 1, 100};
		assertArrayEquals(expected, result);
		
	}
	
	@Test
	public void testDijkstra2() {
		WeightedGraph g = sampleWeightedGraphs.graph2();
		int[] result = Dijkstra.distances(g, 0);
		int[] expected = new int[] {0, 4, 1, 5};
		assertArrayEquals(expected, result);
	}
}
