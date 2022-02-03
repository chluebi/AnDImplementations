package graphsTest;

import org.junit.Test;

import graphs.Prim;
import graphs.Kruskal;
import graphs.WeightedGraph;
import adt.Pair;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

public class MSTTest {
	
	public static int MSTsum(Set<Pair<Integer, Integer>> mst, WeightedGraph graph) {
		int sum = 0;
		Iterator<Pair<Integer, Integer>> iterator = mst.iterator();
		while (iterator.hasNext()) {
			Pair<Integer, Integer> nextPair = iterator.next();
			sum += graph.weight(nextPair.key, nextPair.value);
		}
		return sum;
	}
	
	@Test
	public void PrimTest() {
		WeightedGraph graph = sampleWeightedGraphs.graph3();
		Set<Pair<Integer, Integer>> mst = Prim.MST(graph);
		int result = MSTsum(mst, graph);
		assertEquals(3, result);
		
		
		graph = sampleWeightedGraphs.graph4();
		mst = Prim.MST(graph);
		result = MSTsum(mst, graph);
		assertEquals(100, result);
		
		graph = sampleWeightedGraphs.graph5();
		mst = Prim.MST(graph);
		result = MSTsum(mst, graph);
		assertEquals(5, result);
	}
	
	@Test
	public void KruskalTest() {
		WeightedGraph graph = sampleWeightedGraphs.graph3();
		Set<Pair<Integer, Integer>> mst = Kruskal.MST(graph);
		int result = MSTsum(mst, graph);
		assertEquals(3, result);
		
		
		graph = sampleWeightedGraphs.graph4();
		mst = Kruskal.MST(graph);
		result = MSTsum(mst, graph);
		assertEquals(100, result);
		
		graph = sampleWeightedGraphs.graph5();
		mst = Kruskal.MST(graph);
		result = MSTsum(mst, graph);
		assertEquals(5, result);
	}
	
}
