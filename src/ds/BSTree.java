package ds;

import java.util.ArrayList;

public class BSTree<T extends Comparable<T>>{
	private BSTNode<T> root;
	private int nodeCount;
	
	public BSTree(){
		root = null;
		nodeCount = 0;
	}
	
	// reinitialize the tree
	public void clear(){
		root = null;
		nodeCount = 0;
	}
	
	public BSTNode<T> getRoot() {
		return root;
	}

	public void setRoot(BSTNode<T> root) {
		this.root = root;
	}

	// return number of nodes
	public int getNodeCount() {
		return nodeCount;
	}

	// insert an item into BST
	public void insert(T item){
		root = insertHelp(root, item);
		nodeCount++;
	}
	private BSTNode<T> insertHelp(BSTNode<T> r, T item){
		if(r == null){ return new BSTNode<T>(item);}
		// if item is smaller
		if(r.getItem().compareTo(item) > 0){
			r.setLeft(insertHelp(r.getLeft(), item));
		}
		// if item is larger or equal
		else{
			r.setRight(insertHelp(r.getRight(), item));
		}
		return r;
	}
	
	// remove an item from BST
	public void remove(T item){
		removeHelp(root, item);
		nodeCount--;
	}
	private BSTNode<T> removeHelp(BSTNode<T> r, T item){
		if(r == null){return null;}
		// if item is smaller
		if(r.getItem().compareTo(item) > 0){
			r.setLeft(removeHelp(r.getLeft(), item));
		}
		// if item is greater
		else if(r.getItem().compareTo(item) < 0){
			r.setRight(removeHelp(r.getRight(), item));
		}
		//if the item is equal
		else{
			if(r.getLeft() == null){return r.getRight();}
			if(r.getRight() == null){return r.getLeft();}
			// if have both child nodes
			BSTNode<T> tmp = getMin(r.getRight());
			// replace value with min
			r.setItem(tmp.getItem());
			// delete the min node
			r.setRight(deleteMin(r.getRight()));
			
		}
		return r;
	}
	
	// delete the min node
	private BSTNode<T> deleteMin(BSTNode<T> r){
		if(r == null){return null;}
		if(r.getLeft() == null){return r.getRight();}
		else{
			r.setLeft(deleteMin(r.getLeft()));
		}
		return r;
	}
	
	// get the min node 
	private BSTNode<T> getMin(BSTNode<T> r){
		// if left tree is null then root is itself minimum
		if(r == null){return null;}
		if(r.getLeft() == null){return r;}
		else{
			return getMin(r.getRight());
		}
	}
	
	// pre-order traverse
	public ArrayList<T> preorder(){
		ArrayList<T> nodeItems = new ArrayList<T>();
		preorderHelp(nodeItems, root);
		return nodeItems;
	}
	private void preorderHelp(ArrayList<T> nodeItems, BSTNode<T> r){
		if(r == null){return;}
		nodeItems.add(r.getItem());
		preorderHelp(nodeItems, r.getLeft());
		preorderHelp(nodeItems, r.getRight());
	}
	
	// post-order traverse
	public ArrayList<T> postorder(){
		ArrayList<T> nodeItems = new ArrayList<T>();
		postorderHelp(nodeItems, root);
		return nodeItems;
	}
	private void postorderHelp(ArrayList<T> nodeItems, BSTNode<T> r){
		if(r == null){return;}
		postorderHelp(nodeItems, r.getLeft());
		postorderHelp(nodeItems, r.getRight());
		nodeItems.add(r.getItem());
	}
	
	// in-order traverse
	public ArrayList<T> inorder(){
		ArrayList<T> nodeItems = new ArrayList<T>();
		inorderHelp(nodeItems, root);
		return nodeItems;
	}
	private void inorderHelp(ArrayList<T> nodeItems, BSTNode<T> r){
		if(r == null){return;}
		inorderHelp(nodeItems, r.getLeft());
		nodeItems.add(r.getItem());
		inorderHelp(nodeItems, r.getRight());
	}
	
	// check if the Tree is BST
	public boolean checkBST(BSTNode<T> r, T low, T high){
		if(r == null){return true;}
		T nodeItem = r.getItem();
		if(nodeItem.compareTo(low) < 0 || nodeItem.compareTo(high) > 0){ return false;}
		return (checkBST(r.getLeft(), low, nodeItem) && checkBST(r.getRight(), nodeItem, high));
	}
	
}
