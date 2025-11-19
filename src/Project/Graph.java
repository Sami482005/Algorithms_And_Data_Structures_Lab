package Project;

import java.lang.reflect.Array;
import java.util.*;

public class Graph {
	private List<WeightedEdge>[] adj;

	public Graph(int n){
		adj = new ArrayList[n];
		for (int v = 0; v < n; v++){
			adj[v] = new ArrayList<>();
		}
	}
	public void addEdge(WeightedEdge e){
		ConnectionPoint v = e.either(), w = e.other(v);
		adj[].add(e);


	}
}
