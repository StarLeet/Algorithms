package _99_代码随想录._03_哈希;

import java.util.HashMap;

/**
 * @ClassName _1_两数之和
 * @Description
 * @Author StarLee
 * @Date 2022/4/27
 */

public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int otherV = target - nums[i];
            if (map.containsKey(otherV)){
                return new int[]{map.get(otherV),i};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[]{-1,-1};
    }
}
