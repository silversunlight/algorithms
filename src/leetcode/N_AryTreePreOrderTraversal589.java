package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Lance Sun
 * @date ：Created in 21:55 2018/10/10
 */
public class N_AryTreePreOrderTraversal589 {
    public static List<Integer> preorder(Node root) {
        List<Integer> rst = new ArrayList<>();
        if (root == null) {
            return rst;
        }
        preorder(root, rst);
        return rst;
    }

    private static void preorder(Node root, List<Integer> rst) {
        if (root == null) {
            return;
        }
        rst.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                preorder(node, rst);
            }
        }
    }

    public static void main(String[] args) {
        /**构建一个树，root为1，有4个子节点，依次为2，3，4，5，
         * 其中2号节点有3个子节点，分别为6，7，8
         * 3号节点有一个子节点 9
         *5号节点有2个子节点，分别为10，11
         */
        Node root = new Node();
        root.val = 1;
        List<Node> children1 = new ArrayList<>();
        for (int i = 2; i <= 5; i++) {
            Node con = new Node();
            con.val = i;
            children1.add(con);
        }
        root.children = children1;
        List<Node> children2 = new ArrayList<>();
        for (int i = 6; i <= 8; i++) {
            Node con = new Node();
            con.val = i;
            children2.add(con);
        }
        root.children.get(0).children = children2;
        List<Node> children3 = new ArrayList<>();
        for (int i = 10; i <= 11; i++) {
            Node con = new Node();
            con.val = i;
            children3.add(con);
        }
        root.children.get(3).children = children3;
        List<Node> children4 = new ArrayList<>();
        Node con = new Node();
        con.val = 9;
        children4.add(con);
        root.children.get(1).children = children4;
        List<Integer> rs = preorder(root);
        rs.stream().forEach(a -> System.out.println(a));
    }
}
