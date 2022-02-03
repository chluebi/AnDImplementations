package graphsTest;

import graphs.AdjacencyList;
import graphs.Graph;


public class sampleGraphs {
	
	public static Graph graph0() {
		return new AdjacencyList(new int[][] {{1, 2}, {2}, {}});
	}
	public static Graph graph1() {
		return new AdjacencyList(new int[][] {{1}, {0}, {}});
	}
	public static Graph graph2() {
		return new AdjacencyList(new int[][] {{1}, {2}, {3}, {0}});
	}
	public static Graph graph3() {
		return new AdjacencyList(new int[][] {{1, 2, 3}, {2, 3}, {3}, {}});
	}
	
}
