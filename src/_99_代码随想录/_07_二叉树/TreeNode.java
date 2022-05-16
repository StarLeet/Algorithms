package _99_代码随想录._07_二叉树;

/**
 * @ClassName TreeNode
 * @Description  leetcode树节点类
 * @Author StarLee
 * @Date 2022/1/9
 */

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
