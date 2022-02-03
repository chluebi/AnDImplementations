package dp;

public class LongestCommonSubsequence {
	
	public static void main(String[] args) {
		int r = solve("ABC", "ADAEB");
		System.out.println(r);
	}
	
	public static int solve(String a, String b) {
		
		int[][] DP = new int[a.length()+1][b.length()+1];
		
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				if (i == 0 && j == 0) {
					DP[i][j] = 0;
				} else {
					int top = i > 0 ? DP[i-1][j] : Integer.MIN_VALUE;
					int left = j > 0 ? DP[i][j-1] : Integer.MIN_VALUE;
					int diagonal = Integer.MIN_VALUE;
					
					if (i > 0 && j > 0) {
						diagonal = DP[i-1][j-1];
						if (a.charAt(i-1) == b.charAt(j-1)) {
							diagonal ++;
						}
					}
					
					DP[i][j] = Math.max(Math.max(top, left), diagonal);
				}
			}
		}
		
		return DP[a.length()][b.length()];
	}
}
