package tutoring.DP;

import java.util.*;

public class Water {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] prices = new int [n];
		for (int i = 0; i < n; i++){
			prices[i] = sc.nextInt();
		}
		int[][] dp = new int[n][n];
		
		for (int i = 0; i < n; i++)
			dp[i][i] = n * prices[i];
		for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                int year = n - (r - l);

                int sellLeft = year * prices[l] + dp[l + 1][r];
                int sellRight = year * prices[r] + dp[l][r - 1];

                dp[l][r] = Math.max(sellLeft, sellRight);
            }
        }

		sc.close();
        System.out.println(dp[0][n - 1]);

	}

}
