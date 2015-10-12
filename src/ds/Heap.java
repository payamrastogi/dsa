package ds;

// using array so that client can straight away pass an array and construct a heap
// item at pos 'n' stored it left child at '2n+1' and right child at '2n+2'
public abstract class Heap<T> {
	protected int size;
	
	// return the size of the heap
	public int getSize(){
		return size;
	}
	
	// check if pos location is a leaf 
	public boolean isLeaf(int pos){
		return (pos>=size/2 && pos<size);
	}
	
	//return the left child of pos
	public int leftChild(int pos) throws Exception{
		if(pos >= size/2){
			// no left child
			throw new Exception("no left child");
		}
		return 2*pos+1;
	}
	
	// return the right child of pos
	public int rightChild(int pos) throws Exception{
		if(pos > (size-1)/2 - 1){
			// no right child
			throw new Exception("no right child");
		}
		return 2*pos+2;
	}
	
	// return parent
	public int parent(int pos){
		if(pos <= 0){
			// no parent
			return -1;
		}
		return (pos-1)/2;
	}
	
	// insert an item
	abstract void insert(T item) throws Exception;
	
	// heapify the contents
	abstract void buildHeap() throws Exception;
	
	// remove and return the root
	abstract T removeRoot() throws Exception;
	
	// remove and return the item at pos
	abstract T remove(int pos) throws Exception;
	
	// swap two positions in an array
	public void swap(T[] arr, int i, int j){
		if(i<0||j<0||i>arr.length||j>arr.length){
			return;
		}
		T tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
}
