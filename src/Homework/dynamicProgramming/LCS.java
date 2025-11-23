package Homework.dynamicProgramming;


import java.util.*;

public class LCS {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n+1][m+1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], -1);
		}
		LCSHelper(s1, s2, n, m, dp);
		System.out.println(dp[n][m]);
		sc.close();
	}

	public static int LCSHelper(String s1, String s2, int n, int m, int[][] dp){
		if (n == 0 || m == 0)
			return 0;
		if (dp[n][m] != -1)
			return dp[n][m];
		if (s1.charAt(n-1) == s2.charAt(m-1))
			dp[n][m] = 1 + LCSHelper(s1, s2, n-1, m-1, dp);
		else{
			dp[n][m] = Math.max(LCSHelper(s1, s2, n-1, m, dp), LCSHelper(s1, s2, n, m-1, dp));
		}
		return dp[n][m];
	}
}
