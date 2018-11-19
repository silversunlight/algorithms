package leetcode;

/**
 * @author ：Lance Sun
 * @date ：Created in 10:20 2018/10/20
 */
//todo 貌似这道题leetcode的判定机制有问题
public class IncreasingOrderSearchTree897 {
    private TreeNode result;
    private TreeNode pre;

    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return result;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (result == null) {
            result = root;
        } else {
            pre.right = root;
        }
        pre = root;
        root.left = null;
        inorder(root.right);
    }

    public void printTree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        printTree(node.left);
        printTree(node.right);
    }

    public static void main(String[] args) {
        TreeNode[] nodes = new TreeNode[10];
        for (int i = 1; i <= 9; i++) {
            nodes[i] = new TreeNode(i);
        }
        nodes[5].left = nodes[3];
        nodes[5].right = nodes[6];
        nodes[3].left = nodes[2];
        nodes[3].right = nodes[4];
        nodes[2].left = nodes[1];
        nodes[6].right = nodes[8];
        nodes[8].left = nodes[7];
        nodes[8].right = nodes[9];
        IncreasingOrderSearchTree897 a = new IncreasingOrderSearchTree897();
        TreeNode root = nodes[5];
        TreeNode node = a.increasingBST(root);
        a.printTree(node);
    }
}
