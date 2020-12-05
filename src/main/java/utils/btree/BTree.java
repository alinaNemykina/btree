package utils.btree;

public class BTree {
    public int order;
    public BNode root;

    public BTree(int order) {
        this.order = order;
        root = new BNode(order, null);
    }

    public void split(BNode n1, int i, BNode n2) {
        BNode n3 = new BNode(order, null);

        n3.leaf = n2.leaf;
        n3.count = order - 1;

        for (int j = 0; j < order - 1; j++) {
            n3.key[j] = n2.key[j + order];
            n3.value[j] = n2.value[j + order];
        }
        if (!n2.leaf) {
            if (order >= 0) System.arraycopy(n2.child, order, n3.child, 0, order);
        }

        n2.count = order - 1;

        if (n1.count - i >= 0) System.arraycopy(n1.child, i + 1, n1.child, i + 1 + 1, n1.count - i);
        n1.child[i + 1] = n3;

        for (int j = n1.count; j > i; j--) {
            n1.key[j + 1] = n1.key[j];
            n1.value[j + 1] = n1.value[j];
        }
        n1.key[i] = n2.key[order - 1];
        n1.value[i] = n2.value[order - 1];

        n2.key[order - 1] = 0;
        n2.value[order - 1] = 0;

        for (int j = 0; j < order - 1; j++) {
            n2.key[j + order] = 0;
            n2.value[j + order] = 0;
        }
        n1.count++;
    }

    public void nonfullInsert(BNode n, int key, int value) {
        int i = n.count;

        if (n.leaf) {
            while (i >= 1 && key < n.key[i - 1]) {
                n.key[i] = n.key[i - 1];
                n.value[i] = n.value[i - 1];
                i--;
            }

            n.key[i] = key;
            n.value[i] = value;
            n.count++;
        } else {
            int j = 0;

            while (j < n.count && key > n.key[j]) {
                j++;
            }

            if (n.child[j].count == order * 2 - 1) {
                split(n, j, n.child[j]);

                if (key > n.key[j]) {
                    j++;
                }
            }
            nonfullInsert(n.child[j], key, value);
        }
    }

    public void insert(BTree t, int key, int value) {
        BNode r = t.root;

        if (r.count == 2 * order - 1) {
            BNode s = new BNode(order, null);
            t.root = s;
            s.leaf = false;
            s.count = 0;
            s.child[0] = r;
            split(s, 0, r);
            nonfullInsert(s, key, value);
        } else {
            nonfullInsert(r, key, value);
        }
    }

    public BNode search(BNode node, int key) {
        int i = 0;

        while (i < node.count && key > node.key[i]) {
            i++;
        }

        if (i <= node.count && key == node.key[i]) {
            return node;
        }

        if (node.leaf) {
            return null;
        } else {
            return search(node.getChild(i), key);
        }
    }
}
