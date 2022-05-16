package _99_代码随想录._05_双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName _15_三数之和
 * @Description
 * @Author StarLee
 * @Date 2022/5/2
 */
public class _15_三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        int leftEnd = nums.length - 3;
        for (int left = 0; left <= leftEnd; left++) {
            // 全为正数则不可能再出现三数和为0
            if (nums[left] > 0) return result;
            int cur = left + 1;
            int right = nums.length - 1;
            while (cur < right) {
                int sum = nums[left] + nums[cur] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    cur++;
                } else {
                    // -5 -5 -5 -5 -3 -3 -2 -2 -1 0 3 4 5 6 8 10 10 10
                    result.add(Arrays.asList(nums[left], nums[cur], nums[right]));
                    // 去重
                    while (cur < right && nums[cur] == nums[cur + 1]) cur++;
                    cur++;
                    while (right > cur && nums[right] == nums[right - 1]) right--;
                    right--;
                }
            }
            // 去重
            while(left < leftEnd && nums[left] == nums[left + 1]) left++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        new _15_三数之和().threeSum(arr);
    }
}
