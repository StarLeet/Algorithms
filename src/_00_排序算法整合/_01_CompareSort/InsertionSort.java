package _00_排序算法整合._01_CompareSort;

import _00_排序算法整合.AbstractSort;

/**
 * @ClassName InsertionSort
 * @Description
 * @Author StarLee
 * @Date 2021/12/10
 */

public class InsertionSort <T extends Comparable<T>> extends AbstractSort<T>{

    @Override
    protected void sort() {
        for (int beginIndex = 1; beginIndex < array.length; beginIndex++) {
            T currentElement = array[beginIndex];  // 记录被选中的插入元素
            int insertIndex = beginIndex;  //记录插入索引
            /* while让被选元素不断跟前一个元素比较,
             *  遇到比它大的元素就让其后移,最后插入空出来的位置
             *  */
            while(insertIndex > 0 && cmp(array[insertIndex - 1],currentElement) > 0){
                array[insertIndex] = array[insertIndex - 1];  // 后移操作
                insertIndex--;
            }
            array[insertIndex] = currentElement; //插入空位
        }
    }
}
