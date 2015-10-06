package ds;

public class Stack<T> {
	private Node<T> top;
	private int len;
	
	public Stack(){
		top = null;
		len = 0;
	}
	
	// reinitialize the stack
	public void clear(){
		top = null;
		len = 0;
	}
	
	// add an item to the top of stack
	public void push(T item){
		// add the new node to the topo of the list
		// and reset top
		top = new Node<T>(item, top);
		len++;
	}
	
	// return and remove top item from the stack
	public T pop(){
		if(top == null){return null;}
		T item = top.getData();
		top = top.getNext();
		len--;
		return item;
	}
	
	// return the top item
	public T peek(){
		if(top == null){return null;}
		return top.getData();
	}
	
	// return the length of the stack
	public int length(){
		return len;
	}
	
	// return the string representation of stack
	public String toString(){
		StringBuffer strStack = new StringBuffer();
		strStack.append("[");
		Node<T> tmp = top;
		while(tmp != null){
			strStack.append(tmp.getData());
			tmp = tmp.getNext();
			if(tmp != null){
				strStack.append(",");
			}
		}
		strStack.append("]");
		return strStack.toString();
	}

}
