package _99_代码随想录._07_二叉树;


import _99_代码随想录._07_二叉树.TreeNode;

/**
 * @ClassName _572_另一棵树的子树
 * @Description
 * @Author StarLee
 * @Date 2022/5/4
 */
public class _572_另一棵树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        return isSameTree(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean isSameTree(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right);
    }
}
