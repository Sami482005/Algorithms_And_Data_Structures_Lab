package labs.RecursiveBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IndependentSet {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
 
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) 
			graph[i] = new ArrayList<>();
 
		for (int i = 0; i < m; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			graph[u].add(v);
			graph[v].add(u);
		}
 
		scan.close();
		int k = graph.length;
		while (true){
			if (findMaxIS(graph, k)){
				System.out.println(k);
				break;
			}
			k--;
		}
		List<Integer> ISIS = whoisIS(graph, k);
		if (ISIS != null) System.out.println(ISIS);
	}

	public static boolean findMaxIS(List<Integer>[] graph, int k){
		if (k <= 0) return true;
		if (isEmpty(graph)) return false;

		int v = SelectMinDegreeVertex(graph);
		List<Integer>[] g1 = CloneGraph(graph);
		List<Integer> neis = ClosedNei(graph, v);
		RemoveAllNeis(g1, neis);
		if (findMaxIS(g1, k-1)) return true;

		List<Integer>[] g2 = CloneGraph(graph);
		Remove(g2, v);
		return findMaxIS(g1, k);
	}


	public static List<Integer> whoisIS(List<Integer>[] graph, int k){
		if (k <= 0) return new ArrayList<>();
		if (isEmpty(graph)) return null;

		int v = SelectMinDegreeVertex(graph);

		List<Integer>[] g1 = CloneGraph(graph);
		List<Integer> neis = ClosedNei(g1, v);
		RemoveAllNeis(g1, neis);
		List<Integer> res1 = whoisIS(g1, k-1);
		if (res1 != null){
			res1.add(v);
			return res1;
		}

		List<Integer>[] g2 = CloneGraph(graph);
		Remove(graph, v);
		List<Integer> res2 = whoisIS(g2, k);
		if (res2 != null){
			for (int u : g2[v]){
				res2.add(u);
			}
			return res2;
		}
		return null;
	}

	private static boolean isEmpty(List<Integer>[] graph){
		for (List<Integer> nei : graph){
			if (nei != null) return false;
		}
		return true;
	}

	private static int SelectMinDegreeVertex(List<Integer>[] graph){
		int min = Integer.MAX_VALUE;
		int vertex = -1;
		for (int i = 0; i < graph.length; i++){
			if (graph[i] != null){
				if (graph[i].size() < min){
					min = graph[i].size();
					vertex = i;
				}
			}
		}
		return vertex;
	}

	private static void Remove(List<Integer>[] graph, int v){
		if (graph[v] == null) return;
		for (int nei : graph[v]){
			if (graph[nei] != null)
				graph[nei].remove((Object)v);
		}
		graph[v] = null;
	}

	private static void RemoveAllNeis(List<Integer>[] graph, List<Integer> neis){
		for (int nei : neis){
			Remove(graph, nei);
		}
	}

	private static List<Integer> ClosedNei(List<Integer>[]graph, int v){
		List<Integer> neis = new ArrayList<>();
		if (graph[v] != null){
			for (int i : graph[v]){
				neis.add(i);
			}
		}
		neis.add(v);
		return neis;
	}

	private static List<Integer>[] CloneGraph(List<Integer>[] graph){
		List<Integer>[] copy = new ArrayList[graph.length];
		for (int i = 0; i < graph.length; i++){
			copy[i] = (graph[i] == null) ? null : new ArrayList<>(graph[i]);
		}
		return copy;
	}
}
