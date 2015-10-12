package ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMinHeap {

	@Test
	public void testMinHeap() throws Exception {
		Integer[] h = {3,2,4,1,5,0,0,0};
		MinHeap<Integer> mh = new MinHeap<Integer>(h, 5, h.length);
		assertEquals(5, mh.getSize());
	}
	
	@Test
	public void testInsert() throws Exception {
		Integer[] h = {3,2,4,1,5,0,0,0};
		MinHeap<Integer> mh = new MinHeap<Integer>(h, 5, h.length);
		mh.insert(8);
		assertEquals(6, mh.getSize());
	}
	
	@Test
	public void testRemoveRoot() throws Exception {
		Integer[] h = {3,2,4,1,5,0,0,0};
		MinHeap<Integer> mh = new MinHeap<Integer>(h, 5, h.length);
		assertEquals(1, (int)mh.removeRoot());
	}
	
	@Test
	public void testRemove() throws Exception {
		Integer[] h = {3,2,4,1,5,8,0,0};
		MinHeap<Integer> mh = new MinHeap<Integer>(h, 6, h.length);
		// heap is: [1, 2, 4, 3, 5, 8, 0, 0]
		assertEquals(8, (int)mh.remove(5));
		assertEquals(5, (int)mh.getSize());
	}

}
