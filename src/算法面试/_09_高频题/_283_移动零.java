package 算法面试._09_高频题;
// https://leetcode-cn.com/problems/move-zeroes/
/**
 * @ClassName _283_移动零
 * @Description
 * @Author StarLee
 * @Date 2022/1/21
 */

public class _283_移动零 {
    /**
     * 给定一个数组nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
        if (nums == null) return;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            if (cur != i){
                nums[cur] = nums[i];
                nums[i] = 0;
            }
            cur++; // 不能在if中++
        }
    }
}
