package Homework.graphs;
import java.util.Scanner;
import java.util.*;
public class HatemTesting {
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			int n = scanner.nextInt();
			int m = scanner.nextInt();

			List<List<Integer>> graph = new ArrayList<>(n + 1);
			//boolean[] visited = new boolean[n + 1];

			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());

			}
			
			for (int i = 0; i < m; i++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				graph.get(a).add(b);
				graph.get(b).add(a); 
			}
			scanner.close();
			System.out.println("Degrees:");
			for (int i = 1; i <= n; i++) {
				System.out.println(i+": "+graph.get(i).size());
			}  
			
			

			
	}
}
