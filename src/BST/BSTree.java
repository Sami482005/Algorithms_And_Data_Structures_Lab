package BST;

public class BSTree {
    private BSTNode root;

    public BSTree(){
        this.root = null;
    }
    public BSTree(int data){
        this.root = new BSTNode(data);
    }

    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }
    
    public void insert (int data){
        BSTNode node = new BSTNode(data);
        setRoot(recursivelyInsert(getRoot(), node));
    }
    private BSTNode recursivelyInsert(BSTNode root, BSTNode node){
        if (root == null)
            return node;
        if(node.getData() < root.getData())
            root.setLeft(recursivelyInsert(root.getLeft(), node));
        else if(node.getData() > root.getData())
            root.setRight(recursivelyInsert(root.getRight(), node));

        return root;
    }

    public void remove (int data){
        BSTNode node = new BSTNode (data);
        setRoot(recursivelydelete(getRoot(), node));
    }
    private BSTNode recursivelydelete(BSTNode root, BSTNode node){
        if (root == null)
            return null;
        if (node.getData() < root.getData())
            root.setLeft(recursivelydelete(root.getLeft(), node));
        else if (node.getData() > root.getData())
            root.setRight(recursivelydelete(root.getRight(), node));
        else{
            if (root.getLeft() == null)
            return root.getRight();
            else if (root.getRight() == null)
                return root.getLeft();
            else{
                BSTNode min = findmin(root.getRight());
                root.setData(min.getData());
                root.setRight(recursivelydelete(root.getRight(), min)); 
            }
            }
        
        return root;
    }

    private BSTNode findmin(BSTNode node){
        while (node.getLeft() != null)
            node = node.getLeft();
        return node;
    }

    public int sumofleafnodes(){
        return sumofleafnodes(getRoot());
    }
    private int sumofleafnodes(BSTNode node){
        if (node == null)
            return 0;
        if (node.getLeft() == null && node.getRight() == null)
            return node.getData();
        int leftSum = sumofleafnodes(node.getLeft());
        int rightSum = sumofleafnodes(node.getRight());
        if (leftSum == 0) return rightSum;
        if (rightSum == 0) return leftSum;
        return (leftSum + rightSum);
    }
}