package graphs;

import adt.Pair;
import adt.UnionFind;
import adt.UnionList;
import adt.PriorityQueue;
import adt.MinHeap;
import java.util.HashSet;
import java.util.Set;

public class Prim {
	
	public static Set<Pair<Integer, Integer>> MST(WeightedGraph graph) {
		Set<Pair<Integer, Integer>> mst = new HashSet<Pair<Integer, Integer>>();
		
		if (graph.nodes().size() < 1) {
			return mst;
		}
		
		PriorityQueue<Pair<Integer, Integer>, Integer> queue = new MinHeap<Pair<Integer, Integer>, Integer>();
		
		Integer[] nodes = new Integer[graph.nodes().size()];
		for (int i = 0; i < graph.nodes().size(); i++) {
			nodes[i] = i;
		}
		UnionFind<Integer> unionFind = new UnionList<Integer>(nodes);
		
		
		queue.add(new Pair<Integer, Integer>(0, 0), 0);
		while (mst.size() < graph.nodes().size() - 1 && queue.size() > 0) {
			Pair<Integer, Integer> node = queue.extractMin();
			if (!node.key.equals(node.value)) {
				mst.add(new Pair<Integer, Integer>(node.key, node.value));
			}
			unionFind.Union(node.key, node.value);
			for (Pair<Integer, Integer> neighbor: graph.neighbors(node.value)) {
				if (!unionFind.connected(0, neighbor.key)) {
					queue.add(new Pair<Integer, Integer>(node.value, neighbor.key), neighbor.value);
				}
			}
		}
		
		return mst;
	}
}
