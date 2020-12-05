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
        bTree.insert(bTree, 2, 2000);
        assertEquals(bTree.root.key[0], 2);
        assertEquals(bTree.root.value[0], 2000);
    }

    @Test
    public void testingTwoElementsInsert() {
        BTree bTree = new BTree(4);
        bTree.insert(bTree, 6, 3000);
        bTree.insert(bTree, 2, 2000);
        assertEquals(bTree.root.key[0], 2);
        assertEquals(bTree.root.value[0], 2000);
        assertEquals(bTree.root.key[1], 6);
        assertEquals(bTree.root.value[1], 3000);
    }

    @Test
    public void testingFourElementsInsert() {
        BTree bTree = new BTree(2);
        bTree.insert(bTree, 6, 3000);
        bTree.insert(bTree, 2, 2000);
        bTree.insert(bTree, 1, 7000);
        bTree.insert(bTree, 14, 6000);
        assertEquals(bTree.root.key[0], 2);
        assertEquals(bTree.root.value[0], 2000);
        assertEquals(bTree.root.child[0].key[0], 1);
        assertEquals(bTree.root.child[0].value[0], 7000);
        assertEquals(bTree.root.child[1].key[0], 6);
        assertEquals(bTree.root.child[1].value[0], 3000);
        assertEquals(bTree.root.child[1].key[1], 14);
        assertEquals(bTree.root.child[1].value[1], 6000);
    }

    @Test
    public void testingSearch() {
        BTree bTree = new BTree(2);
        bTree.insert(bTree, 6, 3000);
        bTree.insert(bTree, 2, 2000);
        bTree.insert(bTree, 1, 7000);
        bTree.insert(bTree, 14, 6000);
        bTree.insert(bTree, 3, 8000);
        BNode node = bTree.search(bTree.root, 14);
        assertEquals(node.value[2], 6000);
        node = bTree.search(bTree.root, 3);
        assertEquals(node.value[0], 8000);
    }

    @Test
    public void testingDeletion() {
        BTree bTree = new BTree(2);
        bTree.insert(bTree, 6, 3000);
        bTree.insert(bTree, 2, 2000);
        bTree.insert(bTree, 1, 7000);
        bTree.insert(bTree, 14, 6000);
        bTree.insert(bTree, 3, 8000);
        assertEquals(bTree.root.child[1].key[2], 14);
        assertEquals(bTree.root.child[1].value[2], 6000);
        bTree.delete(bTree, 14);
        assertEquals(bTree.root.child[1].key[2], 0);
        assertEquals(bTree.root.child[1].value[2], 0);
    }
}
