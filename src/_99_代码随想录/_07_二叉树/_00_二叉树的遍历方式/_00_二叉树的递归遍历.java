package _99_代码随想录._07_二叉树._00_二叉树的遍历方式;

import 算法面试._05_树操作.TreeNode;

/**
 * @ClassName _00_二叉树的递归遍历
 * @Description
 * @Author StarLee
 * @Date 2022/4/23
 */

public class _00_二叉树的递归遍历 {
    /**
     * 前序遍历
     */
    private void prevOrder(TreeNode root){
        if (root == null) return;
        System.out.println(root.val + " ");
        prevOrder(root.left);
        prevOrder(root.right);
    }

    /**
     * 中序遍历
     */
    private void inOrder(TreeNode root){
        if (root == null) return;
        System.out.println(root.val + " ");
        prevOrder(root.left);
        prevOrder(root.right);
    }

    /**
     * 后序遍历
     */
    private void postOrder(TreeNode root){
        if (root == null) return;
        System.out.println(root.val + " ");
        prevOrder(root.left);
        prevOrder(root.right);
    }
}
