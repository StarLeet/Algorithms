package _99_代码随想录._08_回溯._02_子集;

import java.util.*;

/**
 * @ClassName _698_划分为k个相等的子集
 * @Description
 * @Author StarLee
 * @Date 2022/5/16
 */
public class _698_划分为k个相等的子集 {

    private int[] nums;
    private boolean[] used;
    private int target;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        used = new boolean[nums.length];
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 不可能被分成K个子集
        if (sum % k != 0) return false;
        // 每个子集的和
        target = sum / k;
        // 数组最后一个元素大于target,则说明至少有一个集合的和大于target,返回false
        if (nums[nums.length - 1] > target) return false;
        return dfs(nums.length - 1, 0, k);
    }

    // 1 2 4 4 5 6 8
    public boolean dfs(int begin, int curSum, int k) {
        //剪枝1
        if (k == 1) return true;
        if (curSum == target)
            return dfs(nums.length - 1, 0, k - 1);//找到了一个组合,还有k-1个.
        //剪枝4
        for (int i = begin; i >= 0; i--) {
            //使用过的元素就不能再使用了
            if (used[i])
                continue;
            //剪枝2
            if (curSum + nums[i] > target)
                continue;
            used[i] = true;//添加元素nums[i]
            if (dfs(i - 1, curSum + nums[i], k))
                return true;//如果添加这个元素后，完成了题目要求，就return true.
            used[i] = false;//回溯
            while (i > 0 && nums[i - 1] == nums[i])//剪枝3
                i--;
        }
        return false;
    }
}
