package utils.btree;

public class BTree {
    public int order;
    public BNode root;

    public BTree(int order) {
        this.order = order;
        root = new BNode(order, null);
    }

    public void insert(int key, int value) {
        int i = root.count;

        while (i >= 1 && key < root.key[i - 1]) {
            root.key[i] = root.key[i - 1];
            root.value[i] = root.value[i - 1];
            i--;
        }

        root.key[i] = key;
        root.value[i] = value;
        root.count++;
    }
}
