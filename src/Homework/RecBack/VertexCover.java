package Homework.RecBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VertexCover {
public static int VC = Integer.MAX_VALUE;
	public static List<List<Integer>> graph;
 
	public static void findVC(int node, int n, boolean[] included, int cs) {
		if (node == n) {
			for (int u = 0; u < n; u++) {
				for (int v : graph.get(u)) {
					if (!included[u] && !included[v]) return;
				}
			}
			VC = Math.min(VC, cs);
			return;
		}
 
		included[node] = true;
		findVC(node + 1, n, included, cs + 1);
 
		included[node] = false;
		findVC(node + 1, n, included, cs);
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
		findVC(0, n, new boolean[n], 0);
		System.out.println(VC);
	}
}
