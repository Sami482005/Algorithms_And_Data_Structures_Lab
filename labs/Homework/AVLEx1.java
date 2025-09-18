package Homework;
import java.util.Scanner;
public class AVLEx1 {
	class Node {
		int key;
		Node left;
		Node right;

		public Node (int key){
			this.key = key;
			this.left = null;
			this.right = null;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
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
			return Integer.toString(getKey());
		}
	}
	
	Node root;
	public AVLEx1(){
		this.root = null;
	}
	public AVLEx1(Node root){
		this.root = root;
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}

	// Insert a node
	public void insert (int key){
		Node node = new Node(key);
        setRoot(recursivelyinsert(getRoot(), node));
	}
	private Node recursivelyinsert (Node root, Node node){
		if (root == null)
            return node;
        if (node.getKey() >= root.getKey()){
            root.setRight(recursivelyinsert(root.getRight(), node));
        }
        else
            root.setLeft(recursivelyinsert(root.getLeft(), node));
        return balance(root);
	}

	// height
	private int height(Node node){
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
		
	}


	// Remove a node
	public void remove (int key){
        Node node = new Node(key);
        setRoot(recursivelyremove(getRoot(), node));
		
	}
	private Node recursivelyremove(Node root, Node node){
        if (root == null)
            return null;
        if (node.getKey() < root.getKey())
            root.setLeft(recursivelyremove(root.getLeft(), node));
		else if (node.getKey() > root.getKey())
            root.setRight(recursivelyremove(root.getRight(), node));
        else{
            if (root.getLeft() == null)
                return root.getRight();
            else if (root.getRight() == null)
                return root.getLeft();
        Node min = findmin(node.getRight());
        root.setKey(min.getKey());
        root.setRight(recursivelyremove(root.getRight(), min)); 
        }
		return balance(root);
	}

	// Find minimum node
	private Node findmin(Node node){
		while (node.getLeft() != null) {
			node = node.getLeft();
		}
		return node;
	}

	// BalancingFactor
	private int BalancingFactor(Node node){
		return height (node.getLeft()) - height(node.getRight());
	}

	//Balance
	private Node balance (Node node){
		int bf = BalancingFactor(node);
		if (bf > 1) {
			if (BalancingFactor(node.getLeft()) < 0)
				node.setLeft(rotateleft(node.getLeft()));
			return rotateright(node);
		}
		if (bf < -1) {
			if (BalancingFactor(node.getRight()) > 0)
				node.setRight(rotateright(node.getRight()));
			return rotateleft(node);
		}
		return node;
		
	}

	// Left turn
	private Node rotateright(Node node){
		Node y = node.getLeft();
		Node T2 = y.getRight();
		y.setRight(node);
		node.setLeft(T2);
		return y;
	}

	// Right turn
	private Node rotateleft(Node node){
		Node y = node.getRight();
		Node T2 = y.getLeft();
		y.setLeft(node);
		node.setRight(T2);
		return y;
		
	}
	public boolean search (int key){
		return searchrecursively(getRoot(), key);
	}
	private boolean searchrecursively(Node root, int key){
		if (root == null)
			return false;
		if (key == root.getKey())
			return true;
		return key < root.getKey() ? searchrecursively(root.getLeft(), key) : searchrecursively(root.getRight(), key);
		
	}

	public String preorder_Printing(Node node){
	if (node == null)
		return "";
	return node.getKey() + " " + preorder_Printing(node.getLeft()) + preorder_Printing(node.getRight());
	}

	public String inorder_Printing(Node node){
		if (node == null)
			return "";
		return inorder_Printing(node.getLeft()) + node.getKey() + " " + inorder_Printing(node.getRight());
	}

	public String postorder_Printing(Node node){
		if (node == null)
			return "";
		return postorder_Printing(node.getLeft()) + postorder_Printing(node.getRight()) + node.getKey() + " ";
	}

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		AVLEx1 avlTree = new AVLEx1();
		for (int i = 0; i < n; i++) {
			int value = scanner.nextInt();
			avlTree.insert(value);
		}
		// Print the AVL tree
		System.out.println("Preorder: " + avlTree.preorder_Printing(avlTree.getRoot()));
		System.out.println("Inorder: " + avlTree.inorder_Printing(avlTree.getRoot()));
		System.out.println("Postorder: " + avlTree.postorder_Printing(avlTree.getRoot()));
		avlTree.remove(scanner.nextInt());
		System.out.println("After removing an element:");
		System.out.println("Preorder: " + avlTree.preorder_Printing(avlTree.getRoot()));
		System.out.println("Inorder: " + avlTree.inorder_Printing(avlTree.getRoot()));
		System.out.println("Postorder: " + avlTree.postorder_Printing(avlTree.getRoot()));
		System.out.println("Search for an element: " + avlTree.search(scanner.nextInt()));

		scanner.close();
	}
}