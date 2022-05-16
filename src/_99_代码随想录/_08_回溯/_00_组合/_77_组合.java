package _99_代码随想录._08_回溯._00_组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName _77_组合
 * @Description
 * @Author StarLee
 * @Date 2022/5/10
 */
public class _77_组合 {
    private List<List<Integer>> result;
    private LinkedList<Integer> choose;
    private int maxDepth;
    private int maxValue;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        if (n < k) {
            return result;
        }
        choose = new LinkedList<>();
        maxDepth = k;
        maxValue = n;
        dfs(0,1);
        return result;
    }

    /**
     * [0,k-1]层用来选择元素,第k层用来存放当前结果,所以一共选择了(k-1)-0+1个元素
     * 剪枝：只要当前所剩的元素数量少于还需要选的元素数量,dfs就需要退出了
     */
    private void dfs(int curDepth, int minValue){
        if (curDepth == maxDepth){
            // 存放结果
            result.add(new ArrayList<>(choose));
            return;
        }
        // 选择当前层的元素,比如n位数中的第2位的元素
        for (int i = minValue; i <= maxValue; i++) {
            // 可选元素数量 < 还需要选的元素个数
            if ((maxValue - i + 1) < (maxDepth - curDepth)) {
                break;
            }
            // 处理节点
            choose.add(i);
            dfs(curDepth + 1,i + 1);
            // 撤销操作
            choose.removeLast();
        }
    }

    public static void main(String[] args) {
        new _77_组合().combine(4,2);
    }
}
