package tutoring.DP;

import java.util.*;

public class LCS {
	public static int LCS(String s1, String s2, int n, int m, int[][] dp){
		if(n == 0 || m == 0) return 0;
		if (dp[n][m] != Integer.MIN_VALUE) return dp[n][m];

		if (s1.charAt(n-1) == s2.charAt(m-1))
			dp[n][m] = 1 + LCS(s1, s2, n-1, m-1, dp);
		else
			dp[n][m] = Math.max(LCS(s1, s2, n-1, m, dp), LCS(s1, s2, n, m-1, dp));
		return dp[n][m];
	}
	public static String LCSString(String s1, String s2, int n, int m){
		int[][] dp = new int[n+1][m+1];
		Arrays.fill(dp, Integer.MIN_VALUE);
		int len = LCS(s1, s2, n, m, dp);
		int i = n, j=m;
		char[] ans = new char[len];
		while (i>0 && j>0){
			if (s1.charAt(i-1) == s2.charAt(j-1)){
				ans[len-1] = s1.charAt(i-1);
				i--;
				j--;
				len--; 
			}
			else{
				if (dp[i][j-1] > dp[i-1][j])
					j--;
				else
					i--;
			}
		}
		return new String(ans);
	}
}
