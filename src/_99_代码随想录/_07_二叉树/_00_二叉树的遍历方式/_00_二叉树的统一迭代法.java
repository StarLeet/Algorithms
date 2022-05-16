package _99_代码随想录._07_二叉树._00_二叉树的遍历方式;

import 算法面试._05_树操作.TreeNode;

import java.util.*;

/**
 * @ClassName 二叉树的统一迭代法
 * @Description  只需要改两个nodes.push的位置即可
 * @Author StarLee
 * @Date 2022/4/22
 */
@SuppressWarnings("all")
public class _00_二叉树的统一迭代法 {

    /**================先记住层序遍历,后面的统一部分头部代码跟层序是一样的===============*/

    /**
     * 层序遍历
     */
    private List<Integer> levelOrder(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
//        int levelSize = 1;
//        int height = 0;
        while (!nodes.isEmpty()){
            TreeNode cur = nodes.poll();
            result.add(cur.val);
//            levelSize--;
            if (cur.left != null) nodes.add(cur.left);
            if (cur.right != null) nodes.add(cur.right);
//            if (levelSize == 0){
//                levelSize = nodes.size();
//                height++;
//            }
        }
        return result;
    }

    /**
     * 前序遍历
     */
    private List<Integer> prevOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        // 本质是模拟一个栈
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.empty()) {
            TreeNode node = nodes.pop();
            if (node != null) {
                if (node.right != null) nodes.push(node.right);  // 添加右节点(空节点不入栈)
                if (node.left != null) nodes.push(node.left);    // 添加左节点(空节点不入栈)
                nodes.push(node);                          // 添加中节点
                nodes.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。
            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                result.add(nodes.pop().val); // 重新取出栈中元素
            }
        }
        return result;
    }

    /**
     * 中序遍历
     */
    private List<Integer> inOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.empty()) {
            TreeNode node = nodes.pop();
            if (node != null) {
                if (node.right != null) nodes.push(node.right);  // 添加右节点(空节点不入栈)
                nodes.push(node);                          // 添加中节点
                nodes.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。
                if (node.left != null) nodes.push(node.left);    // 添加左节点(空节点不入栈)
            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                result.add(nodes.pop().val); // 重新取出栈中元素
            }
        }
        return result;
    }

    /**
     * 后序遍历
     */
    private List<Integer> postOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.empty()) {
            TreeNode node = nodes.pop();
            if (node != null) {
                nodes.push(node);                          // 添加中节点
                nodes.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。
                if (node.right != null) nodes.push(node.right);  // 添加右节点(空节点不入栈)
                if (node.left != null) nodes.push(node.left);    // 添加左节点(空节点不入栈)
            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                result.add(nodes.pop().val); // 重新取出栈中元素
            }
        }
        return result;
    }
}