package 算法面试._08_DFS;
// https://leetcode-cn.com/problems/permutations/

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _46_全排列
 * @Description
 * @Author StarLee
 * @Date 2022/1/18
 */

public class _46_全排列 {
    public List<List<Integer>> permute(int[] nums) {
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
        // 具体思路可以看PPT,i=depth自动排除了选过的元素
        for (int i = depth; i < nums.length; i++) {
            swap(nums, depth, i);
            dfs(depth + 1, nums, list);
            swap(nums, depth, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
