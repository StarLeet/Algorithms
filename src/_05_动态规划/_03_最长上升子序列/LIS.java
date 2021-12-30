package _05_动态规划._03_最长上升子序列;

/**
 * @ClassName LIS
 * @Description  动态规划——最长上升子序列
 * @Author StarLee
 * @Date 2021/12/30
 */

public class LIS {
    static int lengthOfLIS3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 牌堆的数量
        int len = 0;
        // 牌顶数组
        int[] top = new int[nums.length];
        // 遍历所有的牌
        for (int num : nums) {
            int begin = 0;
            int end = len;
            while (begin < end) {
                int mid = (begin + end) >> 1;
                if (num <= top[mid]) {
                    end = mid;
                } else {
                    begin = mid + 1;
                }
            }
            // 覆盖牌顶
            top[begin] = num;
            // 检查是否要新建一个牌堆
            if (begin == len) len++;
        }
        return len;
    }

    static int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 牌堆的数量
        int len = 0;
        // 牌顶数组
        int[] top = new int[nums.length];
        // 遍历所有的牌
        for (int num : nums) {
            int j = 0;
            while (j < len) {
                // 找到一个>=nums的牌顶
                if (top[j] >= num) {
                    top[j] = num;
                    break;
                }
                // 牌顶 < nums
                j++;
            }
            if (j == len) { // 新建一个牌堆
                len++;
                top[j] = num;
            }
        }
        return len;
    }

    /**
     * 思路:要想找出当前数的最长上升子序列
     * 首先找出这个数之前的最大上升子序列(最后一个值小于自己)
     * 也就是说对于nums[i]结尾的子序列,要想得到最大上升子序列
     * 首先遍历dp[0]-dp[i-1],找到一个nums[j]<nums[i] (0<=j<i)
     * 拿到最大的dp,再加上自己
     */
    static public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int max = dp[0] = 1; // 只有一个元素则长度为1
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 1; // 默认只有一个元素时长度为1
            for (int j = 0; j < i; j++) {
                // 无法成为一个上升子序列
                if (nums[j] >= nums[i]) continue;
                dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
