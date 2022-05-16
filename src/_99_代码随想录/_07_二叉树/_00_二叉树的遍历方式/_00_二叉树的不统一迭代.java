package _99_代码随想录._07_二叉树._00_二叉树的遍历方式;

import 算法面试._05_树操作.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName 二叉树的不统一迭代
 * @Description
 * @Author StarLee
 * @Date 2022/4/22
 */

public class _00_二叉树的不统一迭代 {
    /**      1
     *     2   3
     *    4 5 6 7
     */
    private List<Integer> prevOrder(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> nodes = new Stack<>();
        while (!nodes.isEmpty() || root != null){
            // 一路向左
            while (root != null){
                nodes.push(root);
                // 向左的同时输出curRoot
                result.add(root.val);
                root = root.left;
            }
            // 左的不能再左时,弹出最左节点,切换到右子树,继续一路向左
            root = nodes.pop().right;
        }
        return result;
    }

    private List<Integer> inOrder(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> nodes = new Stack<>();
        while (!nodes.isEmpty() || root != null){
            while (root != null){
                nodes.push(root);
                root = root.left;
            }
            TreeNode curRoot = nodes.pop();
            result.add(curRoot.val);
            root = curRoot.right;
        }
        return result;
    }

    /**
     * 后序遍历其实可以跟先序遍历对应
     * 后序遍历的方式：左——>右——>中
     * 我们只需按中——>右——>左的前序遍历方式,求出结果,然后再翻转即可
     */
    private List<Integer> postOrder(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> nodes = new Stack<>();
        // 前序遍历中右左
        while (!nodes.isEmpty() || root != null){
            while (root != null){
                nodes.push(root);
                result.add(root.val);
                root = root.right;
            }
            root = nodes.pop();
            root = root.left;
        }
        // 将结果翻转
        int left = 0, right = result.size() - 1;
        while (left < right){
            int tmp = result.get(left);
            result.set(left++,result.get(right));
            result.set(right--,tmp);
        }
        return result;
    }
}
