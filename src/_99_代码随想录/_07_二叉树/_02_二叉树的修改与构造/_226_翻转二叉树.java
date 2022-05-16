package _99_代码随想录._07_二叉树._02_二叉树的修改与构造;

import 算法面试._05_树操作.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;

/**
 * @ClassName _226_翻转二叉树
 * @Description
 * @Author StarLee
 * @Date 2022/4/23
 */

public class _226_翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        revertTree(root);
        return root;
    }
    /**  1. 确定返回值：因为传入的是引用,所以不需要返回什么
     *   2. 确定退出条件：递归应该在遍历到最底的null节点退出,都没了还翻转啥
     *   3. 确定每层递归在重复做哪些事：该递归的功能是翻转二叉树,自然每层都要交换左右子树。
     *      然后再分别对孩子的左右子树进行翻转
     */
    private void revertTree(TreeNode root){
        if (root == null) return;
        // 交换左右子树
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        revertTree(root.left);
        revertTree(root.right);
    }

    /**
     * 层序遍历解决
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            TreeNode cur = nodes.poll();
            // 左右子树交换
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if (cur.left != null) nodes.add(cur.left);
            if (cur.right != null) nodes.add(cur.right);
        }
        return root;
    }
}
