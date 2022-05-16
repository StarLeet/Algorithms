package _99_代码随想录._08_回溯._00_组合;

import java.util.*;

/**
 * @ClassName _39_组合总和
 * @Description
 * @Author StarLee
 * @Date 2022/5/11
 */
public class _39_组合总和 {
    private List<List<Integer>> result;
    private int[] numbers;
    private int sum;
    private LinkedList<Integer> choose;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        numbers = candidates;
        // 先排序,方便后续剪枝
        Arrays.sort(numbers);
        sum = target;
        choose = new LinkedList<>();
        dfs(0,0);
        return result;
    }

    private void dfs(int curSum, int beginIndex){
        if (curSum == sum){
            result.add(new ArrayList<>(choose));
            return;
        }
        // 组合问题,都是从该值索引往后查找
        // 比如{1,2,3,4}  如果我们第一个数选了2,那么之后的数应该要从2往后找
        // 因为含有1的所有情况已经在前一个循环中找完了,我们在当前循环继续找就会重复
        for (int i = beginIndex; i < numbers.length; i++) {
            // 剪枝,相加的数大于最终的结果,没必要继续叠加
            if (curSum + numbers[i] > sum){
                break;
            }
            choose.add(numbers[i]);
            dfs(curSum + numbers[i],i);
            choose.removeLast();
        }
    }
}
