package 算法面试._04_队列操作;
// https://leetcode-cn.com/problems/sliding-window-maximum/

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName _239_滑动窗口最大值
 * @Description
 * @Author StarLee
 * @Date 2022/1/9
 */
@SuppressWarnings("all")
public class _239_滑动窗口最大值 {
    /***
     * 给你一个整数数组nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     */
    public int[] maxSlidingWindow_duque(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (k == 1) return nums;  // 窗口大小为1时返回原数组
        Deque<Integer> deque = new LinkedList<>();  // 双端队列
        int[] maxes = new int[nums.length - k + 1];  // 存放各个滑动窗口中的最大值
        for (int i = 0; i < nums.length; i++) { // i为窗口末端下标
            //使队列保持严格降序排列
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i); // 将元素的下标加入队列
            int w = i - k + 1;  // w为窗口起始下标
            if (w < 0) continue;  // 检查窗口下标合法性
            if (deque.peekFirst() < w){  // 检查队头的合法性,存在队头在滑动窗口范围前的情况
                deque.pollFirst();
            }
            maxes[w] = nums[deque.peekFirst()]; // 队头为最大值,入队即可
        }
        return maxes;
    }

    /***
     * 当数组为降序时,会退化成单纯的暴力算法
     */
    public int[] maxSlidingWindow(int[] nums, int k){
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (k == 1) return nums;  // 窗口大小为1时返回原数组
        int[] maxes = new int[nums.length - k + 1];
        int maxIndex = -1;  // 记录当前窗口的最大索引,默认为-1
        for (int li = 0; li < maxes.length; li++) {
            int ri = li + k - 1; // 窗口最右索引
            if (maxIndex < li){  // 成立说明,做大索引失效
                maxIndex = li;
                for (int j = li + 1;j <= ri;j++){  // 失效后,在窗口内重新遍历寻找新的最大索引
                    if (nums[j] > nums[maxIndex]){
                        maxIndex = j;
                    }
                }
            }else if (nums[ri] > nums[maxIndex]){ // 新窗口的最右索引可能产生最大值
                maxIndex = ri;
            }
            // 到此可以确定新一轮的最大值
            maxes[li] = nums[maxIndex];
        }
        return maxes;
    }
}
