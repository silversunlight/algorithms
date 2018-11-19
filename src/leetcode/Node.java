package leetcode;

import java.util.List;

/**
 * @Author ：Lance Sun
 * @Date ：Created in 22:11 2018/9/23
 * @Description：
 * @ModifiedBy：
 * @Version: 1.0.0
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
