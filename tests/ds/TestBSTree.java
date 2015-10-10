package ds;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBSTree {

	@Test
	public void testInsert() {
		BSTree<Integer> bst = new BSTree<Integer>();
		bst.insert(5);
		assertEquals(1, bst.getNodeCount());
		bst.insert(2);
		bst.insert(8);
		assertEquals(3, bst.getNodeCount());
		assertEquals(true, bst.checkBST(bst.getRoot(), (Integer)2, (Integer)8));
	}
	
	@Test
	public void testRemove() {
		BSTree<Integer> bst = new BSTree<Integer>();
		bst.insert(5);
		bst.insert(2);
		bst.insert(6);
		bst.insert(8);
		bst.insert(7);
		bst.remove(5);
		assertEquals(4, bst.getNodeCount());
		assertEquals(true, bst.checkBST(bst.getRoot(), (Integer)2, (Integer)8));
	}
	
	@Test
	public void testInorder(){
		BSTree<Integer> bst = new BSTree<Integer>();
		bst.insert(5);
		bst.insert(2);
		bst.insert(8);
		assertEquals("[2, 5, 8]", bst.inorder().toString());
	}
	
	@Test
	public void testPreorder(){
		BSTree<Integer> bst = new BSTree<Integer>();
		bst.insert(5);
		bst.insert(2);
		bst.insert(8);
		assertEquals("[5, 2, 8]", bst.preorder().toString());
	}
	
	@Test
	public void testPostorder(){
		BSTree<Integer> bst = new BSTree<Integer>();
		bst.insert(5);
		bst.insert(2);
		bst.insert(8);
		assertEquals("[2, 8, 5]", bst.postorder().toString());
	}

}
