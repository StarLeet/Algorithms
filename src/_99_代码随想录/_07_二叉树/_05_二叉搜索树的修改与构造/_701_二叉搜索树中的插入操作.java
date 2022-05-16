package _99_代码随想录._07_二叉树._05_二叉搜索树的修改与构造;

import _99_代码随想录._07_二叉树.TreeNode;

/**
 * @ClassName _701_二叉搜索树中的插入操作
 * @Description
 * @Author StarLee
 * @Date 2022/5/7
 */
public class _701_二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        insertIntoBST(null,root,val);
        return root;
    }
    // 递归到叶子节点插入即可
    private void insertIntoBST(TreeNode parent, TreeNode root, int val){
        if (root == null) {
            TreeNode node = new TreeNode(val);
            if (parent.val > val){
                parent.left = node;
            }else {
                parent.right = node;
            }
            return;
        }
        if (root.val > val){
            insertIntoBST(root,root.left,val);
        }else {
            insertIntoBST(root,root.right,val);
        }
    }
}
