package _99_代码随想录._01_数组.滑动窗口;

/**
 * @ClassName _209_长度最小的子数组
 * @Description
 * @Author StarLee
 * @Date 2022/4/14
 */

public class _209_长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int result = Integer.MAX_VALUE;
        int begin = 0;
        int sum = 0;
        int curLen = 0;
        // [2,3,1,2,4,3]  7
        for (int num : nums) {
            sum += num;
            curLen++;
            while (sum >= target) {
                result = Math.min(curLen, result);
                sum -= nums[begin++];  // 缩小窗口,尝试能不能更短
                curLen--;
            }
            if (result == 1) return result;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
