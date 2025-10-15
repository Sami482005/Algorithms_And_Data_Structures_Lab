package Homework.graphs;


import java.util.Scanner;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class ConComBFS {
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
				bfs(graph, i, marked);
				count++;
			}
		}
		System.out.println(count);
		sc.close();
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
