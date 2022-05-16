package _99_代码随想录._07_二叉树._01_二叉树的属性;

import _99_代码随想录._07_二叉树.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName _513_找树左下角的值
 * @Description
 * @Author StarLee
 * @Date 2022/5/5
 */
public class _513_找树左下角的值 {
    // 逆层序遍历——从右向左
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            if (cur.right != null) queue.add(cur.right);
            if (cur.left != null) queue.add(cur.left);
        }
        return cur.val;
    }

    // 递归写法
    public int findBottomLeftValue1(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        return findBottomLeftValue1(root,0,root.val);
    }
    // 必须有一个全局变量记住当前最大深度
    private int maxDepth = 0;
    private int findBottomLeftValue1(TreeNode root, int depth, int result) {
        if (root == null) return result;
        // 碰到叶子节点进行判断
        if (root.left == null && root.right == null){
            // 不能等于,会被同为最后一行的其它叶子覆盖
            if (depth > maxDepth){
                maxDepth = depth;
                result = root.val;
            }
            return result;
        }
        result = findBottomLeftValue1(root.left, depth + 1, result);
        result = findBottomLeftValue1(root.right, depth + 1, result);
        return result;
    }
}
