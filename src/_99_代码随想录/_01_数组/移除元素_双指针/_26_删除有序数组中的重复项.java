package _99_代码随想录._01_数组.移除元素_双指针;

/**
 * @ClassName _26_删除有序数组中的重复项
 * @Description
 * @Author StarLee
 * @Date 2022/4/12
 */

public class _26_删除有序数组中的重复项 {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 1) return nums.length;
        int slow = 0;
        // 1 2 2 3 3 3 4 5
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]){
                nums[++slow] = nums[fast];   // 不同时,将新异项放到该项后
            }
        }
        return slow + 1;
    }
}
