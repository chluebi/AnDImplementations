package graphs;

import adt.Pair;

public class BellmanFord {
	
	public static int[] distances(WeightedGraph g, int start) {
		int[] d = new int[g.nodes().size()];
		int[] p = new int[g.nodes().size()];
		
		for (int i = 0; i < g.nodes().size(); i++) {
			d[i] = Integer.MAX_VALUE;
		}
		
		d[start] = 0;
		p[start] = start;
		
		for (int i = 0; i < g.nodes().size(); i++) {
			for (Pair<Pair<Integer, Integer>, Integer> edge : g.edges()) {
				int u = edge.key.key;
				int v = edge.key.value;
				int w = edge.value;
				if (d[v] > d[u] + w) {
					d[v] = d[u] + w;
					p[v] = u;
				}
			}
		}
		
		for (Pair<Pair<Integer, Integer>, Integer> edge : g.edges()) {
			int u = edge.key.key;
			int v = edge.key.value;
			int w = edge.value;
			if (d[v] > d[u] + w) {
				throw new IllegalArgumentException("Negative cycle");
			}
		}
		
		return d;
	}
}
