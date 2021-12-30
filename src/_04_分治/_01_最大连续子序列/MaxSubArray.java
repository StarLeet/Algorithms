package _04_分治._01_最大连续子序列;

/**
 * @ClassName MaxSubArray
 * @Description  分治求解最大连续子序列问题
 * @Author StarLee
 * @Date 2021/12/29
 */

public class MaxSubArray {
    /**
     *  @MethodName maxSubArray
     *  @Description  参照归并排序,写出递归
     */
    public static int maxSubArray(int [] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSubArray(nums, 0, nums.length);
    }
    private static int maxSubArray(int[] nums, int begin, int end) {
        // 递归基: end - begin < 2, 说明只有一个元素, nums[begin] == nums[end]
        if (end - begin < 2) return nums[begin];

        int mid = (begin + end) >> 1;

        // 最大子序列一部分处在middle左侧,一部分在middle右侧的情况
        int leftMax = Integer.MIN_VALUE;
        int leftSum = 0;
        for (int i = mid - 1; i >= begin; i--) { // [i,mid)
            leftSum += nums[i];
            leftMax = Math.max(leftSum, leftMax);
        }
        int rightMax = Integer.MIN_VALUE;
        int rightSum = 0;
        for (int i = mid; i < end; i++) { // [mid, end)
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }

        // 最大子序列在 left部分, right部分的情况
        return Math.max(leftMax + rightMax,  //最大字串横跨middle的情况
                Math.max(
                        maxSubArray(nums, begin, mid), 	// 最大子串在[begin, mid)的情况
                        maxSubArray(nums, mid, end) 	// 最大子串在[mid, end)的情况
                ));
    }

    /**
     * 暴力穷举 - 优化
     * 一定程度上减小了重复计算,在固定一个子序列头后,在长度递增的过程中,反复利用递增前的值
     * 比如  1 -1 2 3 -4
     * 固定子序列头为1时,长度+1,则为[1,-1],值为0,再递增[1,-1,2],值为0+2;不需要从头遍历1-1+2
     */
    public static int maxSubArray2(int [] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 这里注意, 容易写成 int max = 0, 可能会出错, max 默认值必须是最小的值
        int max = Integer.MIN_VALUE;
        // 穷举, 列出所有可能的连续子序列, 分别计算它们的和, 最后取出最大值
        for (int begin = 0; begin < nums.length; begin++) {
            // 重复利用sum, 只有当begin修改才会重置
            int sum = 0;
            // begin不动, end修改的话, 子序列的和是叠加的, 无需每次都重新计算
            for (int end = begin; end < nums.length; end++) {
                sum += nums[end]; // sum是[begin, end]的和
                max = Math.max(max, sum);
            }
        }
        return max;
    }
    /**
     * 暴力
     * 问题：重复计算;时间复杂度O(n^3)
     */
    public static int maxSubArray1(int [] nums) {
        if (nums == null || nums.length == 0) return 0;
        // 这里注意, 容易写成 int max = 0, 可能会出错, max 默认值必须是最小的值
        int max = Integer.MIN_VALUE;
        // 穷举, 列出所有可能的连续子序列, 分别计算它们的和, 最后取出最大值
        for (int begin = 0; begin < nums.length; begin++) {  //标记子序列头
            for (int end = begin; end < nums.length; end++) { //子序列长度递增
                int sum = 0; // sum是[begin, end]的和
                // nums[begin] 到 nums[end] 求和
                for (int i = begin; i <= end; i++) {  //子序列元素之和
                    sum += nums[i];
                }
                max = Math.max(max, sum); // 取最大值
            }
        }
        return max;
    }
}
