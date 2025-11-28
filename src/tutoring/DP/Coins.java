package tutoring.DP;

import java.util.*;

public class Coins {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int X = sc.nextInt();

		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}

		int[] dp = new int[X+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int c : coins){
			for (int s = c; s <= X; s++){
				dp[s] = Math.min(dp[s], dp[s-c] + 1);
			}
		}

		sc.close();
		System.out.println(dp[X] == Integer.MAX_VALUE ? -1 : dp[X]);
	}
}
