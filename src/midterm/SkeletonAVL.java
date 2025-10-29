package midterm;

import java.util.Scanner;

public class SkeletonAVL {
	public class Node {
		int key;
		Node left, right;
		int height;

		public Node(int key) {
			this.key = key;
			left = right = null;
			this.height = 1;
		}
			}

	Node root;

	// Get the height of the node
	int height(Node node) {
		if (node == null)
			return 0;
		return node.height;
	}

	// Get maximum of two integers
	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// Right rotate subtree rooted with node
	Node rightRotate(Node node) {
		Node leftChild = node.left;
		Node temp = leftChild.right;

		// Perform rotation
		leftChild.right = node;
		node.left = temp;

		// Update heights
		node.height = max(height(node.left), height(node.right)) + 1;
		leftChild.height = max(height(leftChild.left), height(leftChild.right)) + 1;

		// Return new root
		return leftChild;
	}

	// Left rotate subtree rooted with node
	Node leftRotate(Node node) {
		Node rightChild = node.right;
		Node temp = rightChild.left;

		// Perform rotation
		rightChild.left = node;
		node.right = temp;

		// Update heights
		node.height = max(height(node.left), height(node.right)) + 1;
		rightChild.height = max(height(rightChild.left), height(rightChild.right)) + 1;

		// Return new root
		return rightChild;
	}

	// Get balance factor of node
	int getBalance(Node node) {
		if (node == null)
			return 0;
		return height(node.left) - height(node.right);
	}

	// Insert a key into the AVL tree and return the new root of the subtree
	Node insert(Node root, int key) {
		if (root == null)
			return new Node(key);

		if (key < root.key)
			root.left = insert(root.left, key);
		else if (key > root.key)
			root.right = insert(root.right, key);
		else
			return root;

		// Update height of root
		root.height = 1 + max(height(root.left), height(root.right));

		// Get balance factor
		int balance = getBalance(root);

		// Left Left Case
		if (balance > 1 && key < root.left.key)
			return rightRotate(root);

		// Right Right Case
		if (balance < -1 && key > root.right.key)
			return leftRotate(root);

		// Left Right Case
		if (balance > 1 && key > root.left.key) {
			root.left = leftRotate(root.left);
			return rightRotate(root);
		}

		// Right Left Case
		if (balance < -1 && key < root.right.key) {
			root.right = rightRotate(root.right);
			return leftRotate(root);
		}

		return root;
	}

	public int countLeaves(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return 1;
		}
		int leftSum = countLeaves(node.left);
		int rightSum = countLeaves(node.right);

		return leftSum + rightSum;
	}
	public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int n = scan.nextInt();
	SkeletonAVL tree = new SkeletonAVL();

	for (int i = 0; i < n; i++) {
		int val = scan.nextInt();
		tree.root = tree.insert(tree.root, val);
	}

	int leaves = tree.countLeaves(tree.root);
	System.out.println(leaves);
	scan.close();
	}
}

