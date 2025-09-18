package practicing;
import java.util.Scanner;

public class AVLTree {
	public class Node{
		private int data;
		private Node left;
		private Node right;

		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
		
		@Override
		public String toString(){
			return "" + getData();
		}
	}
	private Node root;
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}

	public AVLTree(){
		this.root = null;
	}
	public AVLTree(int key){
		this.root = new Node(key);
	}

	public String Preorder(Node root){
		return root.toString() + Preorder(root.getLeft()) + Preorder(root.getRight());
	}
	public String Inorder(Node root){
		return Inorder(root.getLeft()) + root.toString() + Inorder(root.getRight());
	}
	public String Postorder(Node root){
		return Inorder(root.getLeft()) + Inorder(root.getRight()) + root.toString();
	}

	public void insert(int key){
		Node node = new Node(key);
		setRoot(insert(getRoot(), node));
	}

	private Node insert(Node root, Node node){
		if (root == null) return node;
		if (less (node, root))
			root.setLeft(insert(root.getLeft(), node));
		else 
			root.setRight(insert(root.getRight(), node));
		return balance(root);
	}

	public void remove(int key){
		Node node = new Node(key);
		setRoot(remove(getRoot(), node));
	}
	private Node remove (Node root, Node node){
		if (root == null) return null;
		if (less(node, root))
			root.setLeft(remove(root.getLeft(), node));
		else if (less(root, node))
			root.setRight(remove(root.getRight(), node));
		else{
			if (root.getLeft() == null)
				return root.getRight();
			else if (root.getRight() == null)
				return root.getLeft();
			else{
				Node min = findMin(root.getRight());
				root.setData(min.getData());
				root.setRight(remove(root.getRight(), min));
			}
		}
		return balance(root);
	}
	public boolean search(int key){
		Node node = new Node(key);
		return search(getRoot(), node);
	}
	private boolean search(Node root, Node node){
		if (root == null) return false;  // Element not found
		if (root.getData() == node.getData())
			return true;
		return less(node, root) ? search(root.getLeft(), node) : search (root.getRight(), node);
	}
	public String preorder(){
		return preorder(getRoot());
	}
	private String preorder(Node root){
		if (root == null) return "";
		return root.toString() + " " + preorder(root.getLeft()) + " " + preorder(root.getRight());
	}
	public String inorder(){
		return inorder(getRoot());
	}
	private String inorder(Node root){
		if (root == null) return "";
		return inorder(root.getLeft()) + " " + root.toString() + " " + inorder(root.getRight());
	}
	public String postorder(){
		return postorder(getRoot());
	}
	private String postorder(Node root){
		if (root == null) return "";
		return postorder(root.getLeft()) + " " + postorder(root.getRight()) + " " + root.toString();
	}

	public Node balance(Node node){
		int bf = balancingFactor(node);
		if (bf > 1){ // the tree is heavy on the left side
			if (balancingFactor(node.getLeft()) < 0)
				node.setLeft(rotateleft(node.getLeft()));
			return rotateright(node);
		}
		else if (bf < -1){ // the tree is heavy on the right side
			if (balancingFactor(node.getRight()) > 0)
				node.setRight(rotateright(node.getRight()));
			return rotateleft(node);
		}
		return node;
	}
	private Node rotateleft(Node node){
		Node y = node.getRight();
		Node t2 = y.getLeft();
		y.setLeft(node);
		node.setRight(t2);
		return y;
	}
	private Node rotateright(Node node){
		Node y = node.getLeft();
		Node t2 = y.getRight();
		y.setRight(node);
		node.setLeft(t2);
		return y;
	}
	private int height(Node node){
		if (node == null) return 0;
		return 1 + Math.max(height(node.getLeft()) , height(node.getRight()));
	}
	private int balancingFactor(Node node){
		if (node == null) return 0;
		int leftheight = height(node.getLeft());
		int rightheight = height(node.getRight());
		return leftheight - rightheight;
	}
	private Node findMin(Node node){
		while (node.getLeft() != null)
			node = node.getLeft();
		return node;
	}
	private boolean less(Node node, Node root){
		return node.getData() < root.getData();
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		AVLTree avlTree = new AVLTree();
		for (int i = 0; i < n; i++) {
			int value = scanner.nextInt();
			avlTree.insert(value);
		}
		// Print the AVL tree
		System.out.println("Preorder: " + avlTree.preorder());
		System.out.println("Inorder: " + avlTree.inorder());
		System.out.println("Postorder: " + avlTree.postorder());
		avlTree.remove(scanner.nextInt());
		System.out.println("After removing an element:");
		System.out.println("Preorder: " + avlTree.preorder());
		System.out.println("Inorder: " + avlTree.inorder());
		System.out.println("Postorder: " + avlTree.postorder());
		System.out.println("Search for an element: " + avlTree.search(scanner.nextInt()));

		scanner.close();

	}
}