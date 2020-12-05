package utils.btree;

public class BTree {
    public int order;
    public BNode root;

    public BTree(int order) {
        this.order = order;
        root = new BNode(order, null);
    }
}
