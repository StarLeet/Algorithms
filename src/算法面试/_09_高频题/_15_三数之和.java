package 算法面试._09_高频题;
// https://leetcode-cn.com/problems/3sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName _15_三数之和
 * @Description
 * @Author StarLee
 * @Date 2022/1/19
 */

public class _15_三数之和 {
    /**
     * 给你一个包含n个整数的数组nums，判断nums中是否存在三个元素a、b、c，使得a + b + c = 0？
     * 请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        // 先将数组进行排序
        Arrays.sort(nums);
        //[-4,-1,-1,0,1,2]
        int endIndex = nums.length - 1;
        int lastIndex = nums.length - 3;
        for (int i = 0; i <= lastIndex; i++) {
            // 去重(选择的第一个数相同,后续的组合也是相同的)
            // [-4,-1,-1,0,1,2] 选择-4后面的-1在计算组合时,也将-1后的-1可能的情况包含计算
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = endIndex;
            // 剩余两数之和
            int remain = -nums[i];
            while (left < right){
                int sum = nums[left] + nums[right];
                if (sum == remain){
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    // 去重(第二个数相同,第三个数显然也相同所以要跳过)
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }else if (sum > remain){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return result;
    }
}
