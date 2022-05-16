package _99_代码随想录._07_二叉树._01_二叉树的属性;

import _99_代码随想录._07_二叉树.TreeNode;

/**
 * @ClassName _112_路径总和
 * @Description
 * @Author StarLee
 * @Date 2022/5/5
 */
public class _112_路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return hasPathSum(root,targetSum,0);
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int curSum) {
        if (root == null) return false;
        curSum += root.val;
        // 碰到叶子节点,进行结算
        if (root.left == null && root.right == null){
            return curSum == targetSum;
        }
        return hasPathSum(root.left,targetSum,curSum) || hasPathSum(root.right,targetSum,curSum);
    }
}
