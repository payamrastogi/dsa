package ds;

public class DLinkedList<T> {
	// null valued node
	private DNode<T> head;
	// node we can move to look for item
	// points to the node previous to the node
	// with the item we want to add/look
	protected DNode<T> curr;
	// null valued node next to the last node
	// with an item
	private DNode<T> tail;
	private int len = 0;

	public DNode<T> getHead() {
		return head;
	}

	public void setHead(DNode<T> head) {
		this.head = head;
	}

	public DNode<T> getCurr() {
		return curr;
	}

	public void setCurr(DNode<T> curr) {
		this.curr = curr;
	}

	public DNode<T> getTail() {
		return tail;
	}

	public void setTail(DNode<T> tail) {
		this.tail = tail;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public DLinkedList() {
		head = curr = new DNode<T>(null, null);
		tail = new DNode<T>(null, null);
		curr.setNext(tail);
		tail.setPrev(curr);
		len = 0;
	}

	// insert an item at the current position
	public void insert(T item) {
		curr.setNext(new DNode<T>(item, curr, curr.getNext()));
		curr.getNext().getNext().setPrev(curr.getNext());
		len++;
	}

	public T getItem() {
		if (curr.getNext() == null) {
			return null;
		}
		return curr.getNext().getData();
	}

	// append an item at the current position
	// can add directly before tail
	public void append(T item) {
		tail.setPrev(new DNode<T>(item, tail.getPrev(), tail));
		tail.getPrev().getPrev().setNext(tail.getPrev());
		len++;
	}

	// return and remove the item at current
	public T remove() {
		if (curr == tail.getPrev() || curr == tail) {
			return null;
		}
		T item = curr.getNext().getData();
		curr.setNext(curr.getNext().getNext());
		curr.getNext().setPrev(curr);
		len--;
		return item;
	}

	// move the current one position left
	public void prev() {
		if (curr != head) {
			curr = curr.getPrev();
		}
	}

	// move the current to one step right
	// no change if already at tail
	public void next() {
		if (curr == tail) {
			return;
		}
		curr = curr.getNext();
	}

	// return the current position
	public int currPos() {
		int pos = 0;
		DNode<T> tmp = head;
		while (tmp != curr) {
			tmp = tmp.getNext();
			pos++;
		}
		return pos;
	}

	// return the length of doubly linked list
	public int length() {
		return len;
	}

	// empty the whole list
	public void clear() {
		head = curr = new DNode<T>(null, null);
		tail = new DNode<T>(null, null);
		curr.setNext(tail);
		tail.setPrev(curr);
		len = 0;
	}

	// return the string representation
	public String toString() {
		StringBuffer strList = new StringBuffer();
		strList.append("[");
		DNode<T> tmp = head;
		while (tmp.getNext() != tail) {
			T value = tmp.getNext().getData();
			if (tmp == curr) {
				strList.append("|");
			}
			strList.append(value);
			tmp = tmp.getNext();
			if (tmp.getNext() != tail) {
				strList.append(",");
			}

		}
		strList.append("]");
		return strList.toString();
	}

	// move the current to head
	public void moveToStart() {
		curr = head;
	}

	// move the current to end of the list
	// tail is not the end; it's next to tail
	public void moveToEnd() {
		curr = tail;
	}

}
