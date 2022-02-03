package graphs;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import adt.Pair;
import adt.UnionFind;
import adt.UnionList;
import sort.SortableArrayList;

public class Kruskal {
	public static Set<Pair<Integer, Integer>> MST(WeightedGraph graph) {
		Set<Pair<Integer, Integer>> mst = new HashSet<Pair<Integer, Integer>>();
		
		if (graph.nodes().size() < 2) {
			return mst;
		}
		
		SortableArrayList<Pair<Pair<Integer, Integer>, Integer>> list = new SortableArrayList<Pair<Pair<Integer, Integer>, Integer>>();
		
		Iterator<Pair<Pair<Integer, Integer>, Integer>> iterator = graph.edges().iterator();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		
		list.heapSort();
		UnionFind<Integer> unionFind = new UnionList<Integer>(graph.nodes());
		
		for (int i = 1; i < list.size(); i++) {
			Pair<Pair<Integer, Integer>, Integer> current = list.get(i);
			if (!unionFind.connected(current.key.key, current.key.value)) {
				unionFind.Union(current.key.key, current.key.value);
				mst.add(current.key);
			}
		}
		
		return mst;
	}
}
