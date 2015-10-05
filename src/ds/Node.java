package ds;

//Node class to keep the data
public class Node<T>{
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