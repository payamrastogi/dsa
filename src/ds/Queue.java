package ds;

public class Queue<T> {
	// data leaves from the head
	private Node<T> head;
	// data appends at the tail
	private Node<T> tail;
	private int len;
	
	public Queue(){
		head = tail = new Node<T>(null);
		len = 0;
	}
	
	// reinitialize the queue
	public void clear(){
		head = tail = new Node<T>(null);
		len = 0;
	}
	
	// return the length of the queue
	public int length(){
		return len;
	}
	
	// return the value at the tail
	public T peek(){
		if(len <=0){ return null;}
		return head.getNext().getData();
	}
	
	// add an item to the queue
	public void enqueue(T item){
		tail.setNext(new Node<T>(item, null));
		tail = tail.getNext();
		len++;
	}
	
	// remove and return an item from the queue
	public T dequeue(){
		if(len <=0){ return null;}
		T item = head.getNext().getData();
		head.setNext(head.getNext().getNext());
		len--;
		return item;
	}
	
	// return the string representation
	public String toString(){
		StringBuffer strQueue = new StringBuffer();
		strQueue.append("[");
		Node<T> tmp = head.getNext();
		while(tmp != null){
			strQueue.append(tmp.getData());
			tmp = tmp.getNext();
			if(tmp != null){
				strQueue.append(",");
			}
		}
		strQueue.append("]");
		return strQueue.toString();
	}
	
}
