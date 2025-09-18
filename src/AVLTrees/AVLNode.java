package AVLTrees;

public class AVLNode<E extends Comparable<E>> {
    private E data;
    private AVLNode<E> left;
    private AVLNode<E> right;

    public AVLNode(E data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public AVLNode<E> getLeft() {
        return left;
    }

    public void setLeft(AVLNode<E> left) {
        this.left = left;
    }

    public AVLNode<E> getRight() {
        return right;
    }

    public void setRight(AVLNode<E> right) {
        this.right = right;
    }
    
    @Override
    public String toString(){
        return getData().toString();
    }
}
