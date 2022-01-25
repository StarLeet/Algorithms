package 算法面试._09_高频题;
// https://leetcode-cn.com/problems/two-sum/

import java.util.HashMap;

/**
 * @ClassName _1_两数之和
 * @Description
 * @Author StarLee
 * @Date 2022/1/18
 */

public class _1_两数之和 {
    /**
     * 给定一个整数数组 nums 和一个整数目标值 target
     * 请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标
     * 注意：数组中同一个元素在答案里不能重复出现
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1]
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return null;
        // hashMap的get是O(1)级别的
        // Key为nums元素值,Value为索引
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 拿到一个值,判断另一个值是否存在与hashMap中
            Integer idx = map.get(target - nums[i]);
            if (idx != null){
                return new int[]{idx,i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
