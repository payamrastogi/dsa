package ds;

public class BSTNode<T>{
	private T item;  
	private BSTNode<T> right;
	private BSTNode<T> left;
	
	public BSTNode(){
		left = right = null;
	}
	
	public BSTNode(T value){
		left = right = null;
		item = value;
	}
	
	public BSTNode(T value, BSTNode<T> l, BSTNode<T> r){
		left = l;
		right = r;
		item = value;
	}
	
	public boolean isLeaf(){
		if(left == null && right == null){
			return true;
		}
		return false;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public BSTNode<T> getRight() {
		return right;
	}

	public void setRight(BSTNode<T> right) {
		this.right = right;
	}

	public BSTNode<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<T> left) {
		this.left = left;
	}
	
}
