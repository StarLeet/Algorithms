package _99_代码随想录._01_数组.移除元素_双指针;

/**
 * @ClassName _977_有序数组的平方
 * @Description
 * @Author StarLee
 * @Date 2022/4/13
 */

public class _977_有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        if (nums[0] >= 0){
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) continue;
                nums[i] *= nums[i];
            }
            return nums;
        }
        int begin = 0, end = nums.length - 1;
        int[] newArr = new int[nums.length];
        int curIndex = nums.length - 1;
        while (begin <= end){
            if (nums[end] == 0){
                while (nums[begin] < 0 && curIndex >= 0) {
                    newArr[curIndex--] = (int) Math.pow(nums[begin++],2);
                }
                break;
            }else if (nums[begin] == 0) {
                while (nums[end] > 0 && curIndex >= 0){
                    newArr[curIndex--] = (int) Math.pow(nums[end--],2);
                }
                break;
            }else {
                newArr[curIndex--] = Math.abs(nums[begin]) >= Math.abs(nums[end])
                        ? (int) Math.pow(nums[begin++],2) : (int) Math.pow(nums[end--],2);
            }
        }
        return newArr;
    }
}
