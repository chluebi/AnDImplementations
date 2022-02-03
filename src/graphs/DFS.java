package graphs;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Iterator;

public class DFS {
	
	static class PostComparator implements Comparator<Integer> {
		
		public int[] post;
		public boolean[] visited;

		@Override
		public int compare(Integer a, Integer b) {
			if (!visited[a] && !visited[b]) {
				return 1;
			}
			if (visited[a] && !visited[b]) {
				return 1;
			}
			if (!visited[a] && visited[b]) {
				return -1;
			}
			return post[a] > post[b] ? 1 : -1;
		}
		
	}

	public static ArrayList<Integer> topologicalSort(Graph graph, int start) {
		int n = graph.nodes().size();
		boolean[] visited = new boolean[n];
		int[] pre = new int[n];
		int[] post = new int[n];
		for (int i = 0; i < n; i++) {
			pre[i] = -1;
			post[i] = -1;
		}
		
		Integer current = Integer.valueOf(0);
		visited[start] = true;
		DFSVisitnoCycle(graph, start, visited, pre, post, current);
		
		PostComparator comparator = new PostComparator();
		comparator.post = post;
		comparator.visited = visited;
		TreeSet<Integer> order = new TreeSet<Integer>(comparator);
		for (int i = 0; i < n; i++) {
			order.add(i);
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		Iterator<Integer> iterator = order.iterator();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		
		return list;
	}
	
	public static int DFSVisitnoCycle(Graph graph, int node, boolean[] visited, int[] pre, int[] post, Integer current) {
		pre[node] = current;
		current++;
		
		for (int neighbor: graph.neighbors(node)) {
			if (visited[neighbor]) {
				if (post[neighbor] == -1) {
					throw new IllegalArgumentException("Cycle found");
				}
			} else {
				visited[neighbor] = true;
				current = DFSVisitnoCycle(graph, neighbor, visited, pre, post, current);
			}
		}
		
		post[node] = current;
		current++;
		return current;
	}
	
	public static boolean isCyclic (Graph graph) {
		try {
			for (int i = 0; i < graph.nodes().size(); i++) {
				topologicalSort(graph, i);
			}
		} catch (IllegalArgumentException e) {
			return true;
		}
		return false;
	}

}
