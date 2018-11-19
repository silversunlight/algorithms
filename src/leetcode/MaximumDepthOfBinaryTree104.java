package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ：Lance Sun
 * @date ：Created in 18:30 2018/10/20
 */
public class MaximumDepthOfBinaryTree104 {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //DFS
    public int DFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if (node.left != null) {
                stack.push(node.left);
                value.push(temp + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                value.push(temp + 1);
            }
        }
        return max;
    }

    //BFS
    public int BFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
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
        TreeNode node10 = new TreeNode(10);
        nodes[7].left = node10;
        TreeNode node = nodes[5];
        MaximumDepthOfBinaryTree104 a = new MaximumDepthOfBinaryTree104();
        System.out.println(a.maxDepth(node));
    }
}
