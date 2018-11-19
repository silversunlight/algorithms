package datastructure.tree;

/**
 * @author ：Lance Sun
 * @date ：Created in 14:37 2018/10/22
 */
public class BSTtree<T extends Comparable<? super T>> {
    private BinaryNode<T> root;

    /**
     * 构造一个空树
     */
    public BSTtree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMin() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return findMax(root).element;
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    private BinaryNode<T> remove(T x, BinaryNode<T> root) {
        if (root == null) {
            return root;
        }
        int compareResult = x.compareTo(root.element);
        if (compareResult < 0) {
            root.left = remove(x, root.left);
        } else if (compareResult > 0) {
            root.right = remove(x, root.right);
        } else if (root.left != null && root.right != null) {
            root.element = findMin(root.right).element;
            root.right = remove(root.element, root.right);
        } else {
            root = root.left != null ? root.left : root.right;
        }
        return root;
    }

    private BinaryNode<T> insert(T x, BinaryNode<T> root) {
        if (root == null) {
            return new BinaryNode<>(x, null, null);
        }
        int compareResult = x.compareTo(root.element);
        if (compareResult < 0) {
            root.left = insert(x, root.left);
        } else if (compareResult > 0) {
            root.right = insert(x, root.right);
        } else {
            //do nothing
        }
        return root;
    }

    private BinaryNode<T> findMax(BinaryNode<T> root) {
        if (root.right == null) {
            return root;
        }
        return findMax(root.right);
    }

    private BinaryNode<T> findMin(BinaryNode<T> root) {
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    private boolean contains(T x, BinaryNode<T> root) {
        if (x == null) {
            return false;
        }
        int compareResult = x.compareTo(root.element);
        if (compareResult < 0) {
            return contains(x, root.left);
        } else if (compareResult > 0) {
            return contains(x, root.right);
        } else {
            return true;
        }
    }


    /**
     * 内部类：节点
     *
     * @param <T>
     */
    private static class BinaryNode<T> {
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;

        BinaryNode(T theElement) {
            this(theElement, null, null);
        }

        BinaryNode(T theElement, BinaryNode<T> lt, BinaryNode<T> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
    }

    public static void main(String[] args) {
        BSTtree bt = new BSTtree();
        bt.insert(10);
        bt.insert(6);
        bt.insert(19);
        bt.insert(7);
        bt.insert(11);
        bt.insert(5);
        bt.remove(19);
        bt.remove(6);
    }
}
