package graphs;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import adt.Pair;

public class AdjacencyList implements Graph {
	
	public ArrayList<Integer>[] edges;
	
	public AdjacencyList(ArrayList<Integer>[] input) {
		this.edges = input;
	}
	
	public AdjacencyList(int[][] input) {
		ArrayList<Integer>[] list = new ArrayList[input.length];
		
		for (int i = 0; i < input.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				
				list[i].add(input[i][j]);
			}
		}
		
		this.edges = list;
	}
	
	public AdjacencyList(int[][] input, int n) {
		ArrayList<Integer>[] list = new ArrayList[n];
		
		for (int i = 0; i < input.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < input.length; i++) {
			list[input[i][0]].add(input[i][1]);
		}
		
		this.edges = list;
	}
	
	public AdjacencyList(boolean[][] input) {
		ArrayList<Integer>[] list = new ArrayList[input.length];
		
		for (int i = 0; i < input.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i  < input.length; i++) {
			for (int j = 0; j  < input.length; j++) {
				if (input[i][j]) {
					list[i].add(j);
				}
			}
		}
		this.edges = list;
	}
	

	@Override
	public Set<Pair<Integer, Integer>> edges() {
		Set<Pair<Integer, Integer>> set = new HashSet<Pair<Integer, Integer>>();
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges[i].size(); j++) {
				set.add(new Pair<Integer, Integer>(i, edges[i].get(j)));
			}
		}
		return set;
	}

	@Override
	public Set<Integer> nodes() {
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < edges.length; i++) {
			set.add(i);
		}
		return set;
	}

	@Override
	public void addEdge(int a, int b) {
		if (edges[a].contains(b)) {
			return;
		}
		edges[a].add(b);
	}

	@Override
	public boolean hasEdge(int a, int b) {
		return edges[a].contains(b);
	}

	@Override
	public Iterable<Integer> neighbors(int a) {
		return edges[a];
	}
}
