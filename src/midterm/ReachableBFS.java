package midterm;

import java.util.*;

public class ReachableBFS {
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
		System.out.println(BFSReachable(graph, s, d, visited));
		sc.close();
	}

	public static boolean BFSReachable(List<Integer>[] graph, int source, int destination, boolean[] visited){
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		visited[source] = true;
		while (!q.isEmpty()){
			int next = q.poll();
			if (next == destination)
				return true;
			for (int u : graph[next]){
				if (!visited[u]){
					visited[u] = true;
					q.add(u);
				}
			}
		}
		return false;
	}

}
