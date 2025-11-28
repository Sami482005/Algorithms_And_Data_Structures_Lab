package tutoring.DP;

import java.util.*;

public class MaxSumSubarray {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i =0; i<n; i++){
			nums[i] = sc.nextInt();
		}
		int max = Integer.MIN_VALUE;
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MIN_VALUE);
		int start = 0;
		int sum = 0;
		int end = 0;
		dp[0] = nums[0];
		for (int i = 1; i < n; i++){
			if (dp[i-1] + nums[i] < nums[i]){
				start = i;
				sum = nums[i];
			}
			else
				sum += nums[i];
			dp[i] = Math.max(dp[i-1] + nums[i], nums[i]); 
			if (sum > max){
				max = sum;
				end = i;
			}
		}
		System.out.println("The max sum subarray = " + max);
		for (int i = start; i < end; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();

		sc.close();

	}

}
