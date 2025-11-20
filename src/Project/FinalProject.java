package Project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FinalProject {
	public static class WeightedEdge implements Comparable <WeightedEdge> {
		public int to;
		public int weight;

		public WeightedEdge(int w, int weight){
			this.to = w;
			this.weight = weight;
		}

		public int compareTo(WeightedEdge that){
			return Integer.compare(this.weight, that.weight);
		}
	}
	public static class Node implements Comparable<Node>{
		public int city;
		public double dist;
		public Node(int city, double dist){
			this.city = city;
			this.dist = dist;
		}

		public int compareTo(Node that){
			return Double.compare(this.dist, that.dist);
		}
	}
	public static class ConnectionPoint {

	private String kind;
	private String name;
	private int x; // meters, X-axis increases to the East
	private int y; // meters, Y-axis increases to the North

	public ConnectionPoint(String kind, String name, int x, int y) {
		this.kind = kind;
		this.name = name;
		this.x = x;
		this.y = y;
	}
	
	public String getString() {
		return kind;
	}

	public String getName() {
		return name;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setString(String kind) {
		this.kind = kind;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}


	@Override
	public String toString() {
		return name + ", (" + x + ", " + y + "), " + kind;
	}
}
	

	public static List<List<Integer>> graph;
	public static void main(String[] args){
		graph = new ArrayList<>();
		int n = 26; // number of vertices (indices 1..25 used)
		for (int i = 0; i < n; i++)
			graph.add(new ArrayList<>());
		ConnectionPoint[] vertices = graph();
		System.out.println("These are your available vertices: ");
		printVertices(vertices);
		System.out.println("These are the available edges: ");
		printEdges(vertices);
		Scanner sc = new Scanner(System.in);
		System.out.println("Input your starting location: ");
		int source = sc.nextInt();
		System.out.println("Input your final destination: ");
		int destination = sc.nextInt();
		if (source <= 0 || source >= vertices.length || destination <= 0 || destination >= vertices.length) {
			System.out.println("Source/destination must be between 1 and " + (vertices.length-1));
			sc.close();
			return;
		}
		List<Integer> path = path(source, destination, vertices);
		printOutput(path, vertices);
		sc.close();
	}
	
	public static void addNeighbors(int... neighbors) {
		for (int n : neighbors){
			for (int j : neighbors){
				if (n != j){
					graph.get(n).add(j);
				}
			}
		}
	}

	public static void printOutput(List<Integer> path, ConnectionPoint[] vertices){
		if (path == null || path.isEmpty()) {
			System.out.println("No path found.");
			return;
		}
		if (path.size() == 1) {
			System.out.println("You are already at " + vertices[path.get(0)]);
			return;
		}
		System.out.println("Path:");
		for (int i = 0; i < path.size() - 1; i++){
			int from = path.get(i);
			int to = path.get(i+1);
			int x = distanceX(vertices[from], vertices[to]);
			int y = distanceY(vertices[from], vertices[to]);
			if (i == 0) System.out.print("From " + vertices[from].getName() + " to " + vertices[to].getName() + ": ");
			else System.out.print("Then to " + vertices[to].getName() + ": ");
			if (x > 0) System.out.print(x + "m East, ");
			else if (x < 0) System.out.print(-x + "m West, ");
			else System.out.print("0m East/West, ");
			if (y > 0) System.out.print(y + "m North");
			else if (y < 0) System.out.print(-y + "m South");
			else System.out.print("0m North/South");
			System.out.println();
		}
		System.out.println("Arrived at destination: " + vertices[path.get(path.size()-1)].getName());
	}

	public static void printVertices(ConnectionPoint[] vertices){
		for (int i = 1; i < vertices.length; i++){
			System.out.println(i + ") " + vertices[i]);
		}
	}
	public static void printEdges(ConnectionPoint[] vertices){
		for (int i = 1; i < graph.size(); i++){
			if (graph.get(i) != null){
				for (int nei : graph.get(i)){
					System.out.print("(" + vertices[i].getName() + ", " + vertices[nei].getName() + ", (");
					int x = distanceX(vertices[i], vertices[nei]);
					if (x > 0) System.out.print(x + "m East, ");
					else if (x < 0) System.out.print(-x + "m West, ");
					int y = distanceY(vertices[i], vertices[nei]);
					if (y > 0) System.out.print(y + "m North");
					else if (y < 0) System.out.print(-y + "m South");
					System.out.println(")");
				}
				System.out.println();
			
				}
			}
		}
	
	public static int distanceX(ConnectionPoint u, ConnectionPoint v) {
		int dx = v.getX() - u.getX();
		return dx;
	}
	public static int distanceY(ConnectionPoint u, ConnectionPoint v){
		int dy = v.getY() - u.getY();
		return dy;
	}

	public static ConnectionPoint[] graph(){
		ConnectionPoint[] vertices = new ConnectionPoint[26];
		vertices[1] = new ConnectionPoint("University", "LAU", 0, 0);
		vertices[2] = new ConnectionPoint("Intersection", "BBB", 69, 94);
		vertices[3] = new ConnectionPoint("Intersection", "HB", 69, 232);
		vertices[4] = new ConnectionPoint("Restaurant", "Sushi Bell", 150, 560);
		vertices[5] = new ConnectionPoint("Intersection", "Bliss & AUB", 100, 1000);
		vertices[6] = new ConnectionPoint("University", "AUB", 8, 1200);
		vertices[7] = new ConnectionPoint("Store", "PlayerOne Entertainment - Hamra", 200, 380);
		vertices[8] = new ConnectionPoint("Intersection", "NY", 222, 221);
		vertices[9] = new ConnectionPoint("Store", "Lima Gelato", 333, 596);
		vertices[10] = new ConnectionPoint("Clinic", "Eyedeas Smart Optics- Mahmoud Hakim", 334, 666);
		vertices[11] = new ConnectionPoint("Intersection", "Hamra", 550, 450);
		vertices[12] = new ConnectionPoint("Restaurant", "Barbar - Hamra", 587, 180);
		vertices[13] = new ConnectionPoint("Building", "Art Gallery", 600, 610);
		vertices[14] = new ConnectionPoint("Clinic", "Dr. Mohammad Jomaa Clinic", 610, 1070);
		vertices[15] = new ConnectionPoint("Hospital", "AUBMC", 700, 612);
		vertices[16] = new ConnectionPoint("Intersection", "ERA", 688, 96);
		vertices[17] = new ConnectionPoint("Intersection", "RH", 688, 240);
		vertices[18] = new ConnectionPoint("Intersection", "Emile Lahoud Intersection", 848, 97);
		vertices[19] = new ConnectionPoint("Building", "Gefinor Center", 800, 730);
		vertices[20] = new ConnectionPoint("Intersection", "OmBA", 588, 270);
		vertices[21] = new ConnectionPoint("Intersection", "Emile & Barbar", 587, 95);
		vertices[22] = new ConnectionPoint("Building", "Gezairi Building", 0, 94);
		vertices[23] = new ConnectionPoint("Intersection", "HS & Hamra", 749, 450);
		vertices[24] = new ConnectionPoint("Intersection", "HS", 749, 470);
		vertices[25] = new ConnectionPoint("Intersection", "Gefinor & AUBMC", 800, 642);
		
		addNeighbors(2, 3,21);
		addNeighbors(4, 7, 11);
		addNeighbors(5, 14,3,6);
		addNeighbors(7, 8,20);
		addNeighbors(9, 13,10);
		addNeighbors(12, 21,8);
		addNeighbors(13, 24,14,15);
		addNeighbors(14, 19,10);
		addNeighbors(16, 17,18,21);
		addNeighbors(20, 7,17);
		addNeighbors(25, 15,19);
		addNeighbors(22, 1,2,6);
		addNeighbors(23, 24,11);

		return vertices;
	}


	public static List<Integer> path(int source, int destination, ConnectionPoint[] vertices){
		int n = graph.size();
		double[] dist = new double[n];
		int[] prev = new int[n];
		Arrays.fill(dist, Double.POSITIVE_INFINITY);
		Arrays.fill(prev, -1);
		dist[source] = 0;
		prev[source] = -1;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(source,0));

		while (!pq.isEmpty()){
			Node curr = pq.poll();
			int city = curr.city;
			double distance = curr.dist;
			
			if (distance > dist[city]) continue;
			// If we've reached the destination, we can stop early
			if (city == destination) break;

			for (int i : graph.get(city)){
				int dx = vertices[i].getX() - vertices[city].getX();
				int dy = vertices[i].getY() - vertices[city].getY();
				double cost = Math.hypot(dx, dy);
				if (cost + dist[city] < dist[i]){
					dist[i] = cost + dist[city];
					prev[i] = city;
					pq.add(new Node(i, dist[i]));
				}
			}
		}

		// If destination wasn't reached, return null to signal no path
		if (Double.isInfinite(dist[destination])) return null;

		List<Integer> ans = new ArrayList<>();
		int x = destination;
		while (x != -1){
			ans.add(x);
			x = prev[x];
		}
		Collections.reverse(ans);
		return ans;
	}

}
