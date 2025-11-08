package midterm;

import java.util.*;


public class Graph {
	
    public static void main(String[] args) {
    //     Scanner scanner = new Scanner(System.in);

    //     System.out.print("Enter number of vertices and edges: ");
    //     int n = scanner.nextInt();
    //     int m = scanner.nextInt();

    //     List<Integer>[] graph = new ArrayList[n + 1];
    //     for (int i = 1; i <= n; i++)
    //         graph[i] = new ArrayList<>();

    //     System.out.println("Enter " + m + " edges (u v):");
    //     for (int i = 0; i < m; i++) {
    //         int a = scanner.nextInt();
    //         int b = scanner.nextInt();
    //         graph[a].add(b);
    //         graph[b].add(a); // undirected
    //     }

    //     // Highest degree
    //     int max = 0, vertex = 0;
    //     for (int i = 1; i <= n; i++) {
    //         if (graph[i].size() > max) {
    //             max = graph[i].size();
    //             vertex = i;
    //         }
    //     }
    //     System.out.println("Vertex " + vertex + " has the highest degree: " + max);

    //     // Smallest degree
    //     int min = Integer.MAX_VALUE, v = 0;
    //     for (int i = 1; i <= n; i++) {
    //         if (graph[i].size() < min) {
    //             min = graph[i].size();
    //             v = i;
    //         }
    //     }
    //     System.out.println("Vertex " + v + " has the smallest degree: " + min);

    //     // Count degree d
    //     System.out.print("Enter degree d to count: ");
    //     int d = scanner.nextInt();
    //     int count = 0;
    //     ArrayList<Integer> Dvertices = new ArrayList<>();
    //     for (int i = 1; i <= n; i++) {
    //         if (graph[i].size() == d) {
    //             count++;
    //             Dvertices.add(i);
    //         }
    //     }
    //     System.out.println(count + " vertices have degree " + d + ": " + Dvertices);

    //     // Reachability test
    //     System.out.print("Enter source and destination for reachability: ");
    //     int source = scanner.nextInt();
    //     int destination = scanner.nextInt();

    //     ArrayList<Integer> path = BFS(graph, source, destination);
    //     System.out.println("[BFS] Is " + destination + " reachable from " + source + "? " +
    //             (!path.isEmpty() ? "Yes, path: " + path : "No"));

    //     boolean[] marked = new boolean[graph.length];
    //     int[] edgeTo = new int[graph.length];
    //     Arrays.fill(edgeTo, -1);
    //     ArrayList<Integer> path2 = DFS(graph, source, destination, marked, edgeTo);
    //     System.out.println("[DFS] Is " + destination + " reachable from " + source + "? " +
    //             (!path2.isEmpty() ? "Yes, path: " + path2 : "No"));

    //     // Connected components
    //     System.out.println("The number of connected components is: " + connectedComponents(graph));

    //     // Bipartite check
    //     System.out.println("Graph is bipartite: " + isBipartite(graph));

    //     // Completeness
    //     System.out.println("Graph is complete: " + completeness(graph));


	// 	// ---- TEST numberOfPaths ----
	// 	System.out.print("Enter source and destination to count total paths: ");
	// 	int srcPaths = scanner.nextInt();
	// 	int destPaths = scanner.nextInt();
	// 	boolean[] visitedPaths = new boolean[graph.length];
	// 	int totalPaths = numberOfPaths(graph, srcPaths, destPaths, visitedPaths);
	// 	System.out.println("Total number of paths from " + srcPaths + " to " + destPaths + ": " + totalPaths);

	// 	// ---- TEST DNeighbors ----
	// 	System.out.print("Enter source vertex and distance d for D-neighbors: ");
	// 	int srcD = scanner.nextInt();
	// 	int dist = scanner.nextInt();
	// 	List<Integer> dNeighbors = DNeighbors(graph, srcD, dist);
	// 	System.out.println("Vertices within distance " + dist + " from " + srcD + ": " + dNeighbors);

	// 	// ---- TEST hasCycle ----
	// 	List<ArrayList<Integer>> cycles = hasCycle(graph);
	// 	if (cycles.isEmpty())
	// 		System.out.println("No cycles found in the graph.");
	// 	else
	// 		System.out.println("Cycles found: " + cycles);

	// 	// ---- TEST hasRake ----
	// 	int rakeCount = hasRake(graph);
	// 	System.out.println("Number of nodes forming rake-like structure: " + rakeCount);

	// 	// ---- TEST shortestPath ----
	// 	System.out.print("Enter source and destination for shortest path: ");
	// 	int ssp = scanner.nextInt();
	// 	int dsp = scanner.nextInt();
	// 	boolean[] markedSP = new boolean[graph.length];
	// 	int[] distTo = new int[graph.length];
	// 	int[] edgeToSP = new int[graph.length];
	// 	Arrays.fill(edgeToSP, -1);
	// 	List<Integer> shortest = shortestPath(graph, ssp, dsp, markedSP, distTo, edgeToSP);
	// 	System.out.println("Shortest path from " + ssp + " to " + dsp + ": " +
	// 			(!shortest.isEmpty() ? shortest : "No path"));


    //     scanner.close();
	// 	int n = 6;
    // List<Integer>[] graph = new ArrayList[n + 1];
    // for (int i = 1; i <= n; i++) {
    //     graph[i] = new ArrayList<>();
    // }

    // // Create edges
    // // Component 1: 1 - 2 - 3
    // graph[1].add(2);
    // graph[2].add(1);
    // graph[2].add(3);
    // graph[3].add(2);

    // // Component 2: 4 - 5
    // graph[4].add(5);
    // graph[5].add(4);

    // // Component 3: 6 (isolated)

    // // Expected:
    // //   - Largest component size = 3 (nodes 1, 2, 3)
    // //   - Smallest component size = 1 (node 6)

    // System.out.println("Largest component size: " + largestConnectedComponent(graph));
    // System.out.println("Smallest component size: " + smallestConnectedComponent(graph));

    // Example 2: Fully connected graph (1 component)
    int m = 4;
    List<Integer>[] fullGraph = new ArrayList[m + 1];
    for (int i = 1; i <= m; i++) {
        fullGraph[i] = new ArrayList<>();
    }
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= m; j++) {
            if (i != j) fullGraph[i].add(j);
        }
    }
    // Expected: largest = smallest = 4
    System.out.println("\nFully connected graph:");
    System.out.println("Largest component size: " + largestConnectedComponent(fullGraph));
    System.out.println("Smallest component size: " + smallestConnectedComponent(fullGraph));

    // Example 3: All isolated nodes
    int k = 17;
    List<Integer>[] isolatedGraph = new ArrayList[k + 1];
    for (int i = 1; i <= k; i++) {
        isolatedGraph[i] = new ArrayList<>();
    }
	isolatedGraph[2].add(9);
	isolatedGraph[2].add(10);
    // Expected: largest = smallest = 1
    System.out.println("\nAll isolated nodes:");
    System.out.println("Largest component size: " + largestConnectedComponent(isolatedGraph));
    System.out.println("Smallest component size: " + smallestConnectedComponent(isolatedGraph));

    }
	
	public static ArrayList<Integer> BFS (List<Integer>[] graph, int u, int v){
		Queue<Integer> q  = new LinkedList<>();
		q.add(u);
		boolean[] marked = new boolean[graph.length];
		marked[u] = true;
		int[] edgeTo = new int[graph.length];
		Arrays.fill(edgeTo, -1);
		while (!q.isEmpty()){
			int next = q.poll();
			if (next == v){
				ArrayList<Integer> ans = new ArrayList<>();
				while (v != -1){
					ans.add(v);
					v = edgeTo[v];
				}
				return ans;
			}
			for (int w : graph[next]){
				if (!marked[w]){
					q.add(w);
					edgeTo[w] = next;
					marked[w] = true;
				}
			}
		}
		return new ArrayList<>();
	}

	public static ArrayList<Integer> DFS(List<Integer>[] graph, int u, int v, boolean[] marked, int[] edgeTo) {
		marked[u] = true;
		if (u == v) {
			ArrayList<Integer> path = new ArrayList<>();
			path.add(v);
			return path;
		}
		for (int nei : graph[u]) {
			if (!marked[nei]) {
				edgeTo[nei] = u;
				ArrayList<Integer> path = DFS(graph, nei, v, marked, edgeTo);
				if (!path.isEmpty()) {
					path.add(u);
					return path;
				}
			}
		}
		return new ArrayList<>();
	}


	public static int connectedComponents (List<Integer>[] graph){
		boolean[] marked = new boolean[graph.length];
		int count = 0;
		for (int v = 1; v < graph.length; v++){
			if (!marked[v]){
				dfs(graph, v, marked);
				count++;
			}
		}
		return count;
	}

	private static void dfs(List<Integer>[] graph, int v, boolean[] visited){
		visited[v] = true;
		for (int nei : graph[v]){
			if (!visited[nei]){
				dfs(graph, nei, visited);
			}
		}
	}

	public static List<Integer> shortestPath(List<Integer>[] graph, int source, int destination, boolean[] marked, int[] distTo, int[] edgeTo){
		marked[source] = true;
		Queue<Integer> q = new LinkedList<>();
		List<Integer> ans = new ArrayList<>();
		q.add(source);
		distTo[source] = 0;
		while (!q.isEmpty()){
			int next = q.poll();
			if (next == destination){
				while (next != source){
					ans.add(next);
					next = edgeTo[next];
				}
				ans.add(source);
				ans = ans.reversed();
				return ans;
			}
			for (int nei : graph[next]){
				if (!marked[nei]){
					distTo[nei] = distTo[next] + 1;
					edgeTo[nei] = next;
					marked[nei] = true;
					q.add(nei);
				}
			}
		}
		return new ArrayList<>();
	}

	public static int hasRake(List<Integer>[] graph){
		int[] distTo = new int[graph.length];
		int[] distLevel = new int[graph.length];
		boolean[] marked = new boolean[graph.length];
		Queue<Integer> q = new LinkedList<>();
		int count = 0;
		for (int source = 1; source < graph.length; source++){
			marked[source] = true;
			q.clear();
			Arrays.fill(distTo, 0);
			Arrays.fill(distLevel, 0);
			q.add(source);
			while (!q.isEmpty()){
				int next = q.poll();
				for (int nei : graph[next]){
					if (!marked[nei]){
						distTo[nei] = distTo[next] + 1;
						distLevel[distTo[nei]]++;
						marked[nei] = true;
					}
				}
			}
			if (distLevel[4] >=3)
				count++;
		}
		return count;
	}

	public static int numberOfPaths(List<Integer>[] graph, int source, int destination, boolean[] marked){
		if (source == destination) return 1;
		marked[source] = true;
		int count = 0;
		for (int nei : graph[source]){
			if (!marked[nei]){
				count += numberOfPaths(graph, nei, destination, marked);
			}
		}
		marked[source] = false;
		return count;
	}

	public static List<ArrayList<Integer>> hasCycle(List<Integer>[] graph){
		boolean[] visited = new boolean[graph.length];
		int[] parent = new int[graph.length];
		Arrays.fill(parent, -1);
		List<ArrayList<Integer>> ans = new ArrayList<>();
		for (int i = 1; i < graph.length; i++){
			if (!visited[i]){
				ArrayList<Integer> cycle = new ArrayList<>();
				if (cycleDiscover(graph, i, visited, cycle, parent)){
					ans.add(cycle);
				}

			}
		}
		return ans;
	}

	private static boolean cycleDiscover(List<Integer>[] graph, int source, boolean[] visited, ArrayList<Integer> cycle, int[] parent){
		visited[source] = true;
		for (int nei : graph[source]){
			if (parent[source] != nei && visited[nei]){
				cycle.add(nei);
				int cur = source;
				while (cur != nei && cur != -1){
					cycle.add(cur);
					cur = parent[cur];
				}
				cycle.add(nei);
				return true;
			}
			else if (!visited[nei]){
				parent[nei] = source;
				if (cycleDiscover(graph, nei, visited, cycle, parent))
					return true;
			}
		}
		return false;
	}

	public static boolean isBipartite(List<Integer>[] graph){
		int[] color = new int[graph.length];
		for (int i = 1; i < graph.length; i++){
			if (color[i] == 0){
				if (!BipartiteDiscovery(graph, i, color, 1))	return false;
			}
		}
		return true;
	}
	private static boolean BipartiteDiscovery(List<Integer>[] graph, int source, int[] colors, int num){
		colors[source] = num;
		for (int u : graph[source]){
			if (colors[u] == num)	return false;
			if (colors[u] == 0){
				if (!BipartiteDiscovery(graph, u, colors, num == 1 ? 2: 1))
					return false;
			}
		}
		return true;
	}

	public static List<Integer> DNeighbors(List<Integer>[] graph, int source, int d){
		boolean[] visited = new boolean[graph.length];
		int[] distTo = new int[graph.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		visited[source] = true;
		distTo[source] = 0;
		while (!q.isEmpty()){
			int next = q.poll();
			for (int nei : graph[next]){
				if (!visited[nei]){
					visited[nei] = true;
					q.add(nei);
					distTo[nei] = distTo[next] + 1;
				}
			}
		}
		List<Integer> ans = new ArrayList<>();
		for (int i = 1; i < graph.length; i++){
			if (distTo[i] <= d)
				ans.add(i);
		}
		return ans;
	}

	public static boolean completeness(List<Integer>[] graph){
		for (int i = 1; i < graph.length; i++){
			if (graph[i].size() < graph.length - 2)
				return false;
		}
		return true;
	}

	public static int largestConnectedComponent(List<Integer>[] graph){
		int[] count = new int[graph.length];
		boolean[] visited = new boolean[graph.length];
		int id = 1;

		for (int v = 1; v < graph.length; v++){
			if (!visited[v]){
				BFSDiscover(graph, v, id, count, visited);
				id++;
			}
		}
		int max = 0;
		for (int i = 1; i < count.length; i++){
			if (count[i] > max)
				max = count[i];
		}
		return max;
	}

	private static void BFSDiscover(List<Integer>[] graph, int source, int id, int[]count, boolean[] visited){
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		visited[source] = true;
		while (!q.isEmpty()){
			int next= q.poll();
			count[id]+=1;
			for (int nei : graph[next]){
				if (!visited[nei]){
					visited[nei] = true;
					q.add(nei);
				}
			}
		}
	}

	public static int smallestConnectedComponent(List<Integer>[] graph){
		boolean[] visited = new boolean[graph.length];
		int id = 1;
		int[] count = new int[graph.length];
		for (int i = 1; i < graph.length; i++){
			if (!visited[i]){
				DFSDiscover(graph, i, visited, id, count);
				id++;
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < count.length; i++){
			if (count[i] > 0 && count[i] < min) {
				min = count[i];
		}
		}
		return min;
	}

	private static void DFSDiscover(List<Integer>[] graph, int source, boolean[] visited, int id, int[] count){
		visited[source] = true;
		count[id] +=1;
		for (int nei: graph[source]){
			if(!visited[nei]){
				DFSDiscover(graph, nei, visited, id, count);
			}
		}
	}

}

