package labs.RecursiveBacktracking;
import java.util.*;

public class KColorable {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		System.out.println(minKColor(graph));
		int[] colors = new int[n];
		boolean possible = kColor(graph, 0, k, colors);
		if (possible) System.out.println("YES");
		else System.out.println("NO");
		sc.close();
	}

	public static int minKColor(List<Integer>[] graph){
		int k = 1;
		int[] colors = new int[graph.length];
		while (true){
			if (kColor(graph, k, 0, colors))
				return k;
			k++;
		}
	}
	public static boolean kColor(List<Integer>[] graph, int v, int k, int[] colors){
		if (v == graph.length) return true;
		for (int c = 1; c <= k; c++){
			if (SafeColor(graph, v, c, colors)){
				colors[v] = c;
				if (kColor(graph, v+1, k, colors)) return true;
			}
			colors[v] = 0;
		}
		return false;
	}

	private static boolean SafeColor (List<Integer>[] graph, int v, int c, int[] colors){
		for (int u : graph[v]){
			if (colors[u] == c)
				return false;
		}
		return true;
	}
}
