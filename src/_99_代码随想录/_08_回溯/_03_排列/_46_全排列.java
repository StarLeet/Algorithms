package _99_代码随想录._08_回溯._03_排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _46_全排列
 * @Description  全排列这个方法非常巧妙,甚至不需要借助choose,直接在原数组上进行(搭配 集.txt理解)
 * @Author StarLee
 * @Date 2022/5/14
 */
public class _46_全排列 {

    private List<List<Integer>> result;
    private int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        // 正常回溯开头
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        this.nums = nums;
        dfs(0);
        return result;
    }

    private void dfs(int startIndex){
        if (startIndex == nums.length){
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }
        /*  将每层中的元素皆与本层开始元素进行交换,然后从下一索引开始
            比如： 1 2 3   遍历完1后 {123}{132}
            到2时，与本层首元素交换 2 1 3，即相当于第一个元素被天然地换成了2，然后我们从1开始继续找
            这样就天然地排除了重复选择2的情况
         */
        for (int i = startIndex; i < nums.length; i++) {
            swap(startIndex,i);
            dfs(startIndex + 1);
            swap(startIndex,i);
        }
    }

    private void swap(int prevIndex, int curIndex){
        int tmp = nums[prevIndex];
        nums[prevIndex] = nums[curIndex];
        nums[curIndex] = tmp;
    }
}
