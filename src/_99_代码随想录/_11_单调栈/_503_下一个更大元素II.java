package _99_代码随想录._11_单调栈;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName _503_下一个更大元素II
 * @Description
 * @Author StarLee
 * @Date 2022/4/18
 */

public class _503_下一个更大元素II {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        // 单调栈
        Stack<Integer> stack = new Stack<>();
        // 记录数组最大元素索引
        int bigIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                result[stack.pop()] = nums[i];
            }
            if (stack.isEmpty()) bigIndex = i;
            stack.push(i);
        }
        // 保留栈中元素,从头遍历数组[0,bigIndex],只进不出
        for (int i = 0; i <= bigIndex; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                result[stack.pop()] = nums[i];
            }
            if (stack.isEmpty()) break;
        }
        return result;
    }
}
