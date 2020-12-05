package test;

import org.junit.Test;
import utils.btree.BNode;
import utils.btree.BTree;
import static org.junit.Assert.*;

public class BTreeTest {

    @Test
    public void createBNode() {
        BNode bNode = new BNode(3, null);
        assertEquals(bNode.maxSize, 3);
        assertNull(bNode.parent);
        assertNotNull(bNode.value);
        assertNotNull(bNode.key);
        assertNotNull(bNode.child);
        assertTrue(bNode.leaf);
        assertEquals(bNode.count, 0);
    }

    @Test
    public void createBTree() {
        BTree bTree = new BTree(4);
        assertEquals(bTree.order, 4);
        assertNotNull(bTree.root);
    }

    @Test
    public void testingFirstElementInsert() {
        BTree bTree = new BTree(4);
        bTree.insert(2, 2000);
        assertEquals(bTree.root.key[0], 2);
        assertEquals(bTree.root.value[0], 2000);
    }

    @Test
    public void testingTwoElementsInsert() {
        BTree bTree = new BTree(4);
        bTree.insert(6, 3000);
        bTree.insert(2, 2000);
        assertEquals(bTree.root.key[0], 2);
        assertEquals(bTree.root.value[0], 2000);
        assertEquals(bTree.root.key[1], 6);
        assertEquals(bTree.root.value[1], 3000);
    }
}
