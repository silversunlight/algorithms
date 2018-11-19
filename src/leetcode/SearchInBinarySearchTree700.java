package leetcode;

/**
 * @Author ：Lance Sun
 * @Date ：Created in 20:24 2018/9/22
 * @Description：
 * @ModifiedBy：
 * @Version: 1.0.0
 */
public class SearchInBinarySearchTree700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        if (root.val == val) {
            return root;
        } else {
            return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
        }
    }
}
