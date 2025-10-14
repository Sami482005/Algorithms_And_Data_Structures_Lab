package tutoring.Graph;
import java.util.*;

public class GraphFunctions {
	@SuppressWarnings("unchecked")
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // number of vertices
		int m = sc.nextInt(); // number of edges

		// Step 1: Build adjacency list
		List<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			graph[i] = new ArrayList<>();

		// Step 2: Read edges
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a); // remove for directed graphs
		}

		// ------------------ DEMOS -------------------
		System.out.println("Connected components: " + countComponents(graph, n));
		System.out.println("Has cycle: " + detectCycle(graph, n));
		System.out.println("Is bipartite: " + isBipartite(graph, n));
		System.out.println("Shortest path (1 → n): " + shortestPath(graph, 1, n));
		System.out.println("Reachable(1, n): " + reachable(graph, 1, n));
	}

	// ---------- DFS ----------
	static void dfs(List<Integer>[] graph, boolean[] visited, int node) {
		visited[node] = true;
		for (int nei : graph[node])
			if (!visited[nei])
				dfs(graph, visited, nei);
	}

	// ---------- Connected Components ----------
	static int countComponents(List<Integer>[] graph, int n) {
		boolean[] visited = new boolean[n + 1];
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(graph, visited, i);
				count++;
			}
		}
		return count;
	}

	// ---------- Reachability ----------
	static boolean reachable(List<Integer>[] graph, int start, int target) {
		boolean[] visited = new boolean[graph.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int v = q.poll();
			if (v == target)
				return true;
			for (int nei : graph[v])
				if (!visited[nei]) {
					visited[nei] = true;
					q.add(nei);
				}
		}
		return false;
	}

	static boolean reachableDFS(List<Integer>[] graph, int start, int target) {
		boolean[] visited = new boolean[graph.length];
		return dfsReach(graph, visited, start, target);
	}

	static boolean dfsReach(List<Integer>[] graph, boolean[] visited, int node, int target) {
		if (node == target)
			return true;
		visited[node] = true;

		for (int nei : graph[node]) {
			if (!visited[nei]) {
				if (dfsReach(graph, visited, nei, target))
					return true;
			}
		}
		return false;
	}

	// ---------- Cycle Detection (Undirected) ----------
	static boolean hasCycle(List<Integer>[] graph, boolean[] visited, int node, int parent) {
		visited[node] = true;
		for (int nei : graph[node]) {
			if (!visited[nei]) {
				if (hasCycle(graph, visited, nei, node))
					return true;
			} else if (nei != parent)
				return true;
		}
		return false;
	}

	static boolean detectCycle(List<Integer>[] graph, int n) {
		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++)
			if (!visited[i] && hasCycle(graph, visited, i, -1))
				return true;
		return false;
	}

	static int shortestPath(List<Integer>[] graph, int start, int target) {
		int[] dist = new int[graph.length];
		Arrays.fill(dist, -1);
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		dist[start] = 0;

		while (!q.isEmpty()) {
			int v = q.poll();

			// If we’ve reached the target, we can stop
			if (v == target)
				return dist[v];

			for (int nei : graph[v]) {
				if (dist[nei] == -1) {
					dist[nei] = dist[v] + 1;
					q.add(nei);
				}
			}
		}
		return dist[target]; // if unreachable, remains -1
	}

	// ---------- Bipartite Check ----------
	static boolean isBipartite(List<Integer>[] graph, int n) {
		int[] color = new int[n + 1]; // 0 = uncolored, 1 / -1 = two colors
		for (int i = 1; i <= n; i++) {
			if (color[i] == 0) {
				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				color[i] = 1;
				while (!q.isEmpty()) {
					int v = q.poll();
					for (int nei : graph[v]) {
						if (color[nei] == 0) {
							color[nei] = -color[v];
							q.add(nei);
						} else if (color[nei] == color[v])
							return false;
					}
				}
			}
		}
		return true;
	}

	// ---------- Bipartite Check (DFS) ----------
	static boolean isBipartiteDFS(List<Integer>[] graph, int n) {
		int[] color = new int[n + 1]; // 0 = uncolored, 1 and -1 are the two colors

		for (int i = 1; i <= n; i++) {
			if (color[i] == 0) { // new component
				if (!dfsColor(graph, i, 1, color))
					return false;
			}
		}
		return true;
	}

	static boolean dfsColor(List<Integer>[] graph, int node, int c, int[] color) {
		color[node] = c;
		for (int nei : graph[node]) {
			if (color[nei] == 0) { // not colored
				if (!dfsColor(graph, nei, -c, color))
					return false;
			} else if (color[nei] == color[node]) { // same color conflict
				return false;
			}
		}
		return true;
	}

	static void computeDepthDegree(List<Integer>[] graph, int start, int n) {
		int[] dist = new int[n];
		Arrays.fill(dist, -1);
		dist[start] = 0;

		int[] levelCount = new int[n];// count of nodes at each level
		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		// ----- BFS: compute how many nodes exist at each level -----
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int nei : graph[node]) {
				if (dist[nei] == -1) {
					dist[nei] = dist[node] + 1;
					levelCount[dist[nei]]++;// count nodes at this level
					q.add(nei);
				}
			}
		}

		// ----- After BFS: compute cumulative (prefix sum) -----
		for (int d = 1; d < n; d++) {
			levelCount[d] += levelCount[d - 1];
			System.out.println(d + "-degree(" + start + ") = " + levelCount[d]);
		}
	}
}
