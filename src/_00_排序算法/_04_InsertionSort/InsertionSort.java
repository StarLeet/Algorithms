package _00_排序算法._04_InsertionSort;

import _00_排序算法._05_BinarySearch.BinarySearch;

/**
 * @ClassName InsertionSort
 * @Description  插入排序,插入排序是先在首部形成局部有序的队列,冒泡是尾部
 * @Author StarLee
 * @Date 2021/12/10
 */
@SuppressWarnings("all")
public class InsertionSort {
    private final Integer[] array;

    public InsertionSort(Integer[] array) {
        this.array = array;
    }

    public void sort(){
        /*  0前面没有元素可以插入,所以从1开始排序 */
        for (int beginIndex = 1; beginIndex < array.length; beginIndex++) {
            int currentElement = array[beginIndex];  // 备份当前插入元素
            int insertIndex = beginIndex;  //插入索引先初始化为插入元素的索引
            /* while让插入元素不断跟前一个元素比较,
            *  遇到比它大的元素就让其后移,最后插入空出来的位置
            *  */
            while(insertIndex > 0 && currentElement < array[insertIndex - 1]){
                array[insertIndex] = array[insertIndex - 1];  // 后移操作
                insertIndex--;
            }
            array[insertIndex] = currentElement; //插入空位
        }
    }

    /**
     *  @MethodName sort_Binary
     *  @Description 用二叉查找减少比较次数(插入排序在数组首部先形成局部有序队列,满足二叉搜索条件)
     *  @Param []
     *  @return void
     */
    public void sort_Binary(){
        for (int beginIndex = 1; beginIndex < array.length; beginIndex++) {
            int currentElement = array[beginIndex];  //记录被选元素,后续因后移,会被前面元素覆盖
            int insertIndex = new BinarySearch(array).searchIndex(beginIndex);
            // 从后往前进行元素后移 移动区间[insertIndex,beginIndex)
//            for (int start = beginIndex; start > insertIndex; start--) {
//                array[start] = array[start - 1];
//            }
//            array[insertIndex] = currentElement;
            insert(beginIndex,insertIndex);
        }
    }

    /**
     * 将source位置的元素插入到dest位置
     */
    private void insert(int source, int dest){
        int v = array[source];
        // 将 [insertIndex, begin)范围内的元素往右边挪动一个单位
        for(int i = source; i > dest; i--){
            array[i] = array[i - 1];
        }
        array[dest] = v;
    }
}
