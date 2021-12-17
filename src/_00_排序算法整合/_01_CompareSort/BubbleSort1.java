package _00_排序算法整合._01_CompareSort;

import _00_排序算法整合.AbstractSort;

/**
 * @ClassName BubbleSort1
 * @Description
 * @Author StarLee
 * @Date 2021/12/8
 */
@SuppressWarnings("all")
public class BubbleSort1<T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    protected void sort() {
        int tmp = 0;
        for (int endIndex = array.length - 1; endIndex > 0; endIndex--) {
            int headSortedIndex = 1; // 标记记录有序部分的第一个元素索引
            for (int cmpIndex = 1; cmpIndex <= endIndex; cmpIndex++) {
                if (cmp(cmpIndex-1,cmpIndex) > 0) {
                    swap(cmpIndex-1,cmpIndex);
                    headSortedIndex = cmpIndex;  // 当前比较中,大的值被交换到cmpIndex
                    //如果往后都是有序的>array[cmpIndex],那就说明有序部分的head是cmpIndex
                }
            }
            endIndex = headSortedIndex;  //此句之后endIndex--,headSortedIndex的元素被忽略
        }
    }
}
