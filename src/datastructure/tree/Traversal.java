package datastructure.tree;

import leetcode.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：Lance Sun
 * @date ：Created in 20:19 2018/10/2
 */
public class Traversal {
    //先序遍历不带层数
    public static void pre(Node root) {
        System.out.print(root.val + " ");
        if (root.children != null) {
            for (Node node : root.children) {
                pre(node);
            }
        } else {
            return;
        }

    }

    //后续遍历
    public static void post(Node root) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node node : root.children) {
                post(node);
            }
        }
        System.out.println(root.val + " ");
    }

    public static void post(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node node : root.children) {
                post(node, list);
            }
        }
        list.add(root.val);
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
        post(root);
    }
}
