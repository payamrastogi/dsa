package ds;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ds.LinkedList;

public class TestLinkedList {

	@Test
	public void testInsert() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.insert(1);
		assertEquals(0, ll.currPos());
		ll.insert(2);
		assertEquals(0, ll.currPos());
		assertEquals("[|2,1]", ll.toString());
	}
	
	@Test
	public void testAppend() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.insert(1);
		ll.insert(2);
		ll.append(3);
		assertEquals("[|2,1,3]", ll.toString());
	}
	
	@Test
	public void testRemove() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.insert(1);
		ll.insert(2);
		int value = ll.remove();
		assertEquals(2, value);
	}
	
	@Test
	public void testClear() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.insert(1);
		assertEquals(1, ll.length());
		ll.clear();
		assertEquals(0, ll.length());
		assertEquals("[]", ll.toString());
	}
	
	@Test
	public void testCurrPos() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
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
	
	@Test
	public void testMoveToStart() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.insert(1);
		assertEquals(0, ll.currPos());
		ll.insert(2);
		ll.moveToStart();
		assertEquals(0, ll.currPos());
	}
	
	@Test
	public void testMoveToEnd() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.insert(1);
		ll.insert(2);
		assertEquals(0, ll.currPos());
		ll.moveToEnd();
		assertEquals(null, ll.getItem());
		assertEquals(2, ll.currPos());
	}
	
	@Test
	public void testPrev() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		assertEquals(0, ll.currPos());
		ll.moveToEnd();
		assertEquals(3, ll.currPos());
		ll.prev();
		assertEquals(2, ll.currPos());
		assertEquals(1, (int)ll.getItem());
	}
	
	@Test
	public void testNext() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.insert(1);
		ll.insert(2);
		assertEquals(2, (int)ll.getItem());
		ll.next();
		assertEquals(1, (int)ll.getItem());
		assertEquals(1, ll.currPos());
		ll.next();
		assertEquals(2, ll.currPos());
		assertEquals(null, ll.getItem());
		
	}
	
	@Test
	public void testMoveToPos() {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		assertEquals("[|4,3,2,1]", ll.toString());
		if (ll.moveToPos(2)){
			ll.insert(5);
		}
		assertEquals("[4,3,|5,2,1]", ll.toString());
		if (ll.moveToPos(10)){
			ll.insert(6);
		}
		assertEquals("[4,3,|5,2,1]", ll.toString());
	}

}
