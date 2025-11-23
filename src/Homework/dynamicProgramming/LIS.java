package Homework.dynamicProgramming;




import java.util.*;

public class LIS {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] s = new int[n];
		for (int i = 0; i < n; i++)
			s[i] = sc.nextInt();
		int[] dp = new int[n];
		System.out.println(LISHelper(s, dp));
		sc.close();
	}

	public static int LISHelper(int[] s, int[] dp){
		int n = s.length;
		if (n == 0) return 0;
		// initialize dp values to 1 (each element itself)
		int max = 1;
		for (int i = 0; i < n; i++){
			dp[i] = 1;
			for (int j = 0; j < i; j++){
				if (s[j] < s[i]){
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
