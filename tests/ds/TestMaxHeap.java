package ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMaxHeap {

	@Test
	public void testMaxHeap() {
		Integer[] h = {3,2,4,1,5,0,0,0};
		MaxHeap<Integer> mh = null;
		try {
			 mh = new MaxHeap<Integer>(h, 5, h.length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(5, mh.getSize());
	}
	
	@Test
	public void testInsert() throws Exception {
		Integer[] h = {3,2,4,1,5,0,0,0};
		MaxHeap<Integer> mh = null;
		mh = new MaxHeap<Integer>(h, 5, h.length);
		mh.insert(8);
		assertEquals(6, mh.getSize());
	}
	
	@Test
	public void testRemoveRoot() throws Exception {
		Integer[] h = {3,2,4,1,5,0,0,0};
		MaxHeap<Integer> mh = null;
		mh = new MaxHeap<Integer>(h, 5, h.length);
		assertEquals(5, (int)mh.removeRoot());
	}
	
	@Test
	public void testRemove() throws Exception {
		Integer[] h = {3,2,4,1,5,8,0,0};
		MaxHeap<Integer> mh = null;
		mh = new MaxHeap<Integer>(h, 6, h.length);
		// heap is: [8, 5, 4, 1, 2, 3, 0, 0]
		assertEquals(3, (int)mh.remove(5));
		assertEquals(5, (int)mh.getSize());
	}

}
