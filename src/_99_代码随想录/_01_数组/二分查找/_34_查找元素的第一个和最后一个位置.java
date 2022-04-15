package _99_代码随想录._01_数组.二分查找;

/**
 * @ClassName _34_查找元素的第一个和最后一个位置
 * @Description
 * @Author StarLee
 * @Date 2022/4/12
 */

public class _34_查找元素的第一个和最后一个位置 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if (nums == null || nums.length == 0) return result;
        int begin = 0, end = nums.length;
        // [5,7,7 | 8,8 | 10]
        while (begin < end){  // 左边界
            int mid = (begin + end) >> 1;
            if (nums[mid] >= target){   // 大于等于目标往左
                end = mid;
            }else {
                begin = mid + 1;
            }
        }
        if (begin == nums.length) return result;
        if (nums[begin] == target){  // 不等说明target不存在
            result[0] = begin;
        }else {
            return result;
        }
        end = nums.length;  // 重置end
        while (begin < end){  // 右边界
            int mid = (begin + end) >> 1;
            // 此时begin就是左边界,只存在等于大于target的数
            if (nums[mid] == target){
                begin = mid + 1;
            }else {
                end = mid;
            }
        }
        result[1] = --end;
        return result;
    }
}
