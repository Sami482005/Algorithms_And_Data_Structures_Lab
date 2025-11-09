package Homework.RecBack;

import java.util.*;

public class GraphColoring {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		System.out.println(minKColor(graph));
		int[] colors = new int[n];
		boolean possible = assignColor(graph, 0, k, colors);
		if (possible) System.out.println("YES");
		else System.out.println("NO");
		sc.close();
	}
	public static boolean assignColor(List<Integer>[] graph, int node, int k, int[] colors){
		if (node == graph.length) return true;

		for (int c = 1; c <= k; c++){
			if (isSafeColor(graph, node, c, colors)){
				colors[node] = c;
				if (assignColor(graph, node+1, k, colors))
					return true;
			}
			colors[node] = 0;
		}
		return false;
	}

	private static boolean isSafeColor(List<Integer>[] graph, int node, int c, int[] colors){
		for (int nei : graph[node]){
			if (colors[nei] == c) return false;
		}
		return true;
	}

	public static int minKColor(List<Integer>[] graph){
		int[] colors = new int[graph.length];
		int k = 1;
		while (true){
			Arrays.fill(colors,0);
			if (assignColor(graph, 0, k, colors))
				return k;
			k++;
		}
	}
}
