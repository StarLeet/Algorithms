package 算法面试._08_DFS;
// https://leetcode-cn.com/problems/permutations-ii/

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _47_全排列II
 * @Description
 * @Author StarLee
 * @Date 2022/1/18
 */

public class _47_全排列II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;
        dfs(0, nums, list);
        return list;
    }

    private void dfs(int depth, int[] nums, List<List<Integer>> list) {
        // 不能再往下搜索
        if (depth == nums.length) {
            List<Integer> result = new ArrayList<>();
            for (int value : nums) {
                result.add(value);
            }
            list.add(result);
            return;
        }

        // 枚举这一层所有可以做出的选择
        for (int i = depth; i < nums.length; i++) {
            // 要保证一个数字在depth位置只会出现一次
            if (isRepeat(nums, depth, i)) continue;
            swap(nums, depth, i);
            dfs(depth + 1, nums, list);
            swap(nums, depth, i);
        }
    }
    private boolean isRepeat(int[] nums, int depth, int i) {
        for (int j = depth; j < i; j++) {
            if (nums[j] == nums[i]) return true;
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
