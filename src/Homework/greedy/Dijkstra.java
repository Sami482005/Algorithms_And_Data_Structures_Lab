package Homework.greedy;

import java.util.*;


public class Dijkstra {
	/*
	 * An edge has a destination and a weight
	 * They will be added as objects to the graph list
	 * Each vertex will have a list of edges associated with it
	 * 
	 */
	public static class Edge{
		public int to, weight;

		public Edge( int to, int w){
			this.to = to;
			this.weight = w;
		}
	}

	/*
	 * Used for the priority queue to allow the PQ to compare
	 * the distances of the Nodes and sort them by distance
	 * The smallest distance will always be removed first
	 */
	public static class Node implements Comparable<Node>{
		public int city, dist;

		public Node (int city, int dist){
			this.city = city;
			this.dist = dist;
		}

		public int compareTo(Node other){
			return Integer.compare(this.dist, other.dist);
		}
	}

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //Number of vertices
		int m = sc.nextInt(); //Number of edges
		int d = sc.nextInt(); //Destination

		// The graph here is a List of List of objects: Edge
		List<List<Edge>> graph = new ArrayList<>();

		// Initializing the list
		for (int i = 0; i <= n; i++){
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++){
			int a = sc.nextInt(); //Source
			int b = sc.nextInt(); //Destination
			int w = sc.nextInt(); //Weight
			graph.get(a).add(new Edge(b, w)); //This is a directed graph
		}

		//Dijkstra Algorithm
		int[] dist = new int[n + 1]; //Distances from each node to start
		int[] prev = new int[n + 1]; //Prev of each node in path
		prev[1] = 0; //Starting node is 1. its prev is 0

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0; //Because we're starting at 1

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1,0));

		while (!pq.isEmpty()){
			Node cur = pq.poll();
			int city = cur.city;
			int distance = cur.dist;

			if (distance > dist[city]) continue;

			//Relax each outgoing edge
			//Computing new possible distance
			//If it's better than current dist[city], update it
			//Update prev
			//Push the updated node into
			for (Edge e : graph.get(city)){
				int v = e.to;
				int cost = e.weight;
			if (dist[city] + cost < dist[v]) {
				dist[v] = dist[city] + cost;
				prev[v]=city;
				pq.add(new Node(v, dist[v]));
			}
			}
		}
		sc.close();

		if (dist[d] == Integer.MAX_VALUE){
			System.out.println("No Path");
			return;
		}
		System.out.println("The path from 1 to " + d);
		int x = d;
		List<Integer> path = new ArrayList<>();
		while (x != 0){
			path.add(x);
			x = prev[x];
		}
		path = path.reversed();
		for (int p = 0; p < path.size()-1; p++){
			System.out.print(path.get(p) + "->");
		}
		System.out.println(path.get(path.size()-1));
		System.out.println("with distance " + dist[d]);
	}
}
