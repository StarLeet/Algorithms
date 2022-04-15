package 算法面试._05_树操作;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName _94_二叉树的中序遍历
 * @Description
 * @Author StarLee
 * @Date 2022/4/9
 */

public class _94_二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return null;
        ArrayList<Integer> integers = new ArrayList<>();
        Stack<TreeNode> roots = new Stack<>();
        /*
        *     5
        *   3   6
        *  1 4 5 7
        * */
        while (!roots.isEmpty() || root != null){
            while (root != null){
                roots.push(root);
                root = root.left;
            }
            root = roots.pop();
            integers.add(root.val);
            root = root.right;
        }
        return integers;
    }
}
