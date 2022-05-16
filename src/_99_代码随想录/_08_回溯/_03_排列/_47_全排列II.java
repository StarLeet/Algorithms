package _99_代码随想录._08_回溯._03_排列;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName _47_全排列II
 * @Description
 * @Author StarLee
 * @Date 2022/5/14
 */
public class _47_全排列II {

    private List<List<Integer>> result;
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
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

        // 1 2 2
        for (int i = startIndex; i < nums.length; i++) {
            // [startIndex,i) 之间有跟nums[i]相同的元素,说明重复了
            if (isRepeat(startIndex,i)) continue;
            swap(startIndex,i);
            dfs(startIndex + 1);
            swap(startIndex,i);
        }
    }

    private boolean isRepeat(int startIndex, int curIndex){
        for (int i = startIndex; i < curIndex; i++) {
            if (nums[i] == nums[curIndex]) return true;
        }
        return false;
    }

    private void swap(int startIndex, int curIndex){
        int tmp = nums[startIndex];
        nums[startIndex] = nums[curIndex];
        nums[curIndex] = tmp;
    }
}
