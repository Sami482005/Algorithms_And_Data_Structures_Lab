package labs.RecursiveBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VertexCover {
public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
 
		List<List<Integer>> graph = new ArrayList<>(n);
		for (int i = 0; i < n; i++) 
			graph.add(new ArrayList<>());
 
		for (int i = 0; i < m; i++) {
			int u = scan.nextInt();
			int v = scan.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
 
		scan.close();
		int k = 1;
		while (true){
			if (vertexcover(graph, k)){
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

	public static boolean vertexcover(List<List<Integer>> G, int k){
		if (k < 0) return false;
		if (isEdgeless(G)) return true;
		if (k == 0) return false;

		int v = selectMaxDegreeVertex(G);

		List<List<Integer>> g1 = CloneGraph(G);
		Remove(g1, v);
		if (vertexcover(g1, k-1)) return true;

		List<List<Integer>> g2 = CloneGraph(G);
		List<Integer> neis = new ArrayList<>(g2.get(v));
		RemoveAllNeis(g2, neis);
		return vertexcover(g2, k-degree(g2, v));
	}

	public static ArrayList<Integer> whoisVC(List<List<Integer>> G, int k){
		if (k < 0) return null;
		if (isEdgeless(G)) return new ArrayList<>();
		if (k == 0) return null;

		int v = selectMaxDegreeVertex(G);
		
		List<List<Integer>> g1 = CloneGraph(G);
		Remove(g1, v);
		ArrayList<Integer> res1 = whoisVC(g1, k-1);
		if (res1 != null){
			res1.add(v);
			return res1;
		}

		List<List<Integer>> g2 = CloneGraph(G);
		List<Integer> neis = g2.get(v);
		RemoveAllNeis(g2, neis);
		ArrayList<Integer> res2 = whoisVC(g2, k-degree(g2, v));
		if (res2 != null){
			for (int n : neis)
				res2.add(n);
			return res2;
		}
		return null;

	}






	private static boolean isEdgeless(List<List<Integer>> G){
		for (List<Integer> v : G){
			if (v.size() > 0)
				return false;
		}
		return true;
	}

	private static int selectMaxDegreeVertex(List<List<Integer>> G){
		int max = -1;
		int index = -1;
		for (int i = 0; i < G.size(); i++){
			if (G.get(i).size() > max){
				max = G.get(i).size();
				index = i;
			}
		}
		return index;
	}

	private static List<List<Integer>> CloneGraph(List<List<Integer>> G){
		List<List<Integer>> g2 = new ArrayList<>();
		for (List<Integer> nei: G)
			g2.add(new ArrayList<>(nei));
		
		return g2;

	}

	private static int degree(List<List<Integer>> G, int v){
		return G.get(v).size();
	}

	private static void Remove(List<List<Integer>> G, int v){
		for (int u : G.get(v)){
			G.get(u).remove((Object)v);
		}
		G.get(v).clear();
	}

	private static void RemoveAllNeis(List<List<Integer>> G, List<Integer> neis){
		for (int i = 0; i < neis.size(); i++){
			Remove(G, neis.get(i));
		}
	}
}