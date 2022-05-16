package _99_代码随想录._08_回溯._02_子集;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName _90_子集II
 * @Description
 * @Author StarLee
 * @Date 2022/5/14
 */
public class _90_子集II {

    private List<List<Integer>> result;
    private List<Integer> choose;
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        // 空集是所有集合的子集
        result.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return result;
        choose = new ArrayList<>();
        Arrays.sort(nums);
        this.nums = nums;
        dfs(0);
        return result;
    }

    private void dfs(int startIndex){
        if (startIndex == nums.length){
            return;
        }
        // 1 2 2 2 3
        for (int i = startIndex; i < nums.length; i++) {
            choose.add(nums[i]);
            result.add(new ArrayList<>(choose));
            dfs(i + 1);
            choose.remove(choose.size() - 1);
            // 和组合II思想一样
            while ((i < nums.length - 1) && nums[i] == nums[i + 1]) i++;
        }
    }
}
