package dp;

public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		int r = solve(new int[] {1, 2, 1, 4, 5, 1, 2, 3});
		System.out.println(r);
	}
	
	public static int solve(int[] array) {
		int max = 0;
		
		int[] DP = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			int j = max;
			
			while (j > 0 && array[i] <= DP[j-1]) {
				j--;
			}
			
			DP[j] = array[i];
			max = Math.max(j+1, max);
		}
		
		return max;
	}
}
