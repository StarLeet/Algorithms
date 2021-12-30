package _00_排序算法._07_MergeSort;

/**
 * @ClassName MergeSort
 * @Description  归并排序  拆成小分子,两两合并成有序,得到的大分子再去与别人合并(分化归一)
 * 核心思想：将数组对半拆分至最小,然后两两合并成一个小有序的数组,数组间再合并成更大的...
 * @Author StarLee
 * @Date 2021/12/11
 */

public class MergeSort {
    private final Integer[] array;  // 待排序的数组
    private Integer[] leftArray;  //保存合并时的左半部分元素

    public MergeSort(Integer[] array) {
        this.array = array;
    }

    public void sort(){
        // 准备一段临时的数组空间, 在merge操作中防止左半部分元素被覆盖丢失
        leftArray = new Integer[array.length >> 1];
        sort(0, array.length);
    }

    /**
     * 对 [begin, end) 范围的数据进行归并排序
     */
    private void sort(int beginIndex, int endIndex){
        if(endIndex - beginIndex < 2) return; // 至少要2个元素,才能进行排序

        int middle = (beginIndex + endIndex) >> 1;
        sort(beginIndex, middle); // 归并排序左半子序列 [begin,middle)
        sort(middle, endIndex);	// 归并排序右半子序列   [middle,end)
        merge(beginIndex, middle, endIndex); // 合并整个序列
    }

    /**
     * 将 [begin, middle) 和 [middle, end) 范围的序列合并成一个有序序列
     */
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
            if(rArrayBegin < rArrayEnd && array[rArrayBegin] < leftArray[lArrayBegin]){
                array[arrayBegin++] = array[rArrayBegin++];
            }else{ // 右边>=左边 或者 右边数组没有元素了, 拷贝左边数组到array
                array[arrayBegin++] = leftArray[lArrayBegin++];
            }
        }
    }
}
