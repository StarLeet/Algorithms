package _99_代码随想录._07_二叉树._01_二叉树的属性;

import _99_代码随想录._07_二叉树.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @ClassName _110_平衡二叉树
 * @Description
 * @Author StarLee
 * @Date 2022/4/24
 */

public class _110_平衡二叉树 {
    // 左右子树高度差为1
    // 要想知道高度,得进行后序遍历,因为先知道左右子树的高度,才能知道自己的高度
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return treeBalanced(root) != -1;
    }

    private int treeBalanced(TreeNode root){
        if (root == null) return 0;
        int lTreeHeight = treeBalanced(root.left);
        if (lTreeHeight == -1) return -1;
        int rTreeHeight = treeBalanced(root.right);
        if (rTreeHeight == -1) return -1;
        if (Math.abs(lTreeHeight - rTreeHeight) > 1){
            return -1;
        }
        return Math.max(lTreeHeight,rTreeHeight) + 1;
    }
}
