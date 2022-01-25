package 算法面试._09_高频题;
// https://leetcode-cn.com/problems/container-with-most-water/
/**
 * @ClassName _11_盛最多水的容器
 * @Description
 * @Author StarLee
 * @Date 2022/1/23
 */

public class _11_盛最多水的容器 {
    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai)
     * 在坐标内画 n 条垂直线，垂直线i的两个端点分别为(i,ai) 和 (i, 0)
     * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水
     * 输入：height = [4,3,2,1,4]
     * 输出：16
     */
    public int maxArea(int[] height) {
        if (height.length == 2) return Math.min(height[0],height[1]);
        int max = 0;
        int right = height.length - 1;
        for (int left = 0; left < right;) {
            int width = right - left;
            int minHeight;
            if (height[left] < height[right]){
                minHeight = height[left++];
                // 宽度变小,如果最低的柱子变得更小,那就不可能变大,直接跳过
                while (left != 0 && left < right && height[left] <= height[left - 1]) left++;
            }else {
                minHeight = height[right--];
                // 宽度变小,如果最低的柱子变得更小,那就不可能变大,直接跳过
                while (right != height.length - 1 && left < right && height[right] <= height[right + 1]) right--;
            }
            int capacity = width * minHeight;
            if (capacity > max){
                max = capacity;
            }
        }
        return max;
    }
}
