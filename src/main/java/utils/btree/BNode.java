package utils.btree;

public class BNode {
    public int maxSize;
    public int count;
    public int[] value;
    public int[] key;
    public BNode[] child;
    public boolean leaf;
    public BNode parent;

    public BNode(int maxSize, BNode parent) {
        this.maxSize = maxSize;
        this.parent = parent;
        this.value = new int[2 * maxSize - 1];
        this.key = new int[2 * maxSize - 1];
        this.child = new BNode[2 * maxSize];
        this.leaf = true;
        this.count = 0;
    }

    public BNode getChild(int index) {
        return child[index];
    }
}