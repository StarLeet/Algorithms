package _99_代码随想录._01_数组.移除元素_双指针;

/**
 * @ClassName _283_移动零
 * @Description
 * @Author StarLee
 * @Date 2022/4/12
 */

public class _283_移动零 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int slow = 0;
        boolean flag = false;
        // 1 0 0 0 2 3 0
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0){
                nums[slow++] = nums[fast];
            }
        }
        while (slow < nums.length) nums[slow++] = 0;
    }
    // 打乱了相对顺序,所以淘汰
//    public void moveZeroes(int[] nums) {
//        if (nums == null || nums.length <= 1) return;
//        int begin = 0, end = nums.length - 1;
//        while (begin < end){
//            if (nums[begin] == 0){
//                while (end > begin && nums[end] == 0) end--;
//                nums[begin++] = nums[end];
//                nums[end--] = 0;
//            }else {
//                begin++;
//            }
//        }
//    }
}
