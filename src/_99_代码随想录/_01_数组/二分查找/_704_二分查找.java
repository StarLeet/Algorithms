package _99_代码随想录._01_数组.二分查找;

/**
 * @ClassName _704_二分查找
 * @Description
 * @Author StarLee
 * @Date 2022/4/12
 */

public class _704_二分查找 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int begin = 0,end = nums.length;
        int result = -1;
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
        return result;
    }
}
