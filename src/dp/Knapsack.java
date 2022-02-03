package dp;

public class Knapsack {

	public static void main(String[] args) {
		int[] values = {1, 5, 10, 15};
		int[] weights = {1, 3, 10, 20};
		
		System.out.println(positive(values, weights, 25));
	}
	
	public static int positive(int[] values, int[] weights, int weightLimit) {
		
		int[][] table = new int[values.length][weightLimit+1];
		
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < weightLimit+1; j++) {
				table[i][j] = 0;
				if (i > 0) {
					table[i][j] = Math.max(table[i][j], table[i-1][j]);
				}
				if (j > 0) {
					table[i][j] = Math.max(table[i][j], table[i][j-1]);
				}
				if (i > 0 && j - weights[i] >= 0) {
					table[i][j] = Math.max(table[i][j], table[i-1][j-weights[i]] + values[i]);
				} else if (j - weights[i] >= 0) {
					table[i][j] = Math.max(table[i][j], values[i]);
				}
			}
		}
		
		return table[values.length-1][weightLimit];
		
	}

}
