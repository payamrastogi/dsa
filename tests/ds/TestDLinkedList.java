package ds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestDLinkedList {

	@Test
	public void testInsert() {
		DLinkedList<Integer> ll = new DLinkedList<Integer>();
		ll.insert(1);
		ll.insert(2);
		assertEquals("[|2,1]", ll.toString());
	}
	
	@Test
	public void testAppend() {
		DLinkedList<Integer> ll = new DLinkedList<Integer>();
		ll.insert(1);
		ll.insert(2);
		ll.append(3);
		assertEquals("[|2,1,3]", ll.toString());
	}
	
	@Test
	public void testRemove() {
		DLinkedList<Integer> ll = new DLinkedList<Integer>();
		ll.insert(1);
		ll.insert(2);
		int value = ll.remove();
		assertEquals(2, value);
	}
	
	@Test
	public void testClear() {
		DLinkedList<Integer> ll = new DLinkedList<Integer>();
		ll.insert(1);
		assertEquals(1, ll.length());
		ll.clear();
		assertEquals(0, ll.length());
		assertEquals("[]", ll.toString());
	}
	
	@Test
	public void testPrev() {
		DLinkedList<Integer> ll = new DLinkedList<Integer>();
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.moveToEnd();
		assertEquals(4, ll.currPos());
		ll.prev();
		ll.prev();
		assertEquals(2, ll.currPos());
		assertEquals(1, (int)ll.getItem());
	}
	
	@Test
	public void testCurrPos() {
		DLinkedList<Integer> ll = new DLinkedList<Integer>();
		ll.insert(1);
		assertEquals(0, ll.currPos());
		assertEquals("[|1]", ll.toString());
		ll.insert(2);
		assertEquals(0, ll.currPos());
		assertEquals("[|2,1]", ll.toString());
		ll.next();
		assertEquals(1, ll.currPos());
		assertEquals("[2,|1]", ll.toString());
		
	}

}
