package _00_排序算法整合._01_CompareSort;

import _00_排序算法整合.AbstractSort;

/**
 * @ClassName MergeSort
 * @Description 归并排序
 * @Author StarLee
 * @Date 2021/12/11
 */
@SuppressWarnings("unchecked")
public class MergeSort <T extends Comparable<T>> extends AbstractSort<T> {
    private T[] leftArray;

    @Override
    protected void sort() {
        leftArray = (T[])new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    private void sort(int beginIndex, int endIndex){
        if(endIndex - beginIndex < 2) return; // 至少要2个元素

        int middle = (beginIndex + endIndex) >> 1;
        sort(beginIndex, middle); // 归并排序左半子序列 [begin,middle)
        sort(middle, endIndex);	// 归并排序右半子序列   [middle,end)
        merge(beginIndex, middle, endIndex); // 合并整个序列
    }

    private void merge(int beginIndex, int middle, int endIndex){
        int lArrayBegin = 0, lArrayEnd = middle - beginIndex; // 左边数组(基于leftArray)
        int rArrayBegin = middle, rArrayEnd = endIndex;	// 右边数组(array)
        int arrayBegin = beginIndex; // array的索引(将来要排序元素插入的位置)
        // 备份左边数组到leftArray
        for(int i = lArrayBegin; i < lArrayEnd; i++){
            leftArray[i] = array[beginIndex + i];
        }

        // 如果左边还没有结束
        while(lArrayBegin < lArrayEnd){ // lArrayBegin == lArrayEnd 左边结束, 则直接结束归并
            if(rArrayBegin < rArrayEnd && cmp(array[rArrayBegin],leftArray[lArrayBegin]) < 0){
                array[arrayBegin++] = array[rArrayBegin++];
            }else{ // 右边>=左边 或者 右边数组没有元素了, 拷贝左边数组到array
                array[arrayBegin++] = leftArray[lArrayBegin++];
            }
        }
    }
}
