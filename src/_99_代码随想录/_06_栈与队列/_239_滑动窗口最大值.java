package _99_代码随想录._06_栈与队列;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName _239_滑动窗口最大值
 * @Description
 * @Author StarLee
 * @Date 2022/5/3
 */
public class _239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null) return new int[0];
        // 1 2 5 3 2 -4 1 -2
        // 保持队列严格递增,队列中存储数组的索引
        Deque<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            // 保持队列单调递增
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()]) queue.pollLast();
            queue.add(i);
            if ((i - queue.peek() + 1) > k){
                // 说明当前最大值已经失效
                queue.poll();
            }
            result[i] = nums[queue.peek()];
        }
        return Arrays.copyOfRange(result,k - 1,result.length);
    }
}
