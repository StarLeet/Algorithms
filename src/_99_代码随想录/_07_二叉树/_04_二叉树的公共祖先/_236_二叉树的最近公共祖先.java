package _99_代码随想录._07_二叉树._04_二叉树的公共祖先;

import _99_代码随想录._07_二叉树.TreeNode;

/**
 * @ClassName _236_二叉树的最近公共祖先
 * @Description
 * @Author StarLee
 * @Date 2022/5/6
 */
public class _236_二叉树的最近公共祖先 {
    // 题目已经假设p、q都只存在一个
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 找到叶子节点、找到p、q点时,不必继续深入
        if (root == null || root == p || root == q) return root;
        // 看左子树中有没有p或者q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 看右子树.....
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 左右子树中分别存在p、q
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
}
