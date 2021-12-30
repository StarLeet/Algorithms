package _05_动态规划._02_最大连续子序列;

/**
 * @ClassName MaxSubArray
 * @Description  动态规划求解最大连续子序列
 * @Author StarLee
 * @Date 2021/12/30
 */

public class MaxSubArray {
    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0; // 非法数据监测
        int dp = nums[0]; // 发现只需要用到前一个数的最大连续子序列值,所以去掉数组
        int max = dp;
        // 状态转移方程
        for (int i = 1; i < nums.length; i++) {
            if (dp > 0) {
                dp = dp + nums[i];
            } else {
                dp = nums[i];
            }
            max = Math.max(max, dp);
        }
        return max;
    }

    /**
     *  思路:  给出[1,-1,-2,3,4]求最大连续子序列
     *   如果以nums[i-1]结尾的最大连续子序列值为负数,那么num[i]结尾的最大子序列就是自己本身
     *   就好比上个数组,以-2结尾的最大连续子序列是-2或者[1,-1,-2],那么以3结尾的只能是自己了,要不然会更小
     *   只有前一个数结尾的最大连续子序列的值为正数时,当前的值才能更大
     */
    public static int maxSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0; // 非法数据检测
        int[] dp = new int[nums.length];  //动态规划数组
        int max = dp[0] = nums[0]; // 初始状态
        // 状态转移方程
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            max = Math.max(max, dp[i]);  //保存最大值
        }
        return max;
    }
}
