package tutoring.greedy;


import java.util.*;

public class UndirectedDijkstra {

	public static class Edge{
		public int to, weight;
		public Edge( int to, int w){
			this.to = to;
			this.weight = w;
		}
	}

	public static class Node implements Comparable<Node>{
		public int city, dist;
		public Node(int city, int dist){
			this.city = city;
			this.dist = dist;
		}

		public int compareTo(Node that){
			return Integer.compare(this.dist, that.dist);
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		List<List<Edge>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++){
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			graph.get(a).add(new Edge(b, w));
			graph.get(b).add(new Edge(a, w));
		}

		int[] dist = new int[n+1];
		int[] prev = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		prev[1] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0));

		while (!pq.isEmpty()){
			Node curr = pq.poll();
			int city = curr.city;
			int distance = curr.dist;
			
			if (distance > dist[city]) continue;

			for (Edge e : graph.get(city)){
				int v = e.to;
				int cost = e.weight;
				if (cost + dist[city] < dist[v]){
					dist[v] = cost + dist[city];
					prev[v] = city;
					pq.add(new Node(v, dist[v]));
				}
			}
		}
		sc.close();

		if (dist[n] == Integer.MAX_VALUE){
			System.out.println(-1);
			return;
		}
		int x = n;
		List<Integer> ans = new ArrayList<>();
		while (x!=0){
			ans.add(x);
			x = prev[x];
		}
		ans = ans.reversed();
		for (int i : ans){
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
