package datastructure.tree;

/**
 * @author Lance Sun
 * @date Created in 17:11 2018/10/26
 */
public class SplayTree<T extends Comparable<? super T>> {

    /**
     * 内部类：节点
     *
     * @param <T>
     */
    private static class BinaryNode<T> {
        T element;
        SplayTree.BinaryNode<T> left;
        SplayTree.BinaryNode<T> right;

        BinaryNode(T theElement) {
            this(theElement, null, null);
        }

        BinaryNode(T theElement, SplayTree.BinaryNode<T> lt, SplayTree.BinaryNode<T> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
    }
}
