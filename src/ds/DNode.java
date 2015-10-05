package ds;

public class DNode<T> {
	private T data;
	private DNode<T> next;
	private DNode<T> prev;
	
	public DNode(T data, DNode<T> prev, DNode<T> next){
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
	
	public DNode(DNode<T> prev, DNode<T> next){
		this.prev = prev;
		this.next = next;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public DNode<T> getNext() {
		return next;
	}
	public void setNext(DNode<T> next) {
		this.next = next;
	}
	public DNode<T> getPrev() {
		return prev;
	}
	public void setPrev(DNode<T> prev) {
		this.prev = prev;
	}
}
