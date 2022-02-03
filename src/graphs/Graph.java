package graphs;

import java.util.Set;
import adt.Pair;

public interface Graph {
	Set<Pair<Integer, Integer>> edges();
	Set<Integer> nodes();
	void addEdge(int a, int b);
	boolean hasEdge(int a, int b);
	Iterable<Integer> neighbors(int a);
}
