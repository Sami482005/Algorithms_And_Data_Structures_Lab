package AVLTrees;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		AVLTree<Integer> avlTree = new AVLTree<>();
		for (int i = 0; i < n; i++) {
			int value = scanner.nextInt();
			avlTree.insert(value);
		}
		// Print the AVL tree
		System.out.println("Preorder: " + avlTree.preorder_Printing(avlTree.getRoot()));
		System.out.println("Inorder: " + avlTree.inorder_Printing(avlTree.getRoot()));
		System.out.println("Postorder: " + avlTree.postorder_Printing(avlTree.getRoot()));
		scanner.close();
	}
}
