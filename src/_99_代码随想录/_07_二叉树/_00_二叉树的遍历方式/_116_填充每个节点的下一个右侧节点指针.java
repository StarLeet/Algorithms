package _99_代码随想录._07_二叉树._00_二叉树的遍历方式;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName _116_填充每个节点的下一个右侧节点指针
 * @Description
 * @Author StarLee
 * @Date 2022/4/23
 */

public class _116_填充每个节点的下一个右侧节点指针 {

    private static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        int levelSize = 1;
        Node prev = root;
        // 1 2 3 4
        while (!nodes.isEmpty()){
            Node cur = nodes.poll();
            levelSize--;
            if (prev != cur){
                prev.next = cur;
                prev = cur;
            }
            if (cur.left != null) nodes.add(cur.left);
            if (cur.right != null) nodes.add(cur.right);
            if (levelSize == 0){
                levelSize = nodes.size();
                prev = nodes.peek();
            }
        }
        return root;
    }
}
