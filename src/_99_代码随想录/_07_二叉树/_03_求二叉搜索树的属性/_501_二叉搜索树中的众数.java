package _99_代码随想录._07_二叉树._03_求二叉搜索树的属性;


import _99_代码随想录._07_二叉树.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _501_二叉搜索树中的众数
 * @Description
 * @Author StarLee
 * @Date 2022/5/6
 */
public class _501_二叉搜索树中的众数 {
    private final List<Integer> values = new ArrayList<>();
    // 存储前一个值
    private int prevVal = Integer.MIN_VALUE;
    private int count;
    private int maxCount;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        inOrder(root);
        int[] result = new int[values.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = values.get(i);
        }
        return result;
    }

    private void inOrder(TreeNode root){
        if (root == null) return;
        inOrder(root.left);
        // 中序遍历的第一个节点、或者当前值与前一个值相同时
        if (prevVal == Integer.MIN_VALUE || prevVal == root.val){
            count++;
        }else {  // 遇到新的值,count置为1
            count = 1;
        }
        // 判断是否为新的众数
        if (count == maxCount){
            values.add(root.val);
        }else if (count > maxCount){
            maxCount = count;
            values.clear();
            values.add(root.val);
        }
        // 当前值变为旧值
        prevVal = root.val;
        inOrder(root.right);
    }
}
