package Project;

public class HamraGraph {
	static final int max = 26;
	public static ConnectionPoint[] vertices = new ConnectionPoint[max];

	public static void main(String[] args) {
		// Initialize vertices
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
		// Add edges (bidirectional) - group by vertex for clarity
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

		System.out.println("This is the list of vertices");
		for (int i = 1; i <= 25; i++)
			System.out.println(vertices[i]);
		System.out.println("\n\nThese are the edges");
		printGraph();
		
	}

	// Helper method to add multiple neighbors to a vertex at once (bidirectional)
	public static void addNeighbors(int vertex, int... neighbors) {
		for (int neighbor : neighbors) {
			vertices[vertex].addNeighbor(neighbor);
			vertices[neighbor].addNeighbor(vertex);
		}
	}

	// Helper method to print the graph
	public static void printGraph() {
		for (int i = 1; i < max; i++) {
			if (vertices[i] != null) {
				for (int nei : vertices[i].getNeighbors()){
					System.out.print("(" + vertices[i].getName() + ", ");
					System.out.print(vertices[nei].getName() + ",(");
					double x = distanceX(vertices[i], vertices[nei]);
					if (x > 0){
						System.out.print(x + "m East, ");
					}
					else if (x < 0){
						System.out.print(-x + "m West, ");
					}
					double y = distanceY(vertices[i], vertices[nei]);
					if (y > 0){
						System.out.print(y + "m North)");
					}
					else if (y < 0){
						System.out.print(-y + "m South)");
					}
					else
						System.out.print("0)");
					System.out.println(")");
				}
				System.out.println();
			}
		}
	}
	public static double distanceX(ConnectionPoint u, ConnectionPoint v) {
		double dx = v.getX() - u.getX();
		return dx;
	}
	public static double distanceY(ConnectionPoint u, ConnectionPoint v){
		double dy = v.getY() - u.getY();
		return dy;
	}
}