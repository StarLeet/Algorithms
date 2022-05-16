package _99_代码随想录._08_回溯._00_组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName _216_组合总和III
 * @Description
 * @Author StarLee
 * @Date 2022/5/11
 */
public class _216_组合总和III {
    private List<List<Integer>> result;
    private LinkedList<Integer> choose;
    private int maxDepth;
    private int maxValue;
    private int sum;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        choose = new LinkedList<>();
        maxDepth = k;
        maxValue = 9;
        sum = n;
        dfs(0,1,0);
        return result;
    }

    private void dfs(int curDepth, int minValue, int curSum){
        if (curDepth == maxDepth){
            if (curSum == sum){
                result.add(new ArrayList<>(choose));
            }
            return;
        }

        for (int i = minValue; i <= maxValue; i++) {
            if ((maxValue - i + 1) < maxDepth - curDepth) break;  // 剩下的元素个数少于需要的元素个数 剪枝
            if (curSum >= sum) break;  // 当前和已经大于最终和了  剪枝
            choose.add(i);
            dfs(curDepth + 1,i + 1,curSum + i);
            choose.removeLast();
        }
    }

    public static void main(String[] args) {
        new _216_组合总和III().combinationSum3(3,7);
    }
}
