package tutoring.Graph;

import java.util.Scanner;

public class Graphs1 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // number of cities
		while (N < 2)
			N = sc.nextInt();
        int M = sc.nextInt();  // number of roads
		while (M > 55)
			M = sc.nextInt();

        int[] degree = new int[N + 1]; // 1-based indexing

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
			if (a != b){
            	degree[a]++;
            	degree[b]++; // since roads are bidirectional
			}
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(degree[i]);
        }

        sc.close();
    }
}
