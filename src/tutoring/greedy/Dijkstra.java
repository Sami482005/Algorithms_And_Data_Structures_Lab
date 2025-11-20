package tutoring.greedy;

import java.util.*;

public class Dijkstra {
	public static class Edge{
		public int to, weight;

		public Edge(int to, int weight){
			this.to = to;
			this.weight = weight;
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
		int x = sc.nextInt();

		List<List<Edge>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++)
			graph.add(new ArrayList<>());
		
		for (int i = 0; i < m; i++)
			graph.get(sc.nextInt()).add(new Edge(sc.nextInt(), sc.nextInt()));
		

		int[] dist = new int[n+1];
		int[] prev = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		prev[1] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0));

		sc.close();
		while (!pq.isEmpty()){
			Node current = pq.poll();
			int city = current.city;
			int distance = current.dist;

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

		List<Integer> ans = new ArrayList<>();
		for (int i = 1; i < dist.length; i++){
			if (dist[i] < x) ans.add(i);
		}
		ans.sort(null);
		for (int i : ans){
			System.out.println(i);
		}
	}
}
