package _99_代码随想录._08_回溯._02_子集;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _78_子集
 * @Description
 * @Author StarLee
 * @Date 2022/5/14
 */
public class _78_子集 {

    private List<List<Integer>> result;
    private List<Integer> choose;
    private int[] nums;
    /**
     * 数组参数各不相同
     */
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        // 一定有空集
        result.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return result;
        choose = new ArrayList<>();
        this.nums = nums;
        dfs(0);
        return result;
    }

    private void dfs(int startIndex){
        if (startIndex == nums.length){
            return;
        }
        // 1 2 3
        for (int i = startIndex; i < nums.length; i++) {
            choose.add(nums[i]);
            // 跟组合很类似,就是将组合问题答案中的每一个子集都加进来
            result.add(new ArrayList<>(choose));
            dfs(i + 1);
            choose.remove(choose.size() - 1);
        }
    }
}
