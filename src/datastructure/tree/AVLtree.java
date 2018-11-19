package datastructure.tree;

/**
 * @author ：Lance Sun
 * @date ：Created in 16:54 2018/10/22
 */
public class AVLtree<T extends Comparable<? super T>> {
    private AvlNode<T> root;
    private static final int AllOWED_IMBALANCE = 1;

    public AVLtree() {
        root = null;
    }


    private int height(AvlNode<T> t) {
        return t == null ? -1 : t.height;
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public AvlNode<T> remove(T x) {
        return remove(x, root);
    }

    /**
     * 删除
     *
     * @param x
     * @param t
     * @return
     */
    private AvlNode<T> remove(T x, AvlNode<T> t) {
        if (t == null) {
            return t;
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = remove(x, t.left);
        } else if (compareResult > 0) {
            t.right = remove(x, t.right);
        } else if (t.left != null && t.right != null) {
            //todo 嘛意思弟弟
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else {
            t = (t.left != null) ? t.left : t.right;
        }
        return balance(t);
    }

    public AvlNode<T> findMin() {
        return findMin(root);
    }

    private AvlNode<T> findMin(AvlNode t) {
        if (t == null) {
            return t;
        }
        while (t.left != null) {
            t = t.left;
        }
        return t;
    }

    /**
     * 插入
     *
     * @param x
     * @param t
     * @return
     */
    private AvlNode<T> insert(T x, AvlNode<T> t) {
        if (t == null) {
            return new AvlNode<>(x, null, null);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) {
            t.left = insert(x, t.left);
        } else if (compareResult > 0) {
            t.right = insert(x, t.right);
        } else {

        }
        return balance(t);
    }

    private AvlNode<T> balance(AvlNode<T> t) {
        if (t == null) {
            return t;
        }
        //null的情况下，height() 方法返回-1
        if (height(t.left) - height(t.right) > AllOWED_IMBALANCE) {
            if (height(t.left.left) >= height(t.left.right)) {
                t = rotateWithLeftChild(t);
            } else {
                t = doubleWithLeftChild(t);
            }
        } else if (height(t.right) - height(t.left) > AllOWED_IMBALANCE) {
            if (height(t.right.right) >= height(t.right.left)) {
                t = rotateWithRightChild(t);
            } else {
                t = doubleWithRightChild(t);
            }
        }
        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    /**
     * LL旋转
     *
     * @param k2
     * @return
     */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k2.right)) + 1;
        return k1;
    }

    /**
     * RR旋转
     *
     * @param k2
     * @return
     */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        return k1;
    }

    /**
     * LR一转
     *
     * @param k3
     * @return
     */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * RL一转
     *
     * @param k3
     * @return
     */
    private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    private static class AvlNode<T> {
        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;

        AvlNode(T theElement) {
            this(theElement, null, null);
        }

        AvlNode(T theElement, AvlNode<T> lt, AvlNode<T> rt) {
            element = theElement;
            left = lt;
            right = rt;
            height = 0;
        }
    }

    public static void main(String[] args) {
        AVLtree<Integer> avLtree = new AVLtree<>();
        avLtree.insert(10);
        avLtree.insert(7);
        avLtree.insert(6);
        avLtree.insert(3);
        avLtree.insert(5);
    }
}
