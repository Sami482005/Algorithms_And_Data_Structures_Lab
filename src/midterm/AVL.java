package midterm;

import java.util.LinkedList;
import java.util.Queue;

public class AVL {
	public class Node{
		private int data;
		private Node left;
		private Node right;

		public Node(int data){
			setData(data);
			setLeft(null);
			setRight(null);
		}
		public Node(int data, Node left, Node right){
			setData(data);
			setLeft(left);
			setRight(right);
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
		return "[" + getData() + "] ";
	}
	}

	private Node root;

	public AVL(){
		setRoot(null);
	}
	public AVL(int data){
		Node node = new Node(data);
		setRoot(node);
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void insert(int data){
		Node node = new Node(data);
		setRoot(insert(getRoot(), node));
	}

	private Node insert(Node root, Node node){
		if (root == null)
			return node;
		if (node.getData() < root.getData())
			root.setLeft(insert(root.getLeft(), node));
		else if (node.getData() > root.getData())
			root.setRight(insert(root.getRight(), node));
		return balance(root);
	}

	public void remove (int data){
		setRoot(remove(getRoot(), data));
	}
	private Node remove(Node root, int data){
		if (root == null)
			return null;
		if (data < root.getData())
			root.setLeft(remove(root.getLeft(), data));
		else if (data > root.getData())
			root.setRight(remove(root.getRight(), data));
		else {
			if (root.getLeft() == null) return root.getRight();
			if (root.getRight() == null) return root.getLeft();
			int min = findMin(root.getRight());
			root.setData(min);
			root.setRight(remove(root.getRight(), min));
		}
		return balance(root);
	}

	public boolean search (int data){
		return search(getRoot(), data);
	}
	private boolean search (Node root, int data){
		if (root == null)
			return false;
		if (data < root.getData())
			return search(root.getLeft(), data);
		else if (data > root.getData())
			return search(root.getRight(), data);
		else
			return true;
	}

	private int findMin(Node root){
		while (root.getLeft() != null)
			root = root.getLeft();
		return root.getData();
	}

	private int height(Node root){
		if (root == null)
			return 0;
		int leftHeight = height(root.getLeft());
		int rightHeight = height(root.getRight());
		return Math.max(leftHeight, rightHeight) + 1;
	}

	private int balancingFactor(Node root){
		if (root == null)
			return 0;
		return height(root.getLeft()) - height(root.getRight());
	}

	private Node balance(Node root){
		int bf = balancingFactor(root);
		if (bf > 1){
			if (balancingFactor(root.getLeft()) < 0)
				root.setLeft(rotateLeft(root.getLeft()));
			return rotateRight(root);
		}
		else if (bf < -1){
			if (balancingFactor(root.getRight()) > 0)
				root.setRight(rotateRight(root.getRight()));
			return rotateLeft(root);
		}
		else
			return root;
	}
	private Node rotateRight(Node root){
		Node temp = root.getLeft();
		Node right = temp.getRight();
		temp.setRight(root);
		root.setLeft(right);
		return temp;
	}

	private Node rotateLeft(Node root){
		Node temp = root.getRight();
		Node left = temp.getLeft();
		temp.setLeft(root);
		root.setRight(left);
		return temp;
	}

	public int sumofLeaves(){
		return sumofLeaves(getRoot());
	}
	private int sumofLeaves(Node root){
		if (root == null)
			return 0;
		if (root.getLeft() == null && root.getRight() == null)
			return root.getData();
		int leftSum = sumofLeaves(root.getLeft());
		int rightSum = sumofLeaves(root.getRight());
		return leftSum + rightSum;
	}

	public int howManyLeaves(){
		return howManyLeaves(getRoot());
	}
	private int howManyLeaves(Node root){
		if (root == null) return 0;
		if (root.getLeft() == null && root.getRight() == null)
			return 1;
		int leftSum = howManyLeaves(root.getLeft());
		int rightSum = howManyLeaves(root.getRight());
		return leftSum + rightSum;
	}

	public int sumatLeaves(int j){
		if (getRoot() == null)
			return 0;
		Queue<Node> q = new LinkedList<>();
		q.add(getRoot());
		int level = 0;
		while (!q.isEmpty()){
			int sum = 0;
			int size = q.size();
			for (int i = 0; i < size; i++){
				Node current = q.poll();
				if (level == j) sum += current.getData();

				if (current.getLeft() != null) q.add(current.getLeft());
				if (current.getRight() != null) q.add(current.getRight());
				
			}
			if (level == j) return sum;
			level++;
		}
		return 0;
	}
	
	public void preOrder(){
		if (getRoot() == null) return;
		preOrder(getRoot());
		System.out.println();
	}
	private void preOrder(Node root){
		System.out.print(root);
		if (root.getLeft() != null)
			preOrder(root.getLeft());
		if (root.getRight() != null)
			preOrder(root.getRight());
	}
	public void inOrder(){
		if (getRoot() == null) return;
		inOrder(getRoot());
		System.out.println();
	}
	private void inOrder(Node root){
		if (root.getLeft() != null)
			inOrder(root.getLeft());
		System.out.print(root);
		if (root.getRight() != null)
			inOrder(root.getRight());
	}
	public void postOrder(){
		if (getRoot() == null) return;
		postOrder(getRoot());
		System.out.println();
	}
	private void postOrder(Node root){
		if (root.getLeft() != null)
			preOrder(root.getLeft());
		if (root.getRight() != null)
			preOrder(root.getRight());
		System.out.print(root);
	}

	public void levelPrinting(){
		if (getRoot() == null) return;
		Queue<Node> q = new LinkedList<>();
		q.add(getRoot());
		while (!q.isEmpty()){
			Node current = q.poll();
			System.out.print(current);
			if (current.getLeft() != null) q.add(current.getLeft());
			if (current.getRight() != null) q.add(current.getRight());
		}
		System.out.println();
	}

	public int sumOfTree(){
		if (getRoot() == null) return 0;
		Queue<Node> q = new LinkedList<>();
		q.add(getRoot());
		int sum = 0;
		while (!q.isEmpty()){
			Node current = q.poll();
			sum += current.getData();
			if (current.getLeft() != null) q.add(current.getLeft());
			if (current.getRight() != null) q.add(current.getRight());
		}
		return sum;
	}
}
