package Project;

public class ConnectionPoint {

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