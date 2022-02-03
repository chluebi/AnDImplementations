package graphs;

import java.util.Set;
import adt.Pair;

public interface WeightedGraph {
	Set<Pair<Pair<Integer, Integer>, Integer>> edges();
	Set<Integer> nodes();
	void addEdge(int a, int b, int w);
	boolean hasEdge(int a, int b);
	Iterable<Pair<Integer, Integer>> neighbors(int a);
	int weight(int a, int b);
}
