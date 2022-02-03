package graphs;

import adt.MinHeap;
import adt.Pair;
import adt.PriorityQueue;

public class Dijkstra {
	
	public static int[] distances(WeightedGraph g, int start) {
		
		PriorityQueue<Integer, Integer> queue = new MinHeap<Integer, Integer>();
		queue.add(start, 0);
		
		boolean[] visited = new boolean[g.nodes().size()];
		int[] distances = new int[g.nodes().size()];
		
		visited[start] = true;
		distances[start] = 0;
		
		while (queue.size() > 0) {
			Integer node = queue.extractMin();
			for (Pair<Integer, Integer> neighbor: g.neighbors(node)) {
				if (visited[neighbor.key]) {
					if (distances[neighbor.key] > distances[node] + neighbor.value) {
						distances[neighbor.key] = distances[node] + neighbor.value;
						queue.lowerKey(neighbor.key, distances[node] + neighbor.value);
					}
				} else {
					visited[neighbor.key] = true;
					distances[neighbor.key] = distances[node] + neighbor.value;
					queue.add(neighbor.key, distances[neighbor.key]);
				}
			}
		}
		
		return distances;
	}

}
