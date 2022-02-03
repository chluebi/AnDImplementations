package graphs;

import adt.Queue;
import adt.LinkedList;

public class BFS {
	
	public static int[] distances(Graph graph, int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] distances = new int[graph.nodes().size()];
		for (int i = 0; i < distances.length; i++) {
			distances[i] = -1;
		}
		boolean[] visited = new boolean[graph.nodes().size()];
		
		distances[start] = 0;
		visited[start] = true;
		queue.enqueue(start);
		
		while (queue.size() > 0) {
			int current = queue.dequeue();
			for (int neighbor: graph.neighbors(current)) {
				if (!visited[neighbor]) {
					visited[neighbor] = true;
					distances[neighbor] = distances[current] + 1;
					queue.enqueue(neighbor);
				}
			}
		}
		return distances;
	}
	
}
