package Homework.graphs;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ConnectedComponents {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}

		int count = 0;
		boolean[] marked = new boolean[n];
		for (int i = 0; i < n; i++){
			if (!marked[i]){
				dfs(graph, i, marked);
				count++;
			}
		}
		System.out.println(count);
		sc.close();
	}

	public static void dfs(List<Integer>[] graph, int source, boolean[] marked){
		marked[source] = true;
		for (int w : graph[source]){
			if (!marked[w])
				dfs(graph, w, marked);
		}
	}
}
