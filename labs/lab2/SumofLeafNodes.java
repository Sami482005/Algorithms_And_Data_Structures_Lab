package lab2;
import java.util.Scanner;
public class SumofLeafNodes {
	public class Node {
		private int key;
		private Node left;
		private Node right;

		public Node(int key){
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
			return "" + getKey();
		}
	}
	public class BST{
		private Node root;
		public BST(){
			setRoot(root);
		}

		public BST (int key){
			Node root = new Node(key);
			setRoot(root);
		}

		public Node getRoot() {
			return root;
		}

		public void setRoot(Node root) {
			this.root = root;
		}

		public void insert(int key){
			Node node = new Node(key);
			setRoot(insert (getRoot(), node));
		}
		private Node insert(Node root, Node node){
			if (root == null)
				return node;

			if (node.getKey() < root.getKey())
				root.setLeft(insert(root.getLeft(), node));
			else 
				root.setRight(insert(root.getRight(), node));
			return root;
		}

		public void delete(int key){
			Node node = new Node(key);
			setRoot(delete(getRoot(), node));
		}
		private Node delete(Node root, Node node){
			if (root == null)
				return null;
			if (node.getKey() < root.getKey())
				setRoot(delete(root.getLeft(), node));
			else if (node.getKey() > root.getKey())
				setRoot(delete(root.getRight(), node));
			else{
				if (root.getLeft() == null)
					return root.getRight();
				else if (root.getRight() == null)
					return root.getLeft();
				else {
					Node min = findMin(root.getRight());
					root.setKey(min.getKey());
					root.setRight(delete(root.getRight(), min));
				}
			}
			return root;
		}

		public int sumofleafnodes(){
			return sumofleafnodes(getRoot());
		}
		private int sumofleafnodes(Node root){
			if (root == null)
				return 0;
			if (root.getLeft() == null && root.getRight() == null)
				return root.getKey();
			int leftSum = sumofleafnodes(root.getLeft());
			int rightSum = sumofleafnodes(root.getRight());
			if (leftSum == 0) return rightSum;
			if (rightSum == 0) return leftSum;
			return (rightSum + leftSum);
		}

		private Node findMin(Node node){
			while (node.getLeft() != null)
				node = node.getLeft();
			return node;
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int rootValue = sc.nextInt();
		BST tree = new SumofLeafNodes().new BST(rootValue);
		int operations = sc.nextInt();
		if (operations > 105 || operations < 0){
			sc.close();
			throw new IllegalArgumentException("m should be 0<=m<=105. Input the correct value of m");
		}
		for (int i = 0; i <operations; i++){
			int op = sc.nextInt();
			int value = sc.nextInt();
			if (op == 1)
				tree.insert(value);
			else if (op == 2)
				tree.delete(value);
		}
		System.out.println(tree.sumofleafnodes());
		sc.close();
	}
}