package Homework.RecBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IndependentSet {

	public static boolean findMaxIS(List<Integer>[] graph, int k){
		if (k <= 0) return true;
		if (isEmpty(graph)) return false;

		int v = selectMinDegreeVertex(graph);

		List<Integer>[] g2 = cloneGraph(graph);
		ArrayList<Integer> list = ClosedNei(g2, v);
		RemoveAllNeis(g2, list);
		if (findMaxIS(g2, k-1))
			return true;
		
		List<Integer>[] g1 = cloneGraph(graph);
		Remove(g1, v);
		return findMaxIS(g1, k);
	
	}

	private static boolean isEmpty(List<Integer>[] graph){
		for(List<Integer> nei : graph){
			if (nei != null)
				return false;
		}
		return true;
	}

	private static int selectMinDegreeVertex(List<Integer>[] graph){
		int max = Integer.MAX_VALUE;
		int vertex = -1;
		for (int i = 0; i < graph.length; i++){
			if (graph[i] != null){
				if (graph[i].size() < max){
					max = graph[i].size();
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
				graph[nei].remove((Object) v);
		}
		graph[v] = null;
	}

	public static void RemoveAllNeis(List<Integer>[] graph, ArrayList<Integer> a){
		for (int i : a){
			Remove(graph, i);
		}
	}

	private static ArrayList<Integer> ClosedNei(List<Integer>[] graph, int v){
		ArrayList<Integer> a = new ArrayList<>();
		if (graph[v] != null)
			a.addAll(graph[v]);
		a.add(v);
		return a;
	}

	private static List<Integer>[] cloneGraph(List<Integer>[] graph){
		List<Integer>[] copy = new ArrayList[graph.length];
		for (int i = 0; i < graph.length; i++){
			copy[i] = (graph[i] == null) ? null : new ArrayList<>(graph[i]);
		}
		return copy;
	}

	public static ArrayList<Integer> whoisIS(List<Integer>[] graph, int k){
		if (k <= 0) return new ArrayList<>();
		if (isEmpty(graph)) return null;

		int v = selectMinDegreeVertex(graph);

		List<Integer>[] g1 = cloneGraph(graph);
		ArrayList<Integer> neis = ClosedNei(g1, v);
		RemoveAllNeis(g1, neis);
		ArrayList<Integer> list = whoisIS(g1, k-1);
		if (list != null){
			list.add(v);
			return list;
		}

		List<Integer>[] g2 = cloneGraph(graph);
		Remove(g2, v);
		ArrayList<Integer> list2 = whoisIS(g2, k);
		if (list2 != null){
			list2.addAll(g2[v]);
			return list2;
		}
		return null;
	}


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
		ArrayList<Integer> ISIS = whoisIS(graph, k);
		if (ISIS != null) System.out.println(ISIS);
	}
}
