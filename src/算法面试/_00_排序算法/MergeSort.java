package 算法面试._00_排序算法;

import _0_Tools.Asserts;
import _0_Tools.Integers;

import java.util.logging.Level;

/**
 * @ClassName MergeSort
 * @Description  归并排序
 * @Author StarLee
 * @Date 2022/4/11
 */

public class MergeSort {
    private Integer[] rightArr;
    public void mergeSort(Integer[] arr){
        if (arr == null || arr.length <= 1) return;
        rightArr = new Integer[arr.length >> 1];
        mergeSort(arr,0,arr.length);
    }

    private void mergeSort(Integer[] arr, int begin, int end){
        if (end - begin < 2) return;
        int mid = (begin + end) >> 1;
        mergeSort(arr,begin,mid);
        mergeSort(arr,mid,end);
        merge(arr,begin,mid,end);
    }
    // 1 4 5     2 3 8
    private void merge(Integer[] arr, int begin, int mid, int end){
        int curLength = end - mid;  // 继续沿用左闭右开
        // 备份右半部分到备份数组
        System.arraycopy(arr,mid,rightArr,0,curLength);
        // 将备份数组的值还原回去
        while (curLength > 0){
            if (mid > begin && arr[mid - 1] > rightArr[curLength - 1]){
                arr[--end] = arr[--mid];
            }else{
                arr[--end] = rightArr[--curLength];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] ints = Integers.random(100, 1, 10000);
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(ints);
//        for (Integer anInt : ints) {
//            System.out.print(anInt + " ");
//        }
        Asserts.test(Integers.isAscOrder(ints));
    }
}
