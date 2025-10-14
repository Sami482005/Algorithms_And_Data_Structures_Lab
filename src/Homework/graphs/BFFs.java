package Homework.graphs;

import java.util.*;
public class BFFs {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //number of nodes
		int m = sc.nextInt(); //number of edges
		List<List<Integer>> graph = new ArrayList<>(n+1);
		for (int v=0; v<=n; v++){
			graph.add(new ArrayList<>());
		}
		for (int i=0; i<m; i++){
			int v = sc.nextInt();
			int u = sc.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		sc.close();
	}
}
