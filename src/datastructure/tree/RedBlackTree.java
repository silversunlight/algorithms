package datastructure.tree;

/**
 * @author Lance Sun
 * @date Created in 17:53 2018/10/26
 * @descrpition 红黑树
 */
public class RedBlackTree<T extends Comparable<? super T>> {
    private static final int RED = 0;
    private static final int BLACK = 1;

    /**
     * 头结点
     */
    private RedBlackNode<T> header;
    /**
     * 空节点
     */
    private RedBlackNode<T> nullNode;

    /**
     * 构造方法，头结点和头结点的左右节点都设置为nullNode，头结点是黑色的
     */
    public RedBlackTree() {
        nullNode = new RedBlackNode<>(null);
        nullNode.left = nullNode.right = nullNode;
        header = new RedBlackNode<>(null);
        header.left = header.right = nullNode;
    }

    /**
     * 红黑树节点
     *
     * @param <T>
     */
    private static class RedBlackNode<T> {
        T element;
        RedBlackNode<T> left;
        RedBlackNode<T> right;
        int color;

        RedBlackNode(T theElement) {
            this(theElement, null, null);
        }

        RedBlackNode(T theElement, RedBlackNode<T> lt, RedBlackNode<T> rt) {
            element = theElement;
            left = lt;
            right = rt;
            color = RedBlackTree.BLACK;
        }
    }
}
