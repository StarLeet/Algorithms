package 算法面试._01_数组操作;
// https://leetcode-cn.com/problems/squares-of-a-sorted-array/
/**
 * @ClassName _0977_有序数组的平方
 * @Description
 * @Author StarLee
 * @Date 2022/1/7
 */
@SuppressWarnings("unused")
public class _0977_有序数组的平方 {
    /***
     * 给你一个按非递减顺序排序的整数数组nums，返回每个数字的平方组成的新数组
     * 要求也按非递减顺序排序
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     */
    // 快速解法,一次遍历,需要额外空间
    private static int[] sortedSquares1(int[] nums){
        int[] numsAfter = new int[nums.length];
        if (nums[0] >= 0){  //发现原数组中没有负数,直接全部平方返回
            for(int i = 0;i < nums.length;i++){
                numsAfter[i] = nums[i] * nums[i];
            }
            return numsAfter;
        }
        int left = 0; //低位指针,从最小负数开始
        int right = nums.length - 1;  //高位指针,从最大正数开始
        int index = right; //返回数组的最大索引
        while (index >= 0){  //返回数组索引为-1表示,原数组已经平方排序完成
            if(nums[left] >= 0){  // 低位指针指向一个正数,说明后面都是正数,直接进行拷贝
                for(int i = right;i >= left;i--){
                    numsAfter[index--] = nums[i] * nums[i];
                }
                break;
            }
            if(Math.abs(nums[left]) <= Math.abs(nums[right])) {  // 低位指针的绝对值不大于高位指针
                numsAfter[index--] = nums[right] * nums[right];  // 将高位指针的平方加入拷贝数组
                right--;
            }else{
                numsAfter[index--] = nums[left] * nums[left];
                left++;
            }
        }
        return numsAfter;
    }
    // 原地排序,相较于前者,多了个数组挪动元素的过程
    private static void sortedSquares(int[] nums){
        if (nums[0] >= 0){
            for(int i = 0;i < nums.length;i++){
                nums[i] *= nums[i];
            }
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            if(Math.pow(nums[left],2) <= Math.pow(nums[right],2)) {
                nums[right] *= nums[right];
                right--;
            }else{
                arrayInsert(nums,left,right--);
            }
        }
    }
    private static void arrayInsert(int[]array, int cur,int dest){
        int curValue = array[cur] * array[cur];
        if (dest - cur >= 0) System.arraycopy(array, cur + 1, array, cur, dest - cur);
        array[dest] = curValue;
    }

    public static void main(String[] args) {
        int[] arr = {-4,-2,-1,0,2,3,10};
//        sortedSquares(arr);
        int[] arr1 = sortedSquares1(arr);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }
}
