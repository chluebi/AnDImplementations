package dp;

import java.util.Arrays;

public class SubsetSum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(split(new int[] {2, 1, 3, 4})));
	}
	
	public static int[] split(int[] input) {
		
		int n = input.length;
		int posSum = 0;
		int negSum = 0;
		for (int i = 0; i < n; i++) {
			if (input[i] < 0) {
				negSum += input[i];
			} else {
				posSum += input[i];
			}
		}
		int sum = posSum + negSum;
		if (sum % 2 == 1) {
			return null;
		}
		
		int m = -negSum + posSum;
		boolean[][] dp = new boolean[n+1][m+1];
		
		for (int i = 0; i < n + 1; i++) {
			if (i > 0) {
				System.out.print(input[i-1] + "  ");
			} else {
				System.out.print("   ");
			}
			for (int j = 0; j < m+1; j++) {
				if (i == 0) {
					dp[i][j] = j == -negSum;
				}
				else if (dp[i-1][j]) {
					dp[i][j] = true;
				}
				else if (j-input[i-1] >= 0 && j-input[i-1] < m+1 && dp[i-1][j-input[i-1]]) {
					dp[i][j] = true;
				} else {
					dp[i][j] = false;
				}
				if (i > 0) {
					System.out.print((dp[i][j] ? "1":"0") + " ");
				} else {
					System.out.print(j + " ");
				}
			}
			System.out.println("");
		}
		
		if (!dp[n][-negSum + sum/2]) {
			return null;
		}
		
		int[] included = new int[n];
		int row = n;
		int column = -negSum + sum/2;
		
		while (true) {
			while (dp[row-1][column] == true && row > 1) {
				included[row-1] = 0;
				System.out.println("inner " + row + " " + column);
				System.out.println(Arrays.toString(included));
				row--;
			}
			if (row == 1) {
				break;
			}
			column -= input[row-1];
			included[row-1] = 1;
			System.out.println("outer " + row + " " + column);
			System.out.println(Arrays.toString(included));
			row--;
		}

		
		
		return included;
	}

}
