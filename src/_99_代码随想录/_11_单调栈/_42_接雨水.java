package _99_代码随想录._11_单调栈;

/**
 * @ClassName _42_接雨水
 * @Description
 * @Author StarLee
 * @Date 2022/4/18
 */

public class _42_接雨水 {
    // 双指针
    public int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;
        // 当索引为i时,右边的最高柱子高度
        int[] rightTallest = new int[height.length];
        int max = Integer.MIN_VALUE;
        // 维护右边最大高度数组
        int lastIndex = height.length - 2;
        for (int i = lastIndex; i >= 1; i--) {
            if (height[i + 1] > max) max = height[i + 1];
            rightTallest[i] = max;
        }
        int result = 0;
        max = height[0];
        for (int i = 1; i <= lastIndex; i++) {
            int water = (Math.min(max,rightTallest[i]) - height[i]);
            max = Math.max(max,height[i]);
            if (water <= 0) continue;
            result += water;
        }
        return result;
    }

    public int trap1(int[] height) {
        int left = 0, right = height.length - 1;
        int sum = 0, max = 0;// 标记雨水高度
        while (left < right) {
            while (left < right && height[left] <= max) { // 只要小于高度，则代表可以接雨水
                sum += (max - height[left]);
                left++;
            }
            while (left < right && height[right] <= max) {
                sum += (max - height[right]);
                right--;
            }
            max = Math.min(height[left], height[right]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        _42_接雨水 v = new _42_接雨水();
        v.trap1(arr);
    }
}
