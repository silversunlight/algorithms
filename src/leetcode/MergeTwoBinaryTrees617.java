package leetcode;

/**
 * @Author ：Lance Sun
 * @Date ：Created in 10:32 2018/9/22
 * @Description：把两棵树对应位置加起来
 * @ModifiedBy：
 * @Version: 1.0.0
 */
public class MergeTwoBinaryTrees617 {
    //不好用
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
        TreeNode newNode = new TreeNode(val);

        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t2.right, t2 == null ? null : t2.right);

        return newNode;
    }

    public TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            TreeNode merge = new TreeNode(t1.val + t2.val);
            merge.left = mergeTrees1(t1.left, t2.left);
            merge.right = mergeTrees1(t1.right, t2.right);
            return merge;
        }
    }

}
