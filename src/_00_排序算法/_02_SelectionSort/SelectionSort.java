package _00_排序算法._02_SelectionSort;

/**
 * @ClassName SelectionSort
 * @Description  选择排序(实现上跟冒泡类似),直接选最大的放最后
 * @Author StarLee
 * @Date 2021/12/8
 */

public class SelectionSort {
    public static void sort(Integer[] array){
        int tmp = 0;
        // 一次for循环,可以在数组末尾固定一个最大值(也就是排好序的元素)
        for (int endIndex = array.length - 1; endIndex > 0; endIndex--) {
            int maxIndex = 0;   // 默认每次遍历索引0的值最大,所以可以直接从1开始比较
            for (int cmpIndex = 1; cmpIndex <= endIndex; cmpIndex++) {
                if (array[cmpIndex] > array[maxIndex]){
                    maxIndex = cmpIndex;  //遍历数组找出最大值的索引
                }
            }
            tmp = array[maxIndex];
            array[maxIndex] = array[endIndex];
            array[endIndex] = tmp;
        }
    }
}
