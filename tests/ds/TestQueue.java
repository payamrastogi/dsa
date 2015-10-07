package ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQueue {

	@Test
	public void testEnqueue() {
		Queue<Integer> q = new Queue<Integer>();
		assertEquals(0, q.length());
		q.enqueue(1);
		q.enqueue(2);
		assertEquals("[1,2]", q.toString());
	}
	
	@Test
	public void testDequeue() {
		Queue<Integer> q = new Queue<Integer>();
		assertEquals(0, q.length());
		q.enqueue(1);
		q.enqueue(2);
		int item = q.dequeue();
		assertEquals(1, item);
		assertEquals("[2]", q.toString());
	}
	
	@Test
	public void testPeek() {
		Queue<Integer> q = new Queue<Integer>();
		assertEquals(0, q.length());
		q.enqueue(1);
		q.enqueue(2);
		int item = q.peek();
		assertEquals(1, item);
		assertEquals("[1,2]", q.toString());
	}
	
	@Test
	public void testClear() {
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(1);
		q.enqueue(2);
		assertEquals(2, q.length());
		q.clear();
		assertEquals(0, q.length());
		assertEquals("[]", q.toString());
	}

}
