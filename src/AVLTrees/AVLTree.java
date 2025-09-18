package AVLTrees;

public class AVLTree<E extends Comparable<E>> {
	private AVLNode<E> root;

	public AVLTree(){
		this.root = null;
	}
	public AVLNode<E> getRoot(){
		return root;
	}
	// Insert a node
	// Time complexity: O(log n)
	// Space complexity: O(1)
	public void insert (E data){
		AVLNode<E> node = new AVLNode<E>(data);
		root = insertRecursively (root, node);
	}
	// Recursive function to insert a node
	private AVLNode<E> insertRecursively(AVLNode<E> root, AVLNode<E> node){
		if (root == null)
			return node;
		E value = node.getData();
		if (value.compareTo(root.getData()) < 0)
			root.setLeft(insertRecursively(root.getLeft(), node));
		else if (value.compareTo(root.getData()) > 0)
			root.setRight(insertRecursively(root.getRight(), node));
		
		return balance(root);
	}

	// Remove a node
	// Time complexity: O(log n)
	// Space complexity: O(1)
	public void remove(E data){
		AVLNode<E> node = new AVLNode<E>(data);
		root = removeRecursive(root, node);
	}
	// Recursive function to remove a node
	public AVLNode<E> removeRecursive(AVLNode<E> root, AVLNode<E> node){
		if (root == null)
			return null;

		E data = node.getData();
		if (data.compareTo(root.getData()) < 0)
			root.setLeft(removeRecursive(root.getLeft(), node));
		else if (data.compareTo(root.getData()) > 0)
			root.setRight(removeRecursive(root.getRight(), node));
		else{
			if (root.getLeft() == null)
				return root.getRight();
			else if (root.getRight() == null)
				return root.getLeft();
			AVLNode<E> minNode = findMin(root.getRight()); // set the root to be the minimum value larger than it
			root.setData(minNode.getData());
			root.setRight(removeRecursive(root.getRight(), minNode));
		}
		return balance (root);
	}

	private AVLNode<E> findMin(AVLNode<E> node){
		while (node.getLeft() != null)
			node = node.getLeft();
		return node;
	}

	public boolean search(E data){
		return searchRecursively(root, data);
	}
	private boolean searchRecursively(AVLNode<E> root, E data){
		if (root == null)
			return false;
		if (data.compareTo(root.getData()) == 0)
			return true;

		return data.compareTo(root.getData()) < 0 ? searchRecursively(root.getLeft(), data) : searchRecursively(root.getRight(), data);
	}

	public int height(AVLNode<E> node){
		if (node == null)
			return 0;
		
		int leftheight = height(node.getLeft());
		int rightheight = height(node.getRight());
		return Math.max(leftheight, rightheight) + 1;
	}

	private int balanceFactor (AVLNode<E> node){
		if (node == null)
			return 0;

		return height(node.getLeft()) - height(node.getRight());
	}

	private AVLNode<E> balance (AVLNode<E> node){
		int bf = balanceFactor(node);
		if (bf > 1){ // left side is heavy
			if (balanceFactor(node.getLeft()) < 0) // If this is an LR rotation
                node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
		} 
		if (bf < -1){ // right side is heavy
			if (balanceFactor(node.getRight()) > 0) // If this is an RL rotation
				node.setRight(rotateRight(node.getRight()));
			return rotateLeft(node);
		}
		return node;
	}

	private AVLNode<E> rotateRight(AVLNode<E> y){
		AVLNode<E> x = y.getLeft();
		AVLNode<E> T2 = x.getRight();

		x.setRight(y);
		y.setLeft(T2);

		return x;
	}
	private AVLNode<E> rotateLeft(AVLNode<E> x){
		AVLNode<E> y = x.getRight();
		AVLNode<E> T2 = y.getLeft();

		y.setLeft(x);
		x.setRight(T2);

		return y;
	}

	public String preorder_Printing(AVLNode<E> node){
		if (node == null)
			return "";
		return node.getData() + " " + preorder_Printing(node.getLeft()) + preorder_Printing(node.getRight());
	}

	public String inorder_Printing(AVLNode<E> node){
		if (node == null)
			return "";
		return inorder_Printing(node.getLeft()) + node.getData() + " " + inorder_Printing(node.getRight());
	}

	public String postorder_Printing(AVLNode<E> node){
		if (node == null)
			return "";
		return postorder_Printing(node.getLeft()) + postorder_Printing(node.getRight()) + node.getData() + " ";
	}
}
