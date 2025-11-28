package tutoring.DP;

import java.util.*;

public class Chess {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[][] grid = new int[8][8];
		for (int i = 0; i < 8; i++){
			for (int j = 0; j < 8; j++)
				grid[i][j] = sc.nextInt();
		}
		int[][] dp = new int[8][8];
		dp[7][0] = grid[7][0];
		for (int i = 6; i>=0; i--){
			dp[i][0] = dp[i+1][0] + grid[i][0];
		}
		for (int j = 1; j < 8; j++){
			dp[7][j] = dp[7][j-1] + grid[7][j];
		}
		for (int i = 6; i >=0; i--){
			for (int j = 1; j < 8; j++){
				dp[i][j] = grid[i][j] + Math.min(dp[i+1][j-1], Math.min(dp[i+1][j], dp[i][j-1]));
			}
		}
		sc.close();
		System.out.println(dp[0][7]);
	}
}


/*
9 9 9 9 9 9 1 9
9 9 9 9 9 1 9 2
9 9 9 9 9 9 1 9
9 9 9 9 9 9 9 9  
9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9
9 9 9 9 9 9 9 9
0 9 9 9 9 9 9 9
 */
