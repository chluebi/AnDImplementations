package dp;

public class MatrixChainMultiplication {
	
	public static void main(String[] args) {
		int[][] m = {new int[] {5, 4}, new int[] {4, 6}, new int[] {6, 2}, new int[] {2, 7}, new int[] {7, 3}};
		int r = solve(m);
		System.out.println(r);
	}
	
	public static int solve(int[][] matrices) {
		
		int[][] DP = new int[matrices.length][matrices.length];
		
		for (int i = 0; i < matrices.length; i++) {
			for (int j = 0; i+j < matrices.length; j++) {
				
				int y = j;
				int x = i+j;
				
				if (y == x) {
					DP[y][x] = 0;
					continue;
				}
				
				int min = Integer.MAX_VALUE;
				
				for (int k = y; k < x; k++) {
					int mult = matrices[y][0] * matrices[k][1] * matrices[x][1];
					int left = DP[y][k];
					int right = DP[k+1][x];
					min = Math.min(min, left+right+mult);
				}
				
				DP[y][x] = min;
			}
		}
		
		return DP[0][matrices.length-1];
	}
}
