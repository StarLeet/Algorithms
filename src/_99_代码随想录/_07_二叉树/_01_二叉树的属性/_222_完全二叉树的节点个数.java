package _99_代码随想录._07_二叉树._01_二叉树的属性;

import _99_代码随想录._07_二叉树.TreeNode;
import jdk.nashorn.internal.ir.WhileNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName _222_完全二叉树的节点个数
 * @Description
 * @Author StarLee
 * @Date 2022/5/4
 */
public class _222_完全二叉树的节点个数 {
    // 层序遍历
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int nodeNum = 1;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if (cur.left == null) return nodeNum;
            queue.add(cur.left);
            nodeNum++;
            if (cur.right == null) return nodeNum;
            queue.add(cur.right);
            nodeNum++;
        }
        return nodeNum;
    }

    public int countNodes1(TreeNode root){
        if (root == null) return 0;
        // 后序遍历
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }
}
