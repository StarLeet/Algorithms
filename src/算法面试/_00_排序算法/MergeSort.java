package 算法面试._00_排序算法;

import _0_Tools.Integers;

/**
 * @ClassName MergeSort
 * @Description  归并排序
 * @Author StarLee
 * @Date 2022/4/11
 */

public class MergeSort {
    private Integer[] leftArr;
    public void mergeSort(Integer[] arr){
        if (arr == null || arr.length <= 1) return;
        leftArr = new Integer[arr.length >> 1];
        mergeSort(arr,0,arr.length);
    }

    private void mergeSort(Integer[] arr, int begin, int end){
        if (end - begin == 1) return;
        int mid = (begin + end) >> 1;
        mergeSort(arr,begin,mid);
        mergeSort(arr,mid,end);
        merge(arr,begin,mid,end);
    }
    // 1 4 5     2 3 8
    private void merge(Integer[] arr, int begin, int mid, int end){
        int length = mid - begin;
        System.arraycopy(arr,begin,leftArr,0,length);
        int curIndex = 0;
        while (curIndex < length){
            if (mid < end && leftArr[curIndex] > arr[mid]){
                arr[begin++] = arr[mid++];
            }else {
                arr[begin++] = leftArr[curIndex++];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] ints = Integers.random(50, 1, 10000);
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(ints);
        System.out.println();
    }
}
