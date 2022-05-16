package _99_代码随想录._12_堆;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName _215_数组中的第K个最大元素
 * @Description
 * @Author StarLee
 * @Date 2022/4/20
 */

public class _215_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;
        // 底层是小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        return heap.peek();
    }
}
