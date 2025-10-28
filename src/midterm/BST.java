package midterm;

import java.util.*;
public class BST {
	private class Node{
		private int data;
		private Node left;
		private Node right;

		public Node(int data){
			setData(data);
			setLeft(null);
			setRight(null);
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

	public BST(){
		setRoot(null);
	}
	public BST(int data){
		Node root = new Node(data);
		setRoot(root);
	}
	public BST(Node root){
		setRoot(root);
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
		else
			root.setData(node.getData());
		return root;
	}

	public void delete(int data){
		setRoot(delete(getRoot(), data));
	}
	private Node delete(Node root, int data){
		if (root == null)
			return null;
		if (data > root.getData())
			root.setRight(delete(root.getRight(), data));
		else if (data < root.getData())
			root.setLeft(delete(root.getLeft(), data));
		else {
			if (root.getLeft() == null) return root.getRight();
			if (root.getRight() == null) return root.getLeft();
			int min = findMin(root.getRight());
			root.setData(min);
			root.setRight(delete(root.getRight(), min));
		}
		return root;
	}
	private int findMin(Node root){
		while (root.getLeft() != null) root = root.getLeft();
		return root.getData();
	}

	public int sumofLeaves(){
		return sumofLeaves(getRoot());
	}
	private int sumofLeaves(Node root){
		if (root == null) return 0;
		if (root.getLeft() == null && root.getRight() == null)
			return root.getData();
		int leftSum = sumofLeaves(root.getLeft());
		int rightSum = sumofLeaves(root.getRight());
		return leftSum + rightSum;
	}

	public int countLeaves(){
		return countLeaves(getRoot());
	}
	private int countLeaves(Node root){
		if (root == null)
			return 0;
		if (root.getLeft() == null && root.getRight() == null)
			return 1;
		int leftCount = countLeaves(root.getLeft());
		int rightCount = countLeaves(root.getRight());
		return leftCount + rightCount;
	}

	public int sumatLevel(int j){
		if (getRoot() == null)
			return 0;
		Queue<Node> q = new LinkedList<>();
		int level = 0;
		q.add(getRoot());
		while (!q.isEmpty()){
			int sum = 0;
			int size = q.size();
			Node current = q.poll();
			for (int i = 0; i < size; i++){
				if (level == j)
					sum +=current.getData();

				if (current.getLeft() != null) q.add(current.getLeft());
				if (current.getRight() != null) q.add(current.getRight());
			}
			if (level == j) return sum;
			level++;
		}
		return 0;
	}

	public int sumofTree(){
		if (getRoot() == null) return 0;
		Queue<Node> q = new LinkedList<>();
		int sum = 0;
		q.add(getRoot());
		while (!q.isEmpty()){
			Node current = q.poll();
			sum += current.getData();
			if (current.getLeft() != null) q.add(current.getLeft());
			if (current.getRight() != null) q.add(current.getRight());
		}
		return sum;
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
}
