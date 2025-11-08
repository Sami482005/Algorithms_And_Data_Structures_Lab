package midterm;

import java.util.*;

public class ReachableDFS {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++){
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		int s = sc.nextInt();
		int d = sc.nextInt();
		boolean[] visited  = new boolean[n];
		System.out.println(DFsReachable(graph, s, d, visited));
		sc.close();
	}

	public static boolean DFsReachable(List<Integer>[] graph, int source, int destination, boolean[] visited){
		visited[source] = true;
		if (source == destination)
			return true;
		for (int nei : graph[source]){
			if (!visited[nei]){
				if (DFsReachable(graph, nei, destination, visited))
					return true;
			}
		}
		return false;
	}
}
