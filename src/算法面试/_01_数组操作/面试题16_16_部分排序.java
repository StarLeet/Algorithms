package 算法面试._01_数组操作;
//  https://leetcode-cn.com/problems/sub-sort-lcci/
/**
 * @ClassName 面试题16_16_部分排序
 * @Description
 * @Author StarLee
 * @Date 2022/1/6
 */

public class 面试题16_16_部分排序 {
    /***
     * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
     * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列
     * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
     * 输出： [3,9]
     */
    private static int[] subSort(int[] array) {
        if (array.length < 2) return new int[]{-1,-1};
        //从左往右扫描逆序对
        int max = array[0]; //要想知道逆序对的右边界,需要知道当前扫描过的最大值
        int right = -1; //记录返回的右边界
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= max){  //碰到更大的值,更新最大值;碰到相等的进行兼容(区间尽可能小)
                max = array[i];
            }else {
                right = i;  // 碰到更小的更新逆序对右边界
            }
        }
        // 不存在逆序对提前退出
        if (right == -1) return new int[]{-1,-1};
        //从右往左扫描逆序对
        int min = array[array.length - 1];//要想知道逆序对的左边界,需要知道当前扫描过的最小值
        int left = -1;  //记录返回的左边界
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] <= min){
                min = array[i];
            }else {
                left = i;
            }
        }
        return new int[]{left,right};
    }

    public static void main(String[] args) {
        int[] arr = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        int[] arr1 = subSort(arr);
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }
}
