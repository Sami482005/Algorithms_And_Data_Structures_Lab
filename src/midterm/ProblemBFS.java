package midterm;

import java.util.*;

public class ProblemBFS {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer>[] graph = new ArrayList[n+1];
		for (int i = 1; i <=n; i++){
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < n-1; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x].add(y);
			graph[y].add(x);
		}
		List<Integer> BFS = new ArrayList<>();
		for (int i = 0; i < n; i++){
			BFS.add(sc.nextInt());
		}
		sc.close();

		int idx = 1;
		if (BFS.get(0) != 1 || BFS.size() != n){
			System.out.println("No");
			return;
		}

		boolean[] visited = new boolean[n+1];
		int source = 1;
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		visited[source] = true;

		while (!q.isEmpty()){
			int levelSize = q.size();
			int count = 0;
			for (int u = 0; u < levelSize; u++){
				int next = q.poll();
				for (int nei : graph[next]){
					if (!visited[nei]){
						visited[nei] = true;
						q.add(nei);
						count++;
					}
				}
			}
			for (int i = 0; i < count; i++){
				if (idx >= n || !visited[BFS.get(idx)]){
					System.out.println("No");
					return;
				}
				idx++;
			}
		}
		System.out.println("Yes");
	}
}
