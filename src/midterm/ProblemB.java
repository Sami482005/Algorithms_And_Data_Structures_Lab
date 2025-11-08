package midterm;

import java.util.*;

public class ProblemB {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer>[] graph = new ArrayList[n+1];
		for (int i = 1; i <= n; i++){
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < n-1; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x].add(y);
			graph[y].add(x);
		}
		int[] BFS = new int[n];
		for (int i = 0; i < n; i++){
			int a = sc.nextInt();
			BFS[i] = a;
		}

		if (BFS[0] != 1 || BFS.length != n){
			System.out.println("No");
			return;
		}

		boolean[] visited = new boolean[n+1];
		int source = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		visited[source] = true;
		int idx = 1;

		while (!q.isEmpty()){
			int levelSize = q.size();
			int count= 0;
			for (int i = 0; i < levelSize; i++){
				int next = q.poll();
				for (int u : graph[next]){
					if (!visited[u]){
						visited[u] = true;
						q.add(u);
						count++;
					}
				}
			}

			for (int i = 0; i < count; i++){
				if (idx >= n || !visited[BFS[idx]]){
					System.out.println("No");
					return;
				}
				idx++;
			}
		}
		System.out.println("Yes");
	}
}
