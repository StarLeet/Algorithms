package _99_代码随想录._08_回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName _491_递增子序列
 * @Description  这道题跟组合II相似,但是去重方法不能用while了,因为题目不允许排序
 *               本题的关键是每层递归维护一个Set,把当层选择过的元素放进去,下次碰到相同的就跳过
 *               原理是： 1 2 2 3 4   我们可以发现,选择第一个2的时候已经把当前情况遍历完了,再接着选第二个2只会重复
 * @Author StarLee
 * @Date 2022/5/14
 */
public class _491_递增子序列 {

    private List<List<Integer>> result;
    private List<Integer> choose;
    private int[] nums;

    public List<List<Integer>> findSubsequences(int[] nums) {
        result = new ArrayList<>();
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

        HashSet<Integer> set = new HashSet<>();  // 每层维护一个set集合
        for (int i = startIndex; i < nums.length; i++) {
            if (!choose.isEmpty() && choose.get(choose.size() - 1) > nums[i]) continue;
            if (set.contains(nums[i])) continue;  // 判断当层用过这个元素就跳过不选它
            set.add(nums[i]);  // 当前层用过该元素,做记录
            choose.add(nums[i]);
            if (choose.size() > 1) result.add(new ArrayList<>(choose));
            dfs(i + 1);
            choose.remove(choose.size() - 1);
        }
    }

    public static void main(String[] args) {
        new _491_递增子序列().findSubsequences(new int[]{4,6,7,7});
    }
}
