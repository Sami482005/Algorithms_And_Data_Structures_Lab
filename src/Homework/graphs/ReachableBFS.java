package Homework.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ReachableBFS {
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

		int s = sc.nextInt(); //Source
		int d = sc.nextInt(); //Destination

		boolean[] marked = new boolean[n];
		bfs(graph, s, marked);
		if (marked[d])
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	public static void bfs(List<Integer>[] graph, int source, boolean[] marked){
		marked[source] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		while(!q.isEmpty()){
			int v = q.poll();
			for (int w : graph[v]){
				if (!marked[w]){
					marked[w] = true;
					q.add(w);
				}
			}
		}
	}
}
