package _99_代码随想录._07_二叉树._04_二叉树的公共祖先;

import _99_代码随想录._07_二叉树.TreeNode;

/**
 * @ClassName _235_二叉搜索树的最近公共祖先
 * @Description
 * @Author StarLee
 * @Date 2022/5/7
 */
public class _235_二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 保证p.val < q.val
        if (p.val > q.val){
            TreeNode tmp = p;
            p = q;
            q= tmp;
        }
        return lowestCommonAncestor1(root,p,q);
    }
    // 从上往下遍历,只要遇到第一个root.val在[p.val,q.val]之间,就可以得到最近公共祖先了
    private TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val >= p.val && root.val <= q.val) return root;
        if (root.val < p.val){
            return lowestCommonAncestor1(root.right, p, q);
        }else {
            return lowestCommonAncestor1(root.left, p, q);
        }
    }
}
