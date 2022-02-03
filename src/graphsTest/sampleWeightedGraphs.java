package graphsTest;

import graphs.WeightedAdjacencyList;
import graphs.WeightedGraph;

public class sampleWeightedGraphs {
	
	public static WeightedGraph graph0() {
		return new WeightedAdjacencyList(new Integer[][] {{null, 1, 5}, {2, null, 2}, {1, 0, null}});
	}
	
	public static WeightedGraph graph1() {
		return new WeightedAdjacencyList(new Integer[][] {{0, 1, null}, {null, 0, 99}, {null, 0, null}});
	}
	
	public static WeightedGraph graph2() {
		return new WeightedAdjacencyList(new int[][] {{0, 1, 99}, {0, 2, 1}, {2, 1, 3}, {1, 3, 1}, {2, 3, 5}}, 4);
	}
	
	public static WeightedGraph graph3() {
		return new WeightedAdjacencyList(new Integer[][] {{null, 1, 5}, {1, null, 2}, {5, 2, null}});
	}
	
	public static WeightedGraph graph4() {
		return new WeightedAdjacencyList(new Integer[][] {{0, 1, null}, {1, 0, 99}, {null, 99, 0}});
	}
	
	public static WeightedGraph graph5() {
		return new WeightedAdjacencyList(new int[][] {{0, 1, 99}, {0, 2, 1}, {2, 1, 3}, {1, 3, 1}, {2, 3, 5}, {1, 0, 99}, {2, 0, 1}, {1, 2, 3}, {3, 1, 1}, {3, 2, 5}}, 4);
	}
}
