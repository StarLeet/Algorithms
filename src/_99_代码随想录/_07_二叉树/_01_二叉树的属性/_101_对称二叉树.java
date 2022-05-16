package _99_代码随想录._07_二叉树._01_二叉树的属性;

import _99_代码随想录._07_二叉树.TreeNode;

/**
 * @ClassName _101_对称二叉树
 * @Description
 * @Author StarLee
 * @Date 2022/5/4
 */
public class _101_对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left,root.right);
    }
    /**
     *  比较传入的两个节点的值
     *  先写出终止递归的条件,比如什么时候就可以确定这棵树不是一个对称二叉树
     *  如果当前节点满足了,则继续比较left.left与right.right、left.right与right.left
     */
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        // 先序遍历
        if (left.val != right.val) return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}
