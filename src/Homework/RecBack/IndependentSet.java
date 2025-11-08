package Homework.RecBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IndependentSet {
public static int ms = 0;
	public static List<List<Integer>> graph;
 
	public static void findMaxIS(int node, int n, boolean[] V, int cs) {
		if (node == n) {
			ms = Math.max(ms, cs);
			return;
		}
 
		boolean canInclude = true;
		for (int neighbor : graph.get(node)) {
			if (V[neighbor]) { 
				canInclude = false;
				break;
			}
		}
 
		if (canInclude) { 
			V[node] = true;
			findMaxIS(node + 1, n, V, cs + 1);
			V[node] = false;
		}
		findMaxIS(node + 1, n, V, cs);
	}
 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
 
		graph = new ArrayList<>();
		for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
 
		for (int i = 0; i < m; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
 
		scan.close();
		findMaxIS(0, n, new boolean[n], 0);
		System.out.println(ms);
	}
}
