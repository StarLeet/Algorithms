package 算法面试._03_栈操作;
// https://leetcode-cn.com/problems/maximum-binary-tree/
import 算法面试._05_树操作.TreeNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName _654_最大二叉树
 * @Description
 * @Author StarLee
 * @Date 2022/1/9
 */

public class _654_最大二叉树 {
    /***
     * 给定一个不含重复元素的整数数组nums。一个以此数组直接递归构建的最大二叉树定义如下：
     *
     * 二叉树的根是数组 nums 中的最大元素。
     * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
     * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
     * 返回有给定数组nums构建的最大二叉树
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return findRoot(nums,0,nums.length);
    }

    /***
     * 递归法
     * 在左闭右开[left,right)的区间中,寻找最大元素,并返回下标
     */
    public TreeNode findRoot(int[] nums,int left,int right){
        if (left == right) return null;
        int maxIndex = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[maxIndex] < nums[i]) maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = findRoot(nums,left,maxIndex);
        root.right = findRoot(nums,maxIndex + 1,right);
        return root;
    }

    /***
     * 拓展题 要求还要返回各元素父节点的索引
     */
    public int[] parentIndex_stack(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        Stack<Integer> stack = new Stack<>();  // 栈中存放索引
        int[] lBig = new int[nums.length]; // 存放往左第一个大于自己的元素索引
        int[] rBig = new int[nums.length]; // 存放往右第一个大于自己的元素索引
        // 初始化
        for (int i = 0; i < nums.length; i++) {
            lBig[i] = rBig[i] = -1;
        }
        // 使用栈来寻找 【！！！关键思想】
        for (int i = 0; i < nums.length; i++) {  // 遍历原数组
            // 栈中元素小于自己则弹出(保持底——>顶严格递减)
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                // 对于栈中将被弹出的元素而言,往右第一个大于自己的元素一定是当前元素
                rBig[stack.pop()] = i;
            }
            // 对于当前元素而言,往左第一个大于自己的元素的索引,是栈顶(小的都被弹出)
            lBig[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        /*  到此,lBig[]、rBig[]维护完成
         *  parentIndex要么处于lBig,要么处于rBig
         */
        int[] parentIndex = new int[nums.length];
        for (int j = 0; j < parentIndex.length; j++) {
            if (rBig[j] == -1 && lBig[j] == -1){  // 只有根左右没有最大值
                parentIndex[j] = -1;
                continue;
            }
            if (rBig[j] == -1 || lBig[j] == -1){  // 分别表示最右/最左的情况
                parentIndex[j] = rBig[j] > 0 ? rBig[j] : lBig[j];
                continue;
            }
            // 中间的一般元素,取两数组的索引内容较小的即可
            parentIndex[j] = nums[lBig[j]] > nums[rBig[j]] ? rBig[j] : lBig[j];
        }
        return parentIndex;
    }


    public static void main(String[] args) {
        _654_最大二叉树 o = new _654_最大二叉树();
        int[] nums = { 3, 2, 1, 6, 0, 5 };
        System.out.println(Arrays.toString(o.parentIndex_stack(nums)));
    }
}
