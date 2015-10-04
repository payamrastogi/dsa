package ds;

// Node class to keep the data
class Node<T>{
	private T data;
	private Node<T> next;
	
	Node(T data, Node<T> node){
		this.data = data;
		this.next = node;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	Node(Node<T> node){
		this.next = node;
	}
	
	public Node<T> setNext(Node<T> node){
		this.next = node;
		return this.next;
	}
}

// Link of Nodes
public class LinkedList<T> {
	private Node<T> head;
	protected Node<T> curr;
	private Node<T> tail;
	private int len = 0;
	
	public LinkedList(){
		head = curr = tail = new Node<T>(null);
		len = 0;
	}
	
	// insert an item at current position in the linked list
	public void insert(T item){
		curr.setNext(new Node<T>(item, curr.getNext()));
		if (tail == curr){
			tail = curr.getNext();
		}
		len++;
	}
	
	// append an item in the linked list
	public void append(T item){
		tail = tail.setNext(new Node<T>(item, tail.getNext()));
		len++;
	}
	
	public T getItem(){
		if(curr.getNext() == null){ return null;}
		return curr.getNext().getData();
	}
	
	// return the length of the list
	public int length(){
		return len;
	}
	
	// empty the whole list
	public void clear(){
		head = curr = tail = new Node<T>(null);
		len = 0;
	}
	
	// remove and return current item from the list
	public T remove(){
		if (curr.getNext() == null){ return null;}
		T item = curr.getNext().getData();
		if(tail == curr.getNext()){tail = curr;}
		curr.setNext(curr.getNext().getNext());
		len--;
		return item;
	}
	
	// move the current to head
	public void moveToStart(){
		curr = head;
	}
	
	// move the current to end of the list
	// tail is not the end; it's next to tail
	public void moveToEnd(){
		curr = tail;
	}
	
	// move the current to pos position
	public boolean moveToPos(int pos){
		if (pos<0 || pos > len){ return false;}
		curr = head;
		for(int i=0; i<pos; i++){
			curr = curr.getNext();
		}
		return true;
	}
	
	// move the current to one step left
	// no change if at head
	public void prev(){
		if(curr == head){return;}
		Node<T> tmp = head;
		while(tmp.getNext() != curr){ tmp = tmp.getNext();}
		curr = tmp;
	}
	
	// move the current to one step right
	// no change if already at tail
	public void next(){
		if (curr == tail){return;}
		curr = curr.getNext();
	}
	
	// return the current position
	public int currPos(){
		int pos = 0;
		Node<T> tmp = head;
		while(tmp != curr){
			tmp = tmp.getNext();
			pos++;
		}
		return pos;
	}
	
	// return the string representation
	public String toString(){
		StringBuffer strList = new StringBuffer();
		strList.append("[");
		Node<T> tmp = head;
		while(tmp != tail){
			T value = tmp.getNext().getData();
			if(tmp == curr){strList.append("|");}
			strList.append(value);
			tmp = tmp.getNext();
			if(tmp != tail){strList.append(",");}
			
		}
		strList.append("]");
		return strList.toString();
	}
}
