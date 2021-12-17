package _00_排序算法整合._01_CompareSort;

import _00_排序算法整合.AbstractSort;

/**
 * @ClassName BubbleSort
 * @Description  未优化冒泡排序
 * @Author StarLee
 * @Date 2021/12/8
 */
@SuppressWarnings("all")
public class BubbleSort<T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    protected void sort() {
        for (int endIndex = array.length - 1; endIndex > 0; endIndex--) {
            for (int cmpIndex = 1; cmpIndex <= endIndex; cmpIndex++) {
                if (cmp(array[cmpIndex-1],array[cmpIndex]) > 0){
                    swap(cmpIndex-1,cmpIndex);
                }
            }
        }
    }
}
