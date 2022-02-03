package test;

public class UnionFind {
	
    int[] parent;
    
    public static void main(String[] args) {
    	UnionFind unionFind = new UnionFind(4);
    	System.out.println(unionFind.find(0));
    	System.out.println(unionFind.find(1));
    	System.out.println(unionFind.find(2));
    	System.out.println(unionFind.find(3));
    	unionFind.union(0, 1);
    	unionFind.union(2, 3);
    	unionFind.union(1, 3);
    	System.out.println(unionFind.find(0));
    	System.out.println(unionFind.find(1));
    	System.out.println(unionFind.find(2));
    	System.out.println(unionFind.find(3));
    }

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x)
            return x;
        return find(parent[x]);
    }

    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (Math.random() == 1) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }
}
