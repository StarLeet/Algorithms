package _99_代码随想录._07_二叉树._02_二叉树的修改与构造;

import _99_代码随想录._07_二叉树.TreeNode;

/**
 * @ClassName _617_合并二叉树
 * @Description
 * @Author StarLee
 * @Date 2022/5/6
 */
public class _617_合并二叉树 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        mergeTrees1(root1,root2);
        return root1;
    }

    private void mergeTrees1(TreeNode root1, TreeNode root2){
        if (root2 == null) return;
        root1.val += root2.val;
        if (root1.left == null){
            root1.left = root2.left;
        }else {
            mergeTrees(root1.left,root2.left);
        }
        if (root1.right == null){
            root1.right = root2.right;
        }else {
            mergeTrees(root1.right,root2.right);
        }
    }
}
