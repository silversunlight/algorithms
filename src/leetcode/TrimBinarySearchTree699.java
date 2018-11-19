package leetcode;

/**
 * @author ：Lance Sun
 * @date ：Created in 15:11 2018/10/18
 */
//todo 根本懂不了
public class TrimBinarySearchTree699 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node0 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node3.left = node0;
        node3.right = node4;
        node0.right = node2;
        node2.left = node1;
        TrimBinarySearchTree699 a = new TrimBinarySearchTree699();
        a.trimBST(node3, 1, 3);
    }
}
