package 算法面试._09_高频题;
// https://leetcode-cn.com/problems/trapping-rain-water/
/**
 * @ClassName _42_接雨水
 * @Description
 * @Author StarLee
 * @Date 2022/1/24
 */

public class _42_接雨水 {
    /**
     * 给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     */
    public int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;
        // 存储索引为i时,右边最大柱子高度
        int[] rightMaxes = new int[height.length];
        int rightMax = 0;
        // 理论上能乘水的最后一根柱子
        int lastIndex = height.length - 2;
        for (int i = lastIndex; i >= 0; i--) {
            // 最后一根柱子的右边之间默认为0,因为其不可能装水
            if (height[i + 1] > rightMax){
                rightMax = height[i + 1];
            }
            rightMaxes[i] = rightMax;
        }
        int water = 0;  // 装水总量
        int leftMax = 0;
        // 每个柱子上能承载多少水,关键在于左右最高柱子的较小者
        for (int i = 1; i <= lastIndex; i++) {
            leftMax = Math.max(height[i - 1],leftMax);
            int tmpWater = Math.min(leftMax,rightMaxes[i]) - height[i];
            if (tmpWater > 0) water += tmpWater;
        }
        return water;
    }
}
