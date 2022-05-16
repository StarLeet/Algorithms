package _99_代码随想录._07_二叉树._01_二叉树的属性;

import _99_代码随想录._07_二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName _104_二叉树的最大深度
 * @Description
 * @Author StarLee
 * @Date 2022/5/4
 */
public class _104_二叉树的最大深度 {
    // 因为最大深度=最大高度,所以这里用后序遍历(求高度的)也可以
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // 这里用了后序遍历,那个 +1 表示加上当前的中节点
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
    // 层序遍历
    public int maxDepth1(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSize = 1;
        int depth = 0;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            levelSize--;
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
            if (levelSize == 0){
                levelSize = queue.size();
                depth++;
            }
        }
        return depth;
    }
}
