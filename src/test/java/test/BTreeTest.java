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
}
