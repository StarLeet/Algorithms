package 算法面试._05_树操作;
// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
/**
 * @ClassName _236_二叉树的最近公共祖先
 * @Description
 * @Author StarLee
 * @Date 2022/1/16
 */

public class _236_二叉树的最近公共祖先 {
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q
     * 最近公共祖先表示为一个节点x，满足x是p、q的祖先且x的深度尽可能大(一个节点也可以是它自己的祖先)
     *
     * 思路：
     * 去以root为根节点的二叉树中查找p、q的最近公共祖先
     * ① 如果p、q同时存在于这棵二叉树中，就能成功返回它们的最近公共祖先
     * ② 如果p、q都不存在于这棵二叉树中，返回null
     * ③ 如果只有p存在于这棵二叉树中，返回p
     * ④ 如果只有q存在于这棵二叉树中，返回q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
                               ┌───176────┐
                               │          │
                              34─┐     ┌─247─┐
                                 │     │     │
                              ┌─106─┐ 205   280─┐
                              │     │           │
                              72   113─┐       290
                                       │
                                      162
        */
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        // p、q分别处在root为根的两颗子树中
        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }
}
