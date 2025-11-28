package labs;

import java.util.*;

public class Zeina {

	/*
	* This code is running in O(n) because it is storing the results in an array dp.
	If the result is found, it will be returned O(1)
	Else we make a call for n-1,
	which basically means the running time for the code is: T(n) = T(n-1) + O(1) // It is already stored that's why O(1)
	so the running time is O(n)
	I assumed that money is indexed starting 1
	Then we are looping over the dp array which is O(n)
	So total running time: T(n) = O(n) + O(n) = O(n)
	*/

	public static int helper(int[][] money, int[] dp, int n){
		if (n == 0) return 0;
		

		if (n == 1){
			return dp[1] = money[1][0]; // The first column contains the number of houses in the compound
		}
		if (n == 2){
			dp[n] = Math.max(money[1][0], money[2][0]);
			return dp[n];
		}
		if (dp[n] != Integer.MAX_VALUE) return dp[n];

		// Zeina doesn't want the compounds to be consecutive. So we either take n-1, or we take n-2 and n
		int take = helper(money, dp, n-1);
		int notake = helper(money, dp, n-2) + money[n][0];
		dp[n] = Math.max(take, notake);
		return dp[n];
	}



	public static List<Integer> chosenCompounds(int[][] money){
		int n = money.length-1;
		int[] dp = new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		helper(money, dp, n);
		List<Integer> ans = new ArrayList<>();
		int i = n;
		while (i > 0) {
			if (i == 1) {
				ans.add(1);
				break;
			} 
			else if (i == 2) {
				if (money[1][0] > money[2][0]) {
					ans.add(1);
				} 
				else {
					ans.add(2);
				}
				break;
			} 
			else {
				// If i and i-2 were taken we add i
				if (dp[i-2] + money[i][0] > dp[i-1]) {
					ans.add(i);
					i -= 2;
				} 
				else 
					// We didn't take i we are taking i-1
					i -= 1;
			}
		}
		return ans;
	}
}
