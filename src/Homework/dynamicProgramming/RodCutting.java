package Homework.dynamicProgramming;



import java.util.*;

public class RodCutting {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] prices = new int[n+1];
		for (int i = 1; i <= n; i++){
			prices[i] = sc.nextInt();
		}
		int[] dp = new int[n+1];
				// initialize memo array with sentinel to indicate "not computed"
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;
		sc.close();
		System.out.println(RodCut(prices, dp, n));
	}

	public static int RodCut(int[] prices, int[] dp, int len){
		if (len == 0) return 0;
		if (dp[len] != Integer.MIN_VALUE) return dp[len];
		int current = Integer.MIN_VALUE;
		for (int i = 1; i <= len; i++){
			current = Math.max(current, prices[i] + RodCut(prices, dp, len-i));
		}
		dp[len] = current;
		return dp[len];
	}
}
