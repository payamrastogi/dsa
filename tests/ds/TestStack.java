package ds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStack {

	@Test
	public void testPush() {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		assertEquals("[2,1]", s.toString());
	}
	
	@Test
	public void testPeek() {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		assertEquals(2, (int)s.peek());
		assertEquals(2, (int)s.length());
	}
	
	@Test
	public void testPop() {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		assertEquals(2, (int)s.pop());
		assertEquals(1, (int)s.length());
	}
	
	@Test
	public void testClear() {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.clear();
		assertEquals("[]", s.toString());
		assertEquals(0, (int)s.length());
	}

}
