package 算法面试._05_树操作;
// https://leetcode-cn.com/problems/subtree-of-another-tree/
/**
 * @ClassName _572_另一个树的子树
 * @Description
 * @Author StarLee
 * @Date 2022/1/11
 */

public class _572_另一个树的子树 {
    /**
     * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树
     * 如果存在，返回 true ；否则，返回 false
     */
    // 将树序列化
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null) return false;
        // 前序遍历的序列化 要在拼接开始前加上append("!")  防止12!#! 与2!#!混淆
        String s1 = serializeTree(root,new StringBuilder());
        String s2 = serializeTree(subRoot,new StringBuilder());
        return s1.contains(s2);
    }

    public String serializeTree(TreeNode root,StringBuilder sb){
        if (root == null) return sb.toString();
        if (root.left == null){
            sb.append("#!");
        }else {
            serializeTree(root.left,sb);
        }
        if (root.right == null){
            sb.append("#!");
        }else {
            serializeTree(root.right,sb);
        }
        sb.append(root.val).append("!");
        return sb.toString();
    }

    // 递归法解决
    public boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        // 到此说明两棵树都不为空
        // 先判断二者是不是同一棵树,如果不是看一下左子树跟subRoot是不是同一棵,同样判断右子树
        return isSameTree(root,subRoot) || isSubtree1(root.left,subRoot) || isSubtree1(root.right,subRoot);
    }

    /**
     * 递归比较两棵树的节点,相同返回true
     */
    public boolean isSameTree(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        // 到此说明两棵树都不为空
        // 判断二者的根是否相同
        if (root.val != subRoot.val) return false;
        // 如果相同继续判断,左子节点是否相同,并且右子节点是否相同
        return isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right);
    }
}
