package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import adt.Pair;

public class WeightedAdjacencyList implements WeightedGraph {
	
	ArrayList<Pair<Integer, Integer>>[] edges;
	
	public WeightedAdjacencyList(ArrayList<Pair<Integer, Integer>>[] input) {
		this.edges = input;
	}
	
	public WeightedAdjacencyList(int[][][] input) {
		ArrayList<Pair<Integer, Integer>>[] list = new ArrayList[input.length];
		
		for (int i = 0; i < input.length; i++) {
			list[i] = new ArrayList<Pair<Integer, Integer>>();
		}
		
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				
				list[i].add(new Pair<Integer, Integer>(input[i][j][0], input[i][j][1]));
			}
		}
		
		this.edges = list;
	}
	
	public WeightedAdjacencyList(int[][] input, int n) {
		ArrayList<Pair<Integer, Integer>>[] list = new ArrayList[n];
		
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<Pair<Integer, Integer>>();
		}
		
		for (int i = 0; i < input.length; i++) {
			list[input[i][0]].add(new Pair<Integer, Integer> (input[i][1], input[i][2]));
		}
		
		this.edges = list;
	}
	
	public WeightedAdjacencyList(Integer[][] input) {
		ArrayList<Pair<Integer, Integer>>[] list = new ArrayList[input.length];
		
		for (int i = 0; i < input.length; i++) {
			list[i] = new ArrayList<Pair<Integer, Integer>>();
		}
		
		for (int i = 0; i  < input.length; i++) {
			for (int j = 0; j  < input.length; j++) {
				if (input[i][j] != null) {
					list[i].add(new Pair<Integer, Integer>(j, input[i][j]));
				}
			}
		}
		this.edges = list;
	}

	@Override
	public Set<Pair<Pair<Integer, Integer>, Integer>> edges() {
		Set<Pair<Pair<Integer, Integer>, Integer>> set = new HashSet<Pair<Pair<Integer, Integer>, Integer>>();
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges[i].size(); j++) {
				set.add(new Pair<Pair<Integer, Integer>, Integer>(new Pair<Integer, Integer>(i, edges[i].get(j).key), edges[i].get(j).value));
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
	public void addEdge(int a, int b, int weight) {
		Pair<Integer, Integer> newPair = new Pair<Integer, Integer>(b, weight);
		if (edges[a].contains(newPair)) {
			return;
		}
		edges[a].add(newPair);
	}

	@Override
	public boolean hasEdge(int a, int b) {
		for (int i = 0; i < edges[a].size(); i++) {
			if (edges[a].get(i).key.equals(b)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterable<Pair<Integer, Integer>> neighbors(int a) {
		return edges[a];
	}

	@Override
	public int weight(int a, int b) {
		for (int i = 0; i < edges[a].size(); i++) {
			if (edges[a].get(i).key.equals(b)) {
				return edges[a].get(i).value;
			}
		}
		return -1;
	}

}
