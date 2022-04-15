package _99_代码随想录._01_数组.二分查找;

/**
 * @ClassName _35_搜索插入位置
 * @Description
 * @Author StarLee
 * @Date 2022/4/12
 */

public class _35_搜索插入位置 {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int begin = 0, end = nums.length;
        int result = -1;
        // 1 3 5 6
        while (begin < end){
            int mid = (begin + end) >> 1;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                end = mid;
            }else {
                begin = mid + 1;
            }
        }
        if (result == -1){
            result = (begin == nums.length || nums[begin] > target) ? begin : begin + 1;
        }
        return result;
    }
}
