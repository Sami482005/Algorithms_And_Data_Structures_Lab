package Homework.graphs;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Homework {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); //nbr of vertices
		int m = scanner.nextInt(); //nbr of edges

		// List of vertices. These vertices are indexed.
		// Each index represents a list of neighbors to that index (which is the vertex)
		List<List<Integer>> adj = new ArrayList<>(n+1);
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<>());

		for (int e = 0; e < m; e++){
			int v = scanner.nextInt();
			int w = scanner.nextInt();
			adj.get(v).add(w);
			adj.get(w).add(v);
		}
		/*
		// Finding the max degree of the vertices
		int max = 0;
		int index = 0;
		for (int v = 0; v <= n; v++){
			if (adj.get(v).size() > max){
				max = adj.get(v).size();
				index = v;
			}
		}
		System.out.printf("%d: %d\n", index, max);
		*/

		// Finding a list of all the vertices with degree 0;
		List<Integer> l = new ArrayList<>();
		for (int v = 1; v <= n; v++){
			if (adj.get(v).size() == 0)
				l.add(v);
		}
		if (l.size() == 0)
			System.out.println("None");
		else{
			for (int v : l){
				System.out.print(v + ", ");
			}
			System.out.println();
		}
		scanner.close();
	}
}
