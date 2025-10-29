package midterm;

import java.util.Scanner;

public class SkeletonBST {

	public class Node {
		private int data;
		private Node left, right;

		public Node(int d, Node l, Node r) {
			this.data = d;
			this.left = l;
			this.right = r;
		}

		public Node(int d) {
			this(d, null, null);
		}
	}

	public Node root;

	public void insert(int value) {
		root = insertHelper(value, root);
	}

	private Node insertHelper(int value, Node root) {
		if (root == null)
			return new Node(value);
		else if (root.data > value)
			root.left = insertHelper(value, root.left);
		else if (root.data < value)
			root.right = insertHelper(value, root.right);
		return root;
	}

	public void delete(int value) {
		root = deleteHelper(value, root);
	}

	private Node deleteHelper(int value, Node root) {
		if (root == null)
			return null;
		else if (root.data > value)
			root.left = deleteHelper(value, root.left);
		else if (root.data < value)
			root.right = deleteHelper(value, root.right);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {
				Node min = findMin(root.right);
				root.data = min.data;
				root.right = deleteHelper(min.data, root.right);
			}
		}
		return root;
	}

	private Node findMin(Node node) {
		while (node.left != null)
			node = node.left;
		return node;
	}

	public int getSumAtLevel(Node node, int level) {
		if (node == null)
			return 0;
		if (level == 1) {
			return node.data;
		}
		return getSumAtLevel(node.left, level - 1) + getSumAtLevel(node.right, level - 1);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int j = scan.nextInt();

		SkeletonBST tree = new SkeletonBST();
		tree.insert(n);

		for (int i = 0; i < m; i++) {
			int op = scan.nextInt();
			int k = scan.nextInt();
			if (op == 1) {
				tree.insert(k);
			} else if (op == 2) {
				tree.delete(k);
			}
		}

		int val = tree.getSumAtLevel(tree.root, j);
		System.out.println(val);
		scan.close();
	}
}
