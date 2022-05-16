package _99_代码随想录._07_二叉树._03_求二叉搜索树的属性;

import _99_代码随想录._07_二叉树.TreeNode;

/**
 * @ClassName _700_二叉搜索树中的搜索
 * @Description
 * @Author StarLee
 * @Date 2022/5/6
 */
public class _700_二叉搜索树中的搜索 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return root.val > val ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
