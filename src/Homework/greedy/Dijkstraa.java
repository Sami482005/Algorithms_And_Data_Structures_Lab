package Homework.greedy;

import java.util.*;

public class Dijkstraa {

	public class Edge{
		public int to;
		public int weight;

		public Edge(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
	}

	public class Node implements Comparable<Node>{
		public int city;
		public int dist;
		public int compareTo(Node that){
			return Integer.compare(this.dist, that.dist);
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int d = sc.nextInt();

		List<Integer>
	}
}
