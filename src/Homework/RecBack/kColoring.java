package Homework.RecBack;
import java.util.*;

public class kColoring {
 
 
	// Backtracking function to assign colors to each vertex
	private static boolean assignColors(int node, int n, int k, List<List<Integer>> adj, int[] color) {
		if (node == n) {
			return true;
		}
 
		for (int c = 1; c <= k; c++) {
			if (isValid(node, c, adj, color)) {
				color[node] = c;
				if (assignColors(node + 1, n, k, adj, color)) {
					return true;
				}
				color[node] = 0; // backtrack
			}
		}
		return false;
	}
 
	// Check if assigning color 'c' to vertex 'v' is valid
	private static boolean isValid(int v, int c, List<List<Integer>> adj, int[] color) {
		for (int neighbor : adj.get(v)) {
			if (color[neighbor] == c) {
				return false;
			}
		}
		return true;
	}
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of vertices
		int m = sc.nextInt(); // number of edges
		int k = sc.nextInt(); // number of colors
 
		// adjacency list
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
 
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
 
		int[] color = new int[n];
		boolean possible = assignColors(0, n, k, adj, color);
 
		sc.close();
		System.out.println(possible ? "YES" : "NO");
	}
}
