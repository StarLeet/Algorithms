package _99_代码随想录._08_回溯._00_组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName _40_组合总和II
 * @Description
 * @Author StarLee
 * @Date 2022/5/11
 */
public class _40_组合总和II {
    private List<List<Integer>> result;
    private int[] numbers;
    private int sum;
    private ArrayList<Integer> choose;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        choose = new ArrayList<>();
        numbers = candidates;
        Arrays.sort(numbers);
        sum = target;
        dfs(0,0);
        return result;
    }

    private void dfs(int curSum, int beginIndex){
        if (curSum == sum){
            result.add(new ArrayList<>(choose));
            return;
        }

        for (int i = beginIndex; i < numbers.length; i++) {
            if (curSum + numbers[i] > sum) break;
            choose.add(numbers[i]);
            dfs(curSum + numbers[i],i + 1);
            choose.remove(choose.size() - 1);
            // 比如 {1,1,5,6,7,8}  在第一个1回溯完成后,第二个1应该被抛弃
            // 因为所有含1的满足的情况都在第一个1的dfs里完成了
            while ((i < numbers.length - 1) && numbers[i] == numbers[i + 1]) i++;  // 跳过紧跟着的相同元素
        }
    }
}
