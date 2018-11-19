package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Lance Sun
 * @date ：Created in 14:44 2018/10/17
 */
public class LeafSimilarTrees872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList();
        List<Integer> list2 = new ArrayList();
        traversal(root1, list1);
        traversal(root2, list2);
        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public void traversal(TreeNode root, List list) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        traversal(root.left, list);
        traversal(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        root1.left = node2;
        root1.right = node3;
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left = node4;
        node2.right = node5;
        TreeNode root2 = new TreeNode(6);
        root2.left = node2;
        root2.right = node3;
        LeafSimilarTrees872 a = new LeafSimilarTrees872();
        a.leafSimilar(root1, root2);
    }
}
