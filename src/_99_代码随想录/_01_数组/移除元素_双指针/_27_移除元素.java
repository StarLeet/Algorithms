package _99_代码随想录._01_数组.移除元素_双指针;

/**
 * @ClassName _27_移除元素
 * @Description
 * @Author StarLee
 * @Date 2022/4/12
 */

public class _27_移除元素 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int curIndex = 0;
        //  1 3 4 3 4
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[curIndex++] = nums[i];
            }
        }
        return curIndex;
    }

    public static void main(String[] args) {
        _27_移除元素 v = new _27_移除元素();
        v.removeElement(new int[]{4,5},5);
    }
}
