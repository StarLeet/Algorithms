package _99_代码随想录._07_二叉树._03_求二叉搜索树的属性;

import _99_代码随想录._07_二叉树.TreeNode;
import sun.rmi.transport.proxy.RMISocketInfo;

/**
 * @ClassName _530_二叉搜索树的最小绝对差
 * @Description
 * @Author StarLee
 * @Date 2022/5/6
 */
public class _530_二叉搜索树的最小绝对差 {
    private int minSub = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        travelBST(root);
        return minSub;
    }

    private void travelBST(TreeNode root){
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        // 找前驱
        TreeNode prev = root.left;
        if (prev != null){
            while (prev.right != null){
                prev = prev.right;
            }
            minSub = Math.min(minSub,(root.val - prev.val));
        }
        // 找后继
        TreeNode post = root.right;
        if (post != null){
            while (post.left != null){
                post = post.left;
            }
            minSub = Math.min(minSub,(post.val - root.val));
        }
        travelBST(root.left);
        travelBST(root.right);
    }
}
