package Homework.greedy;


import java.util.*;

public class Activity {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // The number of intervals;
		int[][] intervals = new int[n][2];
		for (int i = 0; i < n; i++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			intervals[i][0] = start;
			intervals[i][1] = end;
		}
		int count = 0;
		Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
		int lastend = intervals[0][1];
		for (int i = 1; i < n; i++){
			if (intervals[i][0] < lastend)
				count++;
			else	lastend = intervals[i][1];
		}
		System.out.println(count);
		sc.close();
	}
}