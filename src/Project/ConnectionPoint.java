package Project;

import java.sql.Connection;
import java.util.ArrayList;

public class ConnectionPoint {

	private String kind;
	private String name;
	private double x; // meters, X-axis increases to the East
	private double y; // meters, Y-axis increases to the North
	private ArrayList<Integer> neighbors; // List of connected vertex indices

	public ConnectionPoint(String kind, String name, double x, double y) {
		this.kind = kind;
		this.name = name;
		this.x = x;
		this.y = y;
		this.neighbors = new ArrayList<>();
	}
	
	public void addNeighbor(int vertexIndex) {
		if (!neighbors.contains(vertexIndex)) {
			neighbors.add(vertexIndex);
		}
	}
	
	public ArrayList<Integer> getNeighbors() {
		return neighbors;
	}

	public String getString() {
		return kind;
	}

	public String getName() {
		return name;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setString(String kind) {
		this.kind = kind;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}


	@Override
	public String toString() {
		return name + ", (" + x + ", " + y + "), " + kind;
	}
}