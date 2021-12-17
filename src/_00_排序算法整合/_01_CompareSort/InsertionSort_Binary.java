package _00_排序算法整合._01_CompareSort;


import _00_排序算法整合.AbstractSort;

/**
 * @ClassName InsertionSort_Binary
 * @Description
 * @Author StarLee
 * @Date 2021/12/10
 */

public class InsertionSort_Binary <T extends Comparable<T>> extends AbstractSort<T> {
    @Override
    protected void sort() {
        for(int beginIndex = 1; beginIndex < array.length; beginIndex++){
            // 将source位置的元素插入到dest位置
            insert(beginIndex, search(beginIndex));
        }
    }

    /**
     * 将source位置的元素插入到dest位置
     */
    private void insert(int source, int dest){
        T v = array[source];
        // 将 [insertIndex, begin)范围内的元素往右边挪动一个单位
        for(int i = source; i > dest; i--){
            array[i] = array[i - 1];
        }
        array[dest] = v;
    }

    /**
     * 利用二分搜索找到index位置元素的待插入位置
     * 已经排好序数组的区间范围是[0，index）
     */
    private int search(int index){
        int begin = 0;
        int end = index;
        while(begin < end){
            int mid = (begin + end) >> 1;
            if(cmp(array[index], array[mid]) < 0){
                end = mid;
            }else{
                begin = mid + 1;
            }
        }
        return begin;
    }
}
