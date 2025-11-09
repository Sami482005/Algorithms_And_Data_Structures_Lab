package Homework.RecBack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VertexCover {
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
		int k = 1;
		while (true){
			if (VertexCover(graph, k)){
				System.out.println(k);
				break;
			}
			k++;
		}
		ArrayList<Integer> cover = whoisVC(graph, k);
		if (cover != null){
			System.out.println(cover);
		}

	}

	public static boolean VertexCover(List<Integer>[] graph, int k){
		if (k < 0) return false;
		if (isEdgeless(graph)) return true;
		if (k == 0) return false;

		int v = selectMaxDegreeVertex(graph);

		List<Integer>[] g1 = cloneGraph(graph);
		Remove(g1,v);
		if (VertexCover(g1, k-1))
			return true;
		List<Integer>[] g2 = cloneGraph(graph);
		ArrayList<Integer> closed = ClosedNei(graph, v);
		RemoveAllNeis(g2, closed);
		return VertexCover(g2, k-degree(graph, v));
	}

	private static boolean isEdgeless(List<Integer>[] graph){
		for (int i = 0; i < graph.length; i++){
			if (graph[i].size() != 0) return false;
		}
		return true;
	}

	private static int degree(List<Integer>[] graph, int v){
		return graph[v].size();
	}

	private static int selectMaxDegreeVertex(List<Integer>[] graph){
		int max = -1;
		int vertex = -1;
		for (int i = 0; i < graph.length; i++){
			if (graph[i].size() > max){
				max = graph[i].size();
				vertex = i;
			}
		}
		return vertex;
	}

	private static void Remove(List<Integer>[] graph, int v){
		for (int nei : graph[v]){
			graph[nei].remove((Object) v);
		}
		graph[v].clear();
	}

	public static void RemoveAllNeis(List<Integer>[] graph, ArrayList<Integer> a){
		for (int i : a){
			Remove(graph, i);
		}
	}

	private static ArrayList<Integer> ClosedNei(List<Integer>[] graph, int v){
		ArrayList<Integer> a = new ArrayList<>(graph[v]);
		a.add(v);
		return a;
	}

	private static List<Integer>[] cloneGraph(List<Integer>[] graph){
		List<Integer>[] copy = new ArrayList[graph.length];
		for (int i = 0; i < graph.length; i++){
			copy[i] = new ArrayList<>(graph[i]);
		}
		return copy;
	}

	public static ArrayList<Integer> whoisVC(List<Integer>[] graph, int k){
		if (k < 0) return null;
		if (isEdgeless(graph)) return new ArrayList<>();
		if (k == 0) return null;

		int v = selectMaxDegreeVertex(graph);

		List<Integer>[] g1 = cloneGraph(graph);
		Remove(g1, v);
		ArrayList<Integer> res1 = whoisVC(g1, k-1);
		if (res1 != null){
			res1.add(v);
			return res1;
		}

		List<Integer>[] g2 = cloneGraph(graph);
		ArrayList<Integer> neis = ClosedNei(g2, v);
		RemoveAllNeis(g2, neis);
		ArrayList<Integer> res2 = whoisVC(g2, k-degree(graph, v));
		if (res2 != null){
			res2.addAll(neis);
			return res2;
		}
		return null;

	}

}
