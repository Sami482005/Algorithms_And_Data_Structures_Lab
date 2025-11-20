package tutoring.greedy;


import java.util.*;

public class Pairing {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] wts = new int[n];
		int count = 0;

		for (int i = 0; i < n; i++){
			wts[i] = sc.nextInt();
		}
		Arrays.sort(wts);

		int i = 0, j = n-1;
		while (i <= j){
			if (wts[i] + wts[j] <= x){
				count++;
				i++;
				j--;
			}
			else{
				j--;
				count++;
			}
		}
		sc.close();
		System.out.println(count);
	}
}
