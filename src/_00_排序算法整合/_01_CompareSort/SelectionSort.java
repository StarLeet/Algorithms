package _00_排序算法整合._01_CompareSort;

import _00_排序算法整合.AbstractSort;

/**
 * @ClassName SelectionSort
 * @Description
 * @Author StarLee
 * @Date 2021/12/8
 */
@SuppressWarnings("all")
public class SelectionSort<T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    protected void sort() {
        int tmp = 0;
        // 一次for循环,可以在数组末尾固定一个最大值(也就是排好序的元素)
        for (int endIndex = array.length - 1; endIndex > 0; endIndex--) {
            int maxIndex = 0;   // 默认每次遍历索引0的值最大,所以可以直接从1开始比较
            for (int cmpIndex = 1; cmpIndex <= endIndex; cmpIndex++) {
                if (cmp(cmpIndex,maxIndex) > 0){
                    maxIndex = cmpIndex;  //遍历数组找出最大值的索引
                }
            }
            swap(maxIndex,endIndex);
        }
    }
}
