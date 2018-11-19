package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.IntConsumer;

/**
 * @Author ：Lance Sun
 * @Date ：Created in 22:13 2018/9/23
 * @Description：
 * @ModifiedBy：
 * @Version: 1.0.0
 */
public class N_AryTreePostOrderTraversal590 {
    public static List<Integer> postorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root != null) {
            traverse(root, list);
        }
        return list;
    }

    private static void traverse(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.children != null) {
            for (Node child : node.children) {
                traverse(child, list);
            }
        }
        list.add(node.val);
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
        List<Integer> rs = postorder(root);
        rs.stream().forEach(a -> System.out.println(a));
    }
}
