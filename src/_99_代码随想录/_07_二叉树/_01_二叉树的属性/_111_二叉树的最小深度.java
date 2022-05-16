package _99_代码随想录._07_二叉树._01_二叉树的属性;

import _99_代码随想录._07_二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName _111_二叉树的最小深度
 * @Description
 * @Author StarLee
 * @Date 2022/5/4
 */
public class _111_二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSize = 1;
        int minDep = 1;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            levelSize--;
            if (cur.left == null && cur.right == null) return minDep;
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
            if (levelSize == 0){
                levelSize = queue.size();
                minDep++;
            }
        }
        return minDep;
    }
}
