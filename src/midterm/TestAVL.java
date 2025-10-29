package midterm;

public class TestAVL {
	public static void main(String[] args) {
		AVL tree = new AVL();

		// ===== INSERTION TEST =====
		int[] values = {50, 30, 70, 20, 40, 60, 80};
		for (int v : values) {
			tree.insert(v);
		}
		System.out.println("Tree after insertions (level order):");
		tree.levelPrinting();
		// Expected (balanced AVL, level order may vary slightly depending on rotations)
		// [50] [30] [70] [20] [40] [60] [80]

		// ===== TRAVERSALS =====
		System.out.print("Preorder: ");
		tree.preOrder();   // Expected: [50] [30] [20] [40] [70] [60] [80]
		System.out.print("Inorder: ");
		tree.inOrder();	// Expected: [20] [30] [40] [50] [60] [70] [80]
		System.out.print("Postorder: ");
		tree.postOrder();  // Expected: [20] [40] [30] [60] [80] [70] [50]

		// ===== SEARCH =====
		System.out.println("Search 60: " + tree.search(60)); // Expected: true
		System.out.println("Search 100: " + tree.search(100)); // Expected: false

		// ===== SUM OF TREE =====
		System.out.println("Sum of all nodes: " + tree.sumOfTree());
		// Expected: 50+30+70+20+40+60+80 = 350

		// ===== LEAVES =====
		System.out.println("Number of leaves: " + tree.howManyLeaves());
		// Expected leaves = 4 → (20, 40, 60, 80)
		System.out.println("Sum of leaves: " + tree.sumofLeaves());
		// Expected sum = 20+40+60+80 = 200

		// ===== SUM AT LEVEL =====
		// Level 0: [50]
		// Level 1: [30, 70]
		// Level 2: [20, 40, 60, 80]
		System.out.println("Sum at level 0: " + tree.sumAtLevel(0)); // 50
		System.out.println("Sum at level 1: " + tree.sumAtLevel(1)); // 30+70=100
		System.out.println("Sum at level 2: " + tree.sumAtLevel(2)); // 200

		// ===== REMOVAL TEST =====
		System.out.println("Removing 70...");
		tree.remove(70);
		System.out.print("Level order after removal: ");
		tree.levelPrinting();
		// Expected structure remains balanced
		// Possible output: [50] [30] [80] [20] [40] [60]

		// ===== FINAL CHECK =====
		System.out.println("Sum of tree after removal: " + tree.sumOfTree());
		// Expected: 50+30+80+20+40+60 = 280
	}
}
