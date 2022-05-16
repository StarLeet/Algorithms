package _99_代码随想录._07_二叉树._03_求二叉搜索树的属性;

import _99_代码随想录._07_二叉树.TreeNode;

/**
 * @ClassName _98_验证二叉搜索树
 * @Description
 * @Author StarLee
 * @Date 2022/5/6
 */
public class _98_验证二叉搜索树 {
    // 效率低下
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        boolean result = false;
        // 找前驱
        TreeNode prev = root.left;
        if (prev != null){
            while (prev.right != null){
                prev = prev.right;
            }
            result = prev.val >= root.val;
        }
        // 找后继
        TreeNode post = root.right;
        if (post != null){
            while (post.left != null){
                post = post.left;
            }
            result |= post.val <= root.val;
        }
        if (result) return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }

    // prev记录前驱节点的值,因为力扣的边界判断,所以采用Integer
    private Integer prev = null;
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        boolean left = isValidBST1(root.left);
        if (prev != null && prev >= root.val) return false;
        prev = root.val;
        return left && isValidBST1(root.right);
    }
}
