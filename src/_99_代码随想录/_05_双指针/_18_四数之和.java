package _99_代码随想录._05_双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName _18_四数之和
 * @Description  原理和三数之和是一样的,就是多了个for循环,多了个去重操作
 * @Author StarLee
 * @Date 2022/5/3
 */
public class _18_四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);
        // 前两个固定,找后两个,对于固定的有如下限制
        int leftEnd = nums.length - 4;  // 后面最起码还有3个数
        int secondEnd = nums.length - 3;  // 后面最起码还有2个数
        for (int left = 0; left <= leftEnd; left++) {
            // 剪枝
            if (nums[left] > (target / 4)) break;
            for (int second = left + 1; second <= secondEnd; second++) {
                int third = second + 1;
                int right = nums.length - 1;
                // 剪枝
                if (nums[left] + nums[second] + nums[right - 1] + nums[right] < target) continue;
                // [second+1,right]之间找符合的两个数字
                while (third < right){
                    // 如果存在溢出,则考虑换成long
                    int sum = nums[left] + nums[second] + nums[third] + nums[right];
                    if (sum < target){
                        third++;
                    }else if (sum > target){
                        right--;
                    }else{
                        result.add(Arrays.asList(nums[left],nums[second],nums[third],nums[right]));
                        // 去重剪枝
                        while (third < right && nums[third] == nums[third + 1]) third++;
                        third++;
                        while (right > third && nums[right] == nums[right - 1]) right--;
                        right--;
                    }
                }
                // 去重剪枝
                while (second < secondEnd && nums[second] == nums[second + 1]) second++;
            }
            // 去重剪枝
            while (left < leftEnd && nums[left] == nums[left + 1]) left++;
        }
        return result;
    }
}
