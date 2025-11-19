package Project;

public class WeightedEdge implements Comparable <WeightedEdge> {
	private ConnectionPoint v;
	private ConnectionPoint w;
	private double weight;

	public WeightedEdge(ConnectionPoint v, ConnectionPoint w, double weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public ConnectionPoint either(){return v;}
	public ConnectionPoint other(ConnectionPoint vertex){
		return vertex == v ? w : v;
	}

	public int compareTo(WeightedEdge that){
		return Double.compare(this.weight, that.weight);
	}

	public double weight(){return weight;}

	@Override
	public String toString(){
		return v + "->" + w + String.format("%5.2f", weight);
	}
}
