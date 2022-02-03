package dp;

public class LongestPalindromicSubstring {
	
	public static void main(String[] args) {
		String s = "AACBCA";
		int r = solve(s);
		System.out.println(r);
	}
	
	public static int solve(String word) {
		int[][] DP = new int[word.length()][word.length()];
		int max = 0;
		
		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; i+j < word.length(); j++) {
				int y = j;
				int x = i+j;
				
				if (y == x) {
					DP[y][x] = 1;
				} else {
					if (word.charAt(y) == word.charAt(x)) {
						DP[y][x] = DP[y+1][x-1] + 2;
					} else {
						DP[y][x] = 0;
					}
				}
				max = Math.max(max, DP[y][x]);
			}
		}
		
		return max;
	}
}
