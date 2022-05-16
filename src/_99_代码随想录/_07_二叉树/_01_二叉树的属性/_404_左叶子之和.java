package _99_代码随想录._07_二叉树._01_二叉树的属性;

import _99_代码随想录._07_二叉树.TreeNode;

/**
 * @ClassName _404_左叶子之和
 * @Description
 * @Author StarLee
 * @Date 2022/5/4
 */
public class _404_左叶子之和 {
    /**       1
     *      2   3
     *     4 5 6 7
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        // 由父节点来确定孩子是否是左叶子
        if (root.left != null && root.left.left == null && root.left.right == null)
            //如果孩子是左叶子,则不需要再遍历左子树,之间遍历右子树
            return root.left.val + sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
