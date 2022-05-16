package _99_代码随想录._07_二叉树;

import java.util.List;

/**
 * @ClassName Node
 * @Description
 * @Author StarLee
 * @Date 2022/4/23
 */

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
