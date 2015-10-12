package ds;

public class MinHeap <T extends Comparable<T>> extends Heap<T> {

	private T[] heap;
	private int maxSize;

	MinHeap(T[] minH, int sz, int maxSz) throws Exception {
		heap = minH;
		size = sz;
		maxSize = maxSz;
		buildHeap();
	}

	// insert an item
	public void insert(T item) throws Exception {
		if (size >= maxSize) {
			throw new Exception("No more space in the heap");
		}
		// put the new element at the end
		int curr = size++;
		heap[curr] = item;
		// rearrange until curr's parent < curr
		while ((curr != 0) && (heap[curr].compareTo(heap[parent(curr)]) < 0)) {
			swap(heap, curr, parent(curr));
			// move up to the parent to repeat if required
			curr = parent(curr);
		}
	}

	// heapify the heap
	public void buildHeap() throws Exception {
		// for every item with children
		for (int i = size/2 -1; i >= 0; i--) {
			minHeapify(i);
		}
	}

	// put items in correct position by pushing down small items
	public void minHeapify(int pos) throws Exception {
		if (pos < 0 || pos > size-1) {
			throw new Exception("Invalid pos value");
		}
		while (!isLeaf(pos)) {
			// find the smaller one among the two children of heap[pos] and
			// their parent heap[pos]
			int j = leftChild(pos);
			if ((j < size - 1) && (heap[j].compareTo(heap[j + 1]) > 0)) {
				j++;
			}
			if (heap[pos].compareTo(heap[j]) < 0) {
				return;
			}
			// make smallest the parent
			swap(heap, pos, j);
			// move down to the initially smaller children to repeat the process
			pos = j;
		}
	}

	// return and remove the top item
	public T removeRoot() throws Exception {
		if (size < 1) {
			throw new Exception("heap is empty");
		}
		// swap the smallest (root) item with the last item in the heap
		// and reset the size to make that item unavailable
		swap(heap, 0, --size);
		// if the top item was not the last item
		// then rearrange
		if (size != 0) {
			minHeapify(0);
		}
		return heap[size];
	}

	// return and remove the item as pos
	public T remove(int pos) throws Exception {
		if(pos<0 || pos>size-1){
			throw new Exception("invalid pos value");
		}
		// if it is the last item
		if(pos == size-1){size--;}
		else{
			// swap with the last item and make that item unavailable 
			swap(heap, pos, --size);
			// if swapped with a small value then push it up
			while((pos>0) && (heap[pos].compareTo(heap[parent(pos)]) < 0)){
				swap(heap, pos, parent(pos));
				pos = parent(pos);
			}
			// if swapped with a larger value then push it down
			if(size != 0){minHeapify(pos);}
		}
		return heap[size];
	}
}
