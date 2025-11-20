package Homework.greedy;


import java.util.*;

public class ActSel {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] interval = new int[n][2];
		for (int i = 0; i < n; i++){
			interval[i][0] = sc.nextInt();
			interval[i][1] = sc.nextInt();
		}
		int count = 0;
		Arrays.sort(interval, (a, b) -> Integer.compare(a[1], b[1]));
		int endingTime = interval[0][1];

		for (int i = 1; i < n; i++){
			if (interval[i][0] < endingTime)
				count++;
			else
				endingTime = interval[i][1];
		}
		System.out.println(count);
		sc.close();
	}
}
