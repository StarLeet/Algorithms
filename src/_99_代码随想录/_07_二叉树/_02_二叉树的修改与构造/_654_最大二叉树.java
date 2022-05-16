package _99_代码随想录._07_二叉树._02_二叉树的修改与构造;

import _99_代码随想录._07_二叉树.TreeNode;

/**
 * @ClassName _654_最大二叉树
 * @Description
 * @Author StarLee
 * @Date 2022/5/6
 */
public class _654_最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return constructMaximumBinaryTree(nums,0,nums.length);
    }
    // 左闭右开
    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        // 没元素时退出
        if (left == right) return null;
        int curMaxIndex = findMax(nums,left,right);
        TreeNode root = new TreeNode(nums[curMaxIndex]);
        root.left = constructMaximumBinaryTree(nums,left,curMaxIndex);
        root.right = constructMaximumBinaryTree(nums,curMaxIndex + 1,right);
        return root;
    }

    private int findMax(int[] nums, int left, int right){
        int maxIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
