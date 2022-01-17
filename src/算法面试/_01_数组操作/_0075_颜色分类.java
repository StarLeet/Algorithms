package 算法面试._01_数组操作;
//  https://leetcode-cn.com/problems/sort-colors/

/**
 * @ClassName 颜色分类
 * @Description
 * @Author StarLee
 * @Date 2022/1/6
 */

public class _0075_颜色分类 {
    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，
     * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * */
    // 三指针思想:低位指针，遍历指针，高位指针
    private static void sortColors(int[] nums){
        int index = 0;  //遍历指针
        int left = 0;  //低位指针
        int right = nums.length - 1; //高位指针
        while(index <= right){
            int v = nums[index];
            if (v == 0){  //跟低位指针交换
                nums[index++] = nums[left];
                nums[left++] = v;
            }else if(v == 1){ //跳过
                index++;
            }else {  // v == 2 跟高位指针交换
                nums[index] = nums[right]; //高位换来的有可能还是2,下个循环还得判断
                nums[right--] = v;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,0,1,1,0,2,0,1,2};
        sortColors(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
